package com.example.springdemo.dto;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class VehicleResponse {
    private Long id;
    private String plateNumber;
    private String brand;
    private String model;
    private Integer manufacturingYear;
    private LocalDateTime createdAt;
}