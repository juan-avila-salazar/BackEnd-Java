package com.webHola.ServidorWeb.controllers;

import com.webHola.ServidorWeb.models.Person;
import org.jetbrains.annotations.NotNull;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class PersonController {

    @RequestMapping("/users")
    public List<Person> getPeople(){
        List<Person> users = new ArrayList<>();
        Person person1 = new Person();
        person1.setName("Juan");
        person1.setAge(20);
        person1.setTown("Madrid");

        Person person2 = new Person();
        person2.setName("Jaqueline");
        person2.setAge(56);
        person2.setTown("Madrid");

        Person person3 = new Person();
        person3.setName("Viviana");
        person3.setAge(34);
        person3.setTown("Madrid");

        users.add(person1);
        users.add(person2);
        users.add(person3);
        return users;
    }

    @GetMapping("/user/{name}")
    public String getUser(@PathVariable String name){
        return "Hello "+name;
    }

    @PostMapping("/useradd")
    public Person CreateUser(@RequestBody Person user){
        user.setAge(user.getAge()+1);
        return user;
    }
}
