package com.example.boot_demo.controller;

import com.example.boot_demo.Response;
import com.example.boot_demo.dto.StudentDTO;
import com.example.boot_demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/student/{id}")
    public Response<StudentDTO> getStudentById(@PathVariable Long id) {
        return Response.newSuccess(studentService.getStudentById(id));
    }


    @PostMapping("/student")
    public Response<Long> addNewStudent(@RequestBody StudentDTO studentDTO) {
        // 移除多余的getStudentById调用，直接返回新增学生的ID
        return Response.newSuccess(studentService.addNewStudent(studentDTO));
    }
}



