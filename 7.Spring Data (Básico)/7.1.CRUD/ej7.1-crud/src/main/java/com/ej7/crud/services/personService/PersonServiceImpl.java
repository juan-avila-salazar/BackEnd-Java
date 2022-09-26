package com.ej7.crud.services.personService;

import com.ej7.crud.model.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PersonServiceImpl implements PersonService{
    @Bean("beanPersonList")
    public List<Person> peopleList() {
        List<Person> peopleList = new ArrayList<>();
        return peopleList;
    }
}
