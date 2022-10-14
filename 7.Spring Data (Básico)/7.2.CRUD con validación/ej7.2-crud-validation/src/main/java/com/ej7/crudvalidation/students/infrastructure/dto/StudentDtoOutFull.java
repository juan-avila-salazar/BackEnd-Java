package com.ej7.crudvalidation.students.infrastructure.dto;

import com.ej7.crudvalidation.people.domain.Person;
import com.ej7.crudvalidation.students.domain.Student;
import com.ej7.crudvalidation.subjects.domain.Subjects;
import com.ej7.crudvalidation.teachers.domain.Teacher;
import lombok.Data;

import java.util.List;
@Data
public class StudentDtoOutFull extends StudentDtoOut{
    private Person person;
    private Integer num_hours_week;
    private String coments;
    private String branch;
    private Teacher teacher;
    private List<Subjects> subjectsList;

    public StudentDtoOutFull(Student student){
        person = student.getPerson();
        num_hours_week = student.getNum_hours_week();
        coments = student.getComents();
        branch = student.getBranch();
        teacher = student.getTeacher();
        subjectsList=student.getSubjectsList();

    }
}
