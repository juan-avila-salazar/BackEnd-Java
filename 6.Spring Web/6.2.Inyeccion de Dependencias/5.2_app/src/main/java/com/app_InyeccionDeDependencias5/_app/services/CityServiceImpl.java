package com.app_InyeccionDeDependencias5._app.services;

import com.app_InyeccionDeDependencias5._app.models.CityModel;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CityServiceImpl implements CityService{

    @Override
    public CityModel ViewList(String ciudad,int numHabitantes){
        CityModel listCities = new CityModel(ciudad, numHabitantes);
        return listCities;
    }
}
