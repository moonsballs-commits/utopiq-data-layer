package com.example.springdemo.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.springdemo.dto.CreateVehicleRequest;
import com.example.springdemo.dto.VehicleResponse;
import com.example.springdemo.service.VehicleService;

@RestController
@RequestMapping("/api/vehicles")
public class VehicleRestController {
    private final VehicleService vehicleService;
    public VehicleRestController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    @PostMapping
    public VehicleResponse createVehicle(@RequestBody CreateVehicleRequest request) {
        return vehicleService.createVehicle(request);
    }

    @GetMapping("/{id}")
    public VehicleResponse getVehicle(
            @PathVariable Long id) {

        VehicleResponse vehicle =
                vehicleService.getVehicleById(id);

        if (vehicle == null) {
            throw new RuntimeException("Vehicle not found with id: " + id);
        }
        return vehicle;
    }
}