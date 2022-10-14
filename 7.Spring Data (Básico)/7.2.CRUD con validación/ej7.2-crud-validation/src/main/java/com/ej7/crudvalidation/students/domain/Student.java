package com.ej7.crudvalidation.students.domain;

import com.ej7.crudvalidation.people.domain.Person;
import com.ej7.crudvalidation.students.infrastructure.dto.StudentDtoIn;
import com.ej7.crudvalidation.subjects.domain.Subjects;
import com.ej7.crudvalidation.teachers.domain.Teacher;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.security.auth.Subject;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "StudentTable")
public class Student implements Serializable {
    @Id
    @GeneratedValue(generator = "student-generator")
    @GenericGenerator(name = "student-generator",
    parameters = @org.hibernate.annotations.Parameter(name = "prefijo", value = "student"),
    strategy = "com.ej7.crudvalidation.MiGenerador")
    private String student_id;
    @OneToOne
    @JoinColumn(name = "Person_Id")
    Person person;
    @Column(name = "Hours_for_week")
    Integer num_hours_week;
    @Column(name = "Comments")
    String coments;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Teacher_Id")
    Teacher teacher;
    @Column(name = "Branch")
    String branch;
    @OneToMany
    List<Subjects> subjectsList;
    @ManyToMany
    @JoinTable(name = "asignaturas_estudiantes",
            joinColumns = @JoinColumn(name = "Student_id"),
            inverseJoinColumns = @JoinColumn(name = "Subject_id"),
            uniqueConstraints = @UniqueConstraint(name = "NoRepiteEstuAsig",columnNames={"Student_id", "Subject_id"}))
    @JsonManagedReference
    private List<Subject> subjectList=new ArrayList<>();

    //EMPTY BUILDER
    public Student(){}

    //BUILDER BY INPUT
    public Student(StudentDtoIn studentIn){
        num_hours_week = studentIn.getNum_hours_week();
        coments = studentIn.getComents();
        branch = studentIn.getBranch();
    }
}
