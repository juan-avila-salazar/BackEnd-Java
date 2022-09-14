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
        person1.setName("juan");
        person1.setCity("Madrid");
        person1.setAge(21);
        return person1;
    }


    @GetMapping("/bean/bean2")
    @Qualifier("Bean2")
    public PersonModel getBean2(){
        PersonModel person2 = new PersonModel();
        person2.setName("jaqueline");
        person2.setCity("madrid");
        person2.setAge(56);
        return person2;
    }

    @GetMapping("/bean/bean3")
    @Qualifier("Bean3")
    public PersonModel getBean3(){
        PersonModel person3 = new PersonModel();
        person3.setName("franyer");
        person3.setCity("madrid");
        person3.setAge(34);
        return person3;
    }



}