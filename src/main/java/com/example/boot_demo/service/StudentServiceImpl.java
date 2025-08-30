package com.example.boot_demo.service;

import com.example.boot_demo.converter.StudentConverter;
import com.example.boot_demo.dao.Student;
import com.example.boot_demo.dao.StudentRepository;
import com.example.boot_demo.dto.StudentDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

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


}

