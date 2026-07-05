package com.example.springdemo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import com.example.springdemo.entity.Customer;

@RepositoryRestResource(path = "aldy")
public interface CustomerRepository extends JpaRepository<Customer, Long> {
}