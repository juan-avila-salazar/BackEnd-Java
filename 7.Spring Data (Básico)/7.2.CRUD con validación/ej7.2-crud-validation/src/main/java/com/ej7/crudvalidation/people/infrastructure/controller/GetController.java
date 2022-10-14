package com.ej7.crudvalidation.people.infrastructure.controller;

import com.ej7.crudvalidation.exceptions.EntityNotFoundException;
import com.ej7.crudvalidation.people.application.PersonService;
import com.ej7.crudvalidation.people.infrastructure.dto.PersonDtoOut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileNotFoundException;
import java.util.List;

@RestController
@RequestMapping(value = "/person")
public class GetController {

    @Autowired
    PersonService personService;

    @GetMapping(value = "/all")
    public List<PersonDtoOut> getPeople(){
        return personService.getAllPeople();
    }

    @GetMapping(value = "/id/{id}")
    public PersonDtoOut showPersonById (@PathVariable("id")Integer id) throws EntityNotFoundException, FileNotFoundException {
        return new PersonDtoOut(personService.getPersonById(id));
    }

    @GetMapping(value = "usuario/{usuario}")
    public List<PersonDtoOut> getStudentsByUserName(@PathVariable("usuario")String usuario){
        return personService.getPersonByUsuario(usuario);
    }
}
