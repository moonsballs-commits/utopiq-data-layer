package com.example.springdemo.service;

import org.springframework.stereotype.Service;
import com.example.springdemo.dao.CustomerRepository;
import com.example.springdemo.dto.CreateCustomerRequest;
import com.example.springdemo.dto.CustomerResponse;
import com.example.springdemo.entity.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public CustomerResponse createCustomer(CreateCustomerRequest request) {
        Customer customer = Customer.builder()
            .fullName(request.getFullName())
            .phoneNumber(request.getPhoneNumber())
            .email(request.getEmail())
            .build();
        Customer savedCustomer = customerRepository.save(customer);
        return toResponse(savedCustomer);
    }

    @Override
    public CustomerResponse getCustomerById(Long id) {
        return customerRepository.findById(id)
            .map(this::toResponse)
            .orElse(null);
    }

    private CustomerResponse toResponse(Customer customer) {
        return CustomerResponse.builder()
            .id(customer.getId())
            .fullName(customer.getFullName())
            .phoneNumber(customer.getPhoneNumber())
            .email(customer.getEmail())
            .build();
    }
}