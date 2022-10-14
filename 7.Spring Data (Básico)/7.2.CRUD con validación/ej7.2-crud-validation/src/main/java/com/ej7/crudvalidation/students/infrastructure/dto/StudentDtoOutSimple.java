package com.ej7.crudvalidation.students.infrastructure.dto;

import com.ej7.crudvalidation.subjects.domain.Subjects;
import com.ej7.crudvalidation.students.domain.Student;
import lombok.Data;

import java.util.List;

@Data
public class StudentDtoOutSimple extends StudentDtoOut{
    private String id_student;
    private Integer num_hours_week;
    private String coments;
    private String branch;
    private List<Subjects> subjectList;

    public StudentDtoOutSimple(Student student){
        id_student = student.getStudent_id();
        num_hours_week = student.getNum_hours_week();
        coments = student.getComents();
        branch = student.getBranch();
        subjectList=student.getSubjectsList();
    }
}
