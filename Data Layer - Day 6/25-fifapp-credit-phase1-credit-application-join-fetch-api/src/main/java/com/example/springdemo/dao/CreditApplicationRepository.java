package com.example.springdemo.dao;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.springdemo.entity.CreditApplication;

public interface CreditApplicationRepository extends JpaRepository<CreditApplication, Long> {
    @Query("""
        select creditApplication
        from CreditApplication creditApplication
        join fetch creditApplication.customer
        join fetch creditApplication.vehicle
    """)
    List<CreditApplication> findAllWithCustomerAndVehicle();

    @Query("""
        select creditApplication
        from CreditApplication creditApplication
        join fetch creditApplication.customer
        join fetch creditApplication.vehicle
        where creditApplication.status = :status
    """)
    List<CreditApplication> findByStatusWithCustomerAndVehicle(String status);
}