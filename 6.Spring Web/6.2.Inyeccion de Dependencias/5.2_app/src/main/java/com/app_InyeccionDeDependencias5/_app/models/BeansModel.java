package com.app_InyeccionDeDependencias5._app.models;

import com.app_InyeccionDeDependencias5._app.repositories.PersonRepository;
import org.springframework.context.annotation.Bean;

public class BeansModel {
    @Bean
    public PersonModel getBean1(){
        PersonModel person1=new PersonModel();
        return person1;
    }


    @Bean
    public PersonModel getBean2() {
        PersonModel person2 = new PersonModel();
        return person2;
    }

    @Bean
    public PersonModel getBean3(){
        PersonModel person3 = new PersonModel();
        return person3;
    }
}
