package com.ej7.crud.controllers;

import com.ej7.crud.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/person")
public class ListPeopleController {
    @Autowired
    @Qualifier("beanPersonList")
    List<Person> peopleList;

    @GetMapping("/fullList")
    public List<Person> getPeopleList (){
        return peopleList;
    }

    @GetMapping("/search_id/{id}")
    public Person getFiltredId (@PathVariable("id") int id){
        Person filtredIdList = peopleList.get(id);
        return filtredIdList;
    }

    @GetMapping("/search_name/{name}")
    public List<Person> getFiltredName (@PathVariable("name")String name){
        List<Person> filtredListName = peopleList.stream().filter((p)->p.getName().equals(name)).toList();
        return filtredListName;
    }
}
