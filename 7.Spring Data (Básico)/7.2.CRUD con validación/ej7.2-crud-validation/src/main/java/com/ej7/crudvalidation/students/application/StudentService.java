package com.ej7.crudvalidation.students.application;

import com.ej7.crudvalidation.exceptions.EntityNotFoundException;
import com.ej7.crudvalidation.exceptions.UnprocessableEntityException;
import com.ej7.crudvalidation.students.infrastructure.dto.StudentDtoIn;
import com.ej7.crudvalidation.students.infrastructure.dto.StudentDtoOut;
import com.ej7.crudvalidation.students.infrastructure.dto.StudentDtoOutFull;
import com.ej7.crudvalidation.students.infrastructure.dto.StudentDtoOutSimple;
import com.ej7.crudvalidation.subjects.infrastructure.dto.SubjectDtoIn;

import java.io.FileNotFoundException;
import java.util.List;

public interface StudentService {
    //GET
    // FULL PERSON TABLE
    List<StudentDtoOutSimple> getAllStudent();

    StudentDtoOut getStudentById(String id) throws EntityNotFoundException;

    //CRUD//
    //POST
    StudentDtoOutSimple addStudent(StudentDtoIn student) throws UnprocessableEntityException,EntityNotFoundException;

    //GET
    StudentDtoOutFull getStudentByIdFull(String id) throws FileNotFoundException, EntityNotFoundException;
    StudentDtoOutSimple getStudentByIdSimple(String id) throws FileNotFoundException, EntityNotFoundException;
    List<StudentDtoOutSimple> getStudentsByUserName(String userName);
    List<StudentDtoOutSimple> getAllStudents();

    //POST
    StudentDtoOutSimple addStudent(StudentDtoIn student) throws UnprocessableEntityException,EntityNotFoundException;

    //PUT
    StudentDtoOutSimple updateStudent(String id, StudentDtoIn student) throws UnprocessableEntityException, EntityNotFoundException;
    StudentDtoOutSimple addSubjectsToStudent(String student_id, SubjectDtoIn subjects_ids) throws EntityNotFoundException;
    StudentDtoOutSimple deleteSubjectsFromStudent(String student_id, SubjectDtoIn subjects_ids) throws EntityNotFoundException;

    //DELETE
    void deleteStudent(String id) throws EntityNotFoundException;


}
