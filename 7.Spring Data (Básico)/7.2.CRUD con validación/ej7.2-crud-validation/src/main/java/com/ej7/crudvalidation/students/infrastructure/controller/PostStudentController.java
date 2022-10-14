package com.ej7.crudvalidation.students.infrastructure.controller;

import com.ej7.crudvalidation.exceptions.UnprocessableEntityException;
import com.ej7.crudvalidation.students.application.StudentService;
import com.ej7.crudvalidation.students.domain.Student;
import com.ej7.crudvalidation.students.infrastructure.dto.StudentDtoIn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = ("/student"))
public class PostStudentController {
    @Autowired
    private StudentService studentService;

    /*@PostMapping(value = "/add")
    public void addStudent(@RequestBody StudentDtoIn student) throws UnprocessableEntityException {
        try {
            studentService.addStudent(new Student(student));
        } catch (com.ej7.crudvalidation.exceptions.EntityNotFoundException e) {
            throw new RuntimeException(e);
        }
    }*/
}
