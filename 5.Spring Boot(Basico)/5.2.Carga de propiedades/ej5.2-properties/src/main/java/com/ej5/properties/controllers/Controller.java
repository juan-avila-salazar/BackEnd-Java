package com.ej5.properties.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    @Value("${greeting}")
    private String hola;

    @Value("${my.number}")
    private String num;

    private String property="new.property no tiene valor";

    @GetMapping("/hola")
    public String View(){
        return "el valor de greeting es:"+ hola + "\n"+"el valor de my.number es :"+num+ "\n"+ "El valor de new.property es: "+property;
    }

}
