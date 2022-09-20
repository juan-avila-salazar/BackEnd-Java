package com.app_InyeccionDeDependencias5._app.controllers;

import com.app_InyeccionDeDependencias5._app.models.CityModel;
import com.app_InyeccionDeDependencias5._app.models.PersonModel;
import com.app_InyeccionDeDependencias5._app.services.CityService;
import com.app_InyeccionDeDependencias5._app.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/controlador1")
public class Controlador1 {

    List<CityModel> listCity = new ArrayList<>();

    @Autowired
    PersonService servicioPerson;

    @Autowired
    CityService servicioCiudad;

    PersonModel personModel;

    @GetMapping("/addPerson")
    public PersonModel viewPerson(@RequestHeader Map<String,String> viewPeople){
        personModel= servicioPerson.viewperson(viewPeople.get("name")
                                    ,viewPeople.get("city")
                                    ,Integer.parseInt(viewPeople.get("age")));
        return personModel;
    }

    @PostMapping("/addCiudad")
    public String addNewCity(@RequestBody CityModel city){
       // List<CityModel> listCity = new ArrayList<>();
        listCity.add(city);
        return "Ciudad añadida!";
    }

    @GetMapping("/getCity")
    public List<CityModel> getCity (){
        return listCity;
    }

}
