package com.example.springdemo.service;

import com.example.springdemo.dto.CreateVehicleRequest;
import com.example.springdemo.dto.VehicleResponse;

public interface VehicleService {
    VehicleResponse createVehicle(CreateVehicleRequest request);
    VehicleResponse getVehicleById(Long id);

}