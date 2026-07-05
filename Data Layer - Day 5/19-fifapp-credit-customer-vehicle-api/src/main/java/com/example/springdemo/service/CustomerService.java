package com.example.springdemo.service;

import com.example.springdemo.dto.CreateCustomerRequest;
import com.example.springdemo.dto.CustomerResponse;

public interface CustomerService {
    CustomerResponse createCustomer(CreateCustomerRequest request);
    CustomerResponse getCustomerById(Long id);

}