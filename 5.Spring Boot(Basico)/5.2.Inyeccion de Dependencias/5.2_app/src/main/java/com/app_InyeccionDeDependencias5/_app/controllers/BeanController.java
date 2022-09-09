package com.app_InyeccionDeDependencias5._app.controllers;

import com.app_InyeccionDeDependencias5._app.models.PersonModel;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("controlador")
public class BeanController {

    PersonModel personModel;

    @GetMapping("/bean/bean1")
    @Qualifier("Bean1")
    public PersonModel getBean1(){
        PersonModel person1=new PersonModel();
        person1.setName("Luis Daniel");
        person1.setCity("Madrid");
        person1.setAge(34);
        return person1;
    }


    @GetMapping("/bean/bean2")
    @Qualifier("Bean2")
    public PersonModel getBean2(){
        PersonModel person2 = new PersonModel();
        person2.setName("Daniella");
        person2.setCity("Barcelona");
        person2.setAge(4);
        return person2;
    }

    @GetMapping("/bean/bean3")
    @Qualifier("Bean3")
    public PersonModel getBean3(){
        PersonModel person3 = new PersonModel();
        person3.setName("Delany");
        person3.setCity("Sevilla");
        person3.setAge(32);
        return person3;
    }



}