package com.springbootservicelocatorfactory.springbootservicelocatorfactory.controller;

import com.springbootservicelocatorfactory.springbootservicelocatorfactory.model.Vehicle;
import com.springbootservicelocatorfactory.springbootservicelocatorfactory.registry.ServiceRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/vehicle")
public class VehicleController {
    @Autowired
    private ServiceRegistry serviceRegistry;

    @PostMapping
    public void VehicleDetails(@RequestBody Vehicle vehicle){
        serviceRegistry.getService(vehicle.getVehicleType()).process(vehicle);
    }
}
