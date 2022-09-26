package com.ej7.crud.controllers;

import com.ej7.crud.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/person")
public class PutPersonController {
    @Autowired
    @Qualifier("beanPersonList")
    List<Person> peopleList;

    @PutMapping("/modify/{id}")
    public String modify (@PathVariable ("id")int id, @RequestBody Person person){
        if(person.getName()!=null){peopleList.get( id).setName(person.getName());}
        if(person.getAge()!=0){peopleList.get( id).setAge(person.getAge());}
        if(person.getCity()!=null){peopleList.get( id).setCity(person.getCity());}
        return "Modified person";
    }
}
