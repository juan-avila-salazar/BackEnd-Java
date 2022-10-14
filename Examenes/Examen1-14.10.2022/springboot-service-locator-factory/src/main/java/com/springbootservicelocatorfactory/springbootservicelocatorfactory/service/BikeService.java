package com.springbootservicelocatorfactory.springbootservicelocatorfactory.service;

import com.springbootservicelocatorfactory.springbootservicelocatorfactory.model.Vehicle;
import com.springbootservicelocatorfactory.springbootservicelocatorfactory.registry.AdapterService;
import org.springframework.stereotype.Service;

@Service("Bike")
public class BikeService implements AdapterService<Vehicle> {

    @Override
    public void process(Vehicle request){
        System.out.println("inside bike service - "+request.toString());
    }
}
