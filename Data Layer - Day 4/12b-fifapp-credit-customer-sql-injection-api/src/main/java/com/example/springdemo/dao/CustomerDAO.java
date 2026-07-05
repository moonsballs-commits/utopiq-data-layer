package com.example.springdemo.dao;

import java.util.List;
import com.example.springdemo.entity.Customer;

public interface CustomerDAO {
    List<Customer> findAll();
    Customer findById(Long id);
    List<Customer> findByFullNameBefore(String fullName);
    List<Customer> findByFullNameAfter(String fullName);
}