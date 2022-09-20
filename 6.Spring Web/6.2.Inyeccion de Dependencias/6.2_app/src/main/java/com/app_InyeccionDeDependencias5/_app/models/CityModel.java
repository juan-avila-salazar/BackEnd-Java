package com.app_InyeccionDeDependencias5._app.models;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
public class CityModel {
    public String ciudad;
    public int numHabitantes;

    public CityModel(String ciudad, int numHabitantes) {
        this.ciudad = ciudad;
        this.numHabitantes = numHabitantes;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public int getNumHabitantes() {
        return numHabitantes;
    }

    public void setNumHabitantes(int numHabitantes) {
        this.numHabitantes = numHabitantes;
    }
}