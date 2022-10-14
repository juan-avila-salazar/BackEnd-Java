package com.ej7.crudvalidation.people.domain;

import com.ej7.crudvalidation.people.infrastructure.dto.PersonDtoIn;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity
@Table(name = "PersonTable")
public class Person implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer person_id;

    @Column(name = "UserName")
    private String userName;

    @Column(name = "Password")
    private String password;

    @Column(name = "Name")
    private String name;

    @Column(name = "Surname")
    private String surname;

    @Column(name = "Company_Email")
    private String company_email;

    @Column(name = "Personal_Email")
    private String personal_email;

    @Column(name = "City")
    private String city;

    @Column(name = "Active")
    private Boolean active;

    @Column(name = "Created_Date")
    private Date created_date;

    @Column(name = "Imagen")
    private String imagen_url;

    @Column(name = "Termination_Date")
    private Date termination_date;

    //EMPTY BUILDER
    public Person() {}

    //BUILDER BY INPUT
    public Person(PersonDtoIn personIn){
        person_id = personIn.getPerson_id();
        userName = personIn.getUserName();
        password = personIn.getPassword();
        name = personIn.getName();
        surname = personIn.getSurname();
        company_email = personIn.getCompany_email();
        personal_email = personIn.getPersonal_email();
        city = personIn.getCity();
        active = personIn.getActive();
        created_date = personIn.getCreated_date();
        imagen_url = personIn.getImagen_url();
        termination_date = personIn.getTermination_date();
    }
}
