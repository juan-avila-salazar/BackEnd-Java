package com.ej7.crudvalidation.teachers.domain;

import com.ej7.crudvalidation.people.domain.Person;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "TeacherTable")
public class Teacher implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer teacher_id;
    @OneToOne
    @JoinColumn(name = "Person_Id")
    Person person;
    @Column(name = "Coments")
    private String coments;
    @Column(name = "Branch")
    String branch;
}
