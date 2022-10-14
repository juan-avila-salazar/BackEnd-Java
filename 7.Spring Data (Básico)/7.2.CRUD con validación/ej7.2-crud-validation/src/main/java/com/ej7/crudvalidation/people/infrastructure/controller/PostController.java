package com.ej7.crudvalidation.people.infrastructure.controller;

import com.ej7.crudvalidation.exceptions.UnprocessableEntityException;
import com.ej7.crudvalidation.people.application.PersonService;
import com.ej7.crudvalidation.people.domain.Person;
import com.ej7.crudvalidation.people.infrastructure.dto.PersonDtoIn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = ("/person"))
public class PostController {
    @Autowired
    private PersonService personService;

    @PostMapping(value = "/add")
    public void addPerson(@RequestBody PersonDtoIn person) throws UnprocessableEntityException {
        personService.addPerson(new Person(person));
    }

}
/*
{
    "usuario":"person1",
    "password":"biugiuub",
    "name":"Juan",
    "surname":"Avila",
    "company_email":"juan@bosonit.com",
    "personal_email":"belial@gmail.com",
    "city":"Madrid",
    "active":true,
    "created_date":"2022-09-01",
    "imagen_url":"https://minneapolisseo1.blogspot.com/2014/10/paisajes-naturales-12-nuevas-imagenes.html",
    "termination_date":null
}
{
    "usuario":"person2",
    "password":"ykuygiulg",
    "name":"Jaqueline",
    "surname":"Rubio",
    "company_email":"jaqueline@nissan.com",
    "personal_email":"rubio@gmail.com",
    "city":"Madrid",
    "active":true,
    "created_date":"2022-09-01",
    "imagen_url":"https://loquesea.com",
    "termination_date":null
}
*/