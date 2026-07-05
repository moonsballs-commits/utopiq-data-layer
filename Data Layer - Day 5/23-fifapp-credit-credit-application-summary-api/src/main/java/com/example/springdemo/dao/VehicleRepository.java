package com.example.springdemo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.springdemo.entity.Vehicle;

public interface VehicleRepository extends JpaRepository<Vehicle, Long> {

}
