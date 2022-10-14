package com.ej7.crudvalidation.students.infrastructure.controller;

import com.ej7.crudvalidation.exceptions.EntityNotFoundException;
import com.ej7.crudvalidation.students.application.StudentService;
import com.ej7.crudvalidation.students.infrastructure.dto.StudentDtoOut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.FileNotFoundException;
import java.util.List;

@RestController
@RequestMapping(value = "/student")
public class GetStudentController {
    @Autowired
    StudentService studentService;

    //@GetMapping(value = "/all")
    //public List<StudentDtoOut> getStudents(){
        //return studentService.getAllStudent();
    //}

    //@GetMapping(value = "/id/{id}")
    //public StudentDtoOut showStudentById(@RequestParam(name = "outputType",defaultValue = "simple") String outputType, @PathVariable("id")Integer id) throws EntityNotFoundException, FileNotFoundException{
        //return outputType.equals("full")?
                //studentService.getStudentById(id):
                //studentService.getStudentByIdSimple(id);
    //}

}
