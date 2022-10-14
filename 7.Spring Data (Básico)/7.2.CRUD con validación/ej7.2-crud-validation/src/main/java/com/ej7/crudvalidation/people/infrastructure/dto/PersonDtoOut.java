package com.ej7.crudvalidation.people.infrastructure.dto;

import com.ej7.crudvalidation.people.domain.Person;
import lombok.Getter;
import java.util.Date;
@Getter
public class PersonDtoOut {
    private final Integer person_id;
    private final String userName;
    private final String name;
    private final String surname;
    private final String company_email;
    private final String personal_email;
    private final String city;
    private final Boolean active;
    private final Date created_date;
    private final String imagen_url;
    private final Date termination_date;

    public PersonDtoOut(Person person){
        person_id = person.getPerson_id();
        userName = person.getUserName();
        name = person.getName();
        surname = person.getSurname();
        company_email = person.getCompany_email();
        personal_email = person.getPersonal_email();
        city = person.getCity();
        active = person.getActive();
        created_date = person.getCreated_date();
        imagen_url = person.getImagen_url();
        termination_date = person.getTermination_date();
    }
}
