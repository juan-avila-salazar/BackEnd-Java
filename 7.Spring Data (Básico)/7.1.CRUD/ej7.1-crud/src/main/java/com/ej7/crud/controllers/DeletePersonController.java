package com.ej7.crud.controllers;

import com.ej7.crud.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/person")
public class DeletePersonController {

    @Autowired
    @Qualifier("beanPersonList")
    List<Person> peopleList;

    @DeleteMapping("deleteById/{id}")
    public String deleteById(@PathVariable("id") int id){
        peopleList.remove(id);
        return "Deleted person";
    }
}
