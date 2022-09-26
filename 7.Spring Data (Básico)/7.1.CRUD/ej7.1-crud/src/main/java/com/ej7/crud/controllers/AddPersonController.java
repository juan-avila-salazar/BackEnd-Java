package com.ej7.crud.controllers;

import com.ej7.crud.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/person")
public class AddPersonController {
    @Autowired
    @Qualifier("beanPersonList")
    List<Person> peopleList;

    @PostMapping("/add")
    public String addPerson(@RequestBody Person person){
        peopleList.add(person);
        return "Added person";
    }
}
