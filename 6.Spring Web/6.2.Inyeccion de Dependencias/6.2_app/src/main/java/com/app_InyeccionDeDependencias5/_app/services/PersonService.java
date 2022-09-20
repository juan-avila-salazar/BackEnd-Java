package com.app_InyeccionDeDependencias5._app.services;


import com.app_InyeccionDeDependencias5._app.models.PersonModel;

public interface PersonService {

    public PersonModel viewperson(String name, String city, int age);

    public void getPerson(PersonModel personModel);
}
