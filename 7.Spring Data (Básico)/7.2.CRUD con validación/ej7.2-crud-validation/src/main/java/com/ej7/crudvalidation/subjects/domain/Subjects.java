package com.ej7.crudvalidation.subjects.domain;

import com.ej7.crudvalidation.students.domain.Student;
import com.ej7.crudvalidation.teachers.domain.Teacher;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity
@Table
public class Subjects implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id_study;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Teacher_id")
    Teacher teacher;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_student")
    Student student;
    @Column(name = "Course")
    String asignatura;
    @Column(name = "Comments")
    String comment;
    @Column(name = "Initial_Date")
    Date initial_date;
    @Column(name = "Finish_Date")
    Date finish_date;

}
