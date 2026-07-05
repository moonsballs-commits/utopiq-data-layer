package com.example.springdemo.dao;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.springdemo.entity.CreditApplication;

public interface CreditApplicationRepository extends JpaRepository<CreditApplication, Long> {
    List<CreditApplication> findByStatus(String status);
}