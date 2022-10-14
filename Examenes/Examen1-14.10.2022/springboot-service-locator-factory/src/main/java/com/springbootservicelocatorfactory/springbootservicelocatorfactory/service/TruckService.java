package com.springbootservicelocatorfactory.springbootservicelocatorfactory.service;

import com.springbootservicelocatorfactory.springbootservicelocatorfactory.model.Vehicle;
import com.springbootservicelocatorfactory.springbootservicelocatorfactory.registry.AdapterService;
import org.springframework.stereotype.Service;

@Service("Truck")
public class TruckService implements AdapterService<Vehicle> {

    @Override
    public void process(Vehicle request){
        System.out.println("inside truck service - "+request.toString());
    }
}
