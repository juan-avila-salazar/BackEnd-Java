package com.ej7.crudvalidation.people.infrastructure.controller;

import com.ej7.crudvalidation.exceptions.EntityNotFoundException;
import com.ej7.crudvalidation.people.application.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/person")
public class DeleteControler {
    @Autowired
    private PersonService personService;

    @DeleteMapping(value = "delete/{id}")
    public void deletePerson(@PathVariable("id") Integer id) throws EntityNotFoundException {
        personService.deletePerson(id);
    }
}
