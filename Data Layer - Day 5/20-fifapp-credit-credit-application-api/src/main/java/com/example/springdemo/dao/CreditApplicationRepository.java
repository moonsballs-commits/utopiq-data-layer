package com.example.springdemo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.springdemo.entity.CreditApplication;

public interface CreditApplicationRepository extends JpaRepository<CreditApplication, Long> {

}