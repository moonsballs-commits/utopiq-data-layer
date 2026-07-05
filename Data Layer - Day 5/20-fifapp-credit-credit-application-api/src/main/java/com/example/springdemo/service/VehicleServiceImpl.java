package com.example.springdemo.service;

import org.springframework.stereotype.Service;
import com.example.springdemo.dao.VehicleRepository;
import com.example.springdemo.dto.CreateVehicleRequest;
import com.example.springdemo.dto.VehicleResponse;
import com.example.springdemo.entity.Vehicle;

@Service
public class VehicleServiceImpl implements VehicleService {
    private final VehicleRepository vehicleRepository;
    public VehicleServiceImpl(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    @Override
    public VehicleResponse createVehicle(CreateVehicleRequest request) {
        Vehicle vehicle = Vehicle.builder()
            .plateNumber(request.getPlateNumber())
            .brand(request.getBrand())
            .model(request.getModel())
            .manufacturingYear(request.getManufacturingYear())
            .build();
        Vehicle savedVehicle = vehicleRepository.save(vehicle);
        return toResponse(savedVehicle);
    }

    @Override
    public VehicleResponse getVehicleById(Long id) {
        return vehicleRepository.findById(id)
            .map(this::toResponse)
            .orElse(null);
    }

    private VehicleResponse toResponse(Vehicle vehicle) {
        return VehicleResponse.builder()
            .id(vehicle.getId())
            .plateNumber(vehicle.getPlateNumber())
            .brand(vehicle.getBrand())
            .model(vehicle.getModel())
            .manufacturingYear(vehicle.getManufacturingYear())
            .createdAt(vehicle.getCreatedAt())
            .build();
    }
}