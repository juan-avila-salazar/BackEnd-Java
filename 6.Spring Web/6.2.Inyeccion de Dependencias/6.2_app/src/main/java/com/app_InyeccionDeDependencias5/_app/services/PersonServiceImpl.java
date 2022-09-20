package com.app_InyeccionDeDependencias5._app.services;

import com.app_InyeccionDeDependencias5._app.models.PersonModel;
import org.springframework.stereotype.Service;

@Service
public class PersonServiceImpl implements PersonService{
   // private PersonModel personModel;

    @Override
    public PersonModel viewperson(String name, String city, int age) {
        PersonModel p1 = new PersonModel(name, city, age);
        return p1;
    }

    @Override
    public void getPerson(PersonModel personModel){

    }
}
