package com.springbootservicelocatorfactory.springbootservicelocatorfactory.service;

import com.springbootservicelocatorfactory.springbootservicelocatorfactory.model.Vehicle;
import com.springbootservicelocatorfactory.springbootservicelocatorfactory.registry.AdapterService;
import org.springframework.stereotype.Service;

@Service("Bus")
public class BusService implements AdapterService<Vehicle> {

    @Override
    public void process(Vehicle request){
        System.out.println("inside bus service - "+request.toString());
    }
}
