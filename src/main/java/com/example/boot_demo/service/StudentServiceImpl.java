package com.example.boot_demo.service;

import com.example.boot_demo.converter.StudentConverter;
import com.example.boot_demo.dao.Student;
import com.example.boot_demo.dao.StudentRepository;
import com.example.boot_demo.dto.StudentDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

@Override
public StudentDTO getStudentById(Long id) {

    Student student = studentRepository.findById(id).orElseThrow(RuntimeException::new);
    StudentDTO studentDTO = StudentConverter.convertStudent(student);
    return studentDTO;
}

@Override
public Long addNewStudent(StudentDTO studentDTO) {

    List<Student> studentlist = studentRepository.findByEmail(studentDTO.getEmail());
    if(!CollectionUtils.isEmpty(studentlist)){
        throw new IllegalStateException("email"+studentDTO.getEmail()+"has been taken");
    }
    Student student = studentRepository.save(StudentConverter.convertStudent(studentDTO));
    return student.getId();
}

    @Override
    public void deleteStudentById(Long id) {
        studentRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("id"+id+"does not exist!"));
        studentRepository.deleteById(id);
    }

    @Override
    @Transactional
    public StudentDTO updateStudentById(Long id, String name, int age, String email) {
        Student studentInDB = studentRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("id" + id + "does not exist!"));

        // 修复name更新条件
        if (StringUtils.hasLength(name) && !studentInDB.getName().equals(name)) {
            studentInDB.setName(name);
        }

        // 修复age判断方式
        if (studentInDB.getAge() != age) {
            studentInDB.setAge(age);
        }

        // 修复email更新条件
        if (StringUtils.hasLength(email) && !studentInDB.getEmail().equals(email)) {
            studentInDB.setEmail(email);
        }

        Student updatedStudent = studentRepository.save(studentInDB);
        return StudentConverter.convertStudent(updatedStudent);
    }


}

