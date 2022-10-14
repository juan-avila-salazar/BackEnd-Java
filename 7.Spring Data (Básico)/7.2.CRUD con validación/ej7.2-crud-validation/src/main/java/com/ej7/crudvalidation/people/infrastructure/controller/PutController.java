package com.ej7.crudvalidation.people.infrastructure.controller;

import com.ej7.crudvalidation.exceptions.EntityNotFoundException;
import com.ej7.crudvalidation.exceptions.UnprocessableEntityException;
import com.ej7.crudvalidation.people.application.PersonService;
import com.ej7.crudvalidation.people.infrastructure.dto.PersonDtoIn;
import com.ej7.crudvalidation.people.infrastructure.dto.PersonDtoOut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.FileNotFoundException;


@RestController
@RequestMapping(value = ("/person"))
public class PutController {
    @Autowired
    PersonService personService;

    @PutMapping(value = "/edit/{id}")
    public PersonDtoOut editPerson(@PathVariable("id")Integer id, @RequestBody PersonDtoIn person) throws UnprocessableEntityException, EntityNotFoundException, FileNotFoundException {
        return personService.updatePerson(id, person);
    }
}
