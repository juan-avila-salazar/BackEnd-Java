package com.ej7.crudvalidation.people.infrastructure.dto;

import lombok.Data;

import java.util.Date;

@Data
public class PersonDtoIn {

    private final Integer person_id;
    private final String userName;
    private String password;
    private final String name;
    private final String surname;
    private final String company_email;
    private final String personal_email;
    private final String city;
    private final Boolean active;
    private final Date created_date;
    private final String imagen_url;
    private final Date termination_date;

}
