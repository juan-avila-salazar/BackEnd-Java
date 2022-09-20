package com.ej5.commandlinerunner;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component

public class Init {
    @PostConstruct
    public void Message1(){
        System.out.println("Hola desde clase Inicial");
    }
    public void Message2(){
        System.out.println("Hola desde clase secundaria");
    }
    public void Message3(){
        System.out.println("Soy la tercera clase");
    }

}
