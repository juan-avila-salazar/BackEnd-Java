package com.app_InyeccionDeDependencias5._app.controllers;

import com.app_InyeccionDeDependencias5._app.models.PersonModel;
import com.app_InyeccionDeDependencias5._app.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/controlador2")
public class Controlador2 {
    @Autowired
    PersonService servicePerson;

    PersonModel person;

    @GetMapping("/getPerson")
    public PersonModel viewperson(){
        person.setAge(person.getAge() * 2);
        return person;
    }

}
