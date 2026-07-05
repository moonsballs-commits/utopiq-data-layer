package com.example.springdemo.entity;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(
    name = "vehicles",
    schema = "flyway_training"
)
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "plate_number")
    private String plateNumber;

    @Column(name = "brand")
    private String brand;

    @Column(name = "model")
    private String model;

    @Column(name = "manufacturing_year")
    private Integer manufacturingYear;
    
    @Column(
    name = "created_at",
    insertable = false,
    updatable = false
    )
    private LocalDateTime createdAt;

    @OneToMany(mappedBy = "vehicle")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private List<CreditApplication> creditApplications;

    public Vehicle(
        String plateNumber,
        String brand,
        String model,
        Integer manufacturingYear) {

        this.plateNumber = plateNumber;
        this.brand = brand;
        this.model = model;
        this.manufacturingYear = manufacturingYear;
    }
}