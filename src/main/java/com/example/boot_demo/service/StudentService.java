package com.example.boot_demo.service;

import com.example.boot_demo.dto.StudentDTO;

public interface StudentService {

    StudentDTO getStudentById(Long id);

    Long addNewStudent(StudentDTO studentDTO);

    void deleteStudentById(Long id);

    Object updateStudentById(Long id, String name, int age, String email);
}
