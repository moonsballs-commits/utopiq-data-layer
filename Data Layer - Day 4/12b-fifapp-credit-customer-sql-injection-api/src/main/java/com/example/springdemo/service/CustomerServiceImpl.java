package com.example.springdemo.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.example.springdemo.dao.CustomerDAO;
import com.example.springdemo.entity.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {
    private final CustomerDAO customerDAO;

    public CustomerServiceImpl(CustomerDAO customerDAO) {
        this.customerDAO = customerDAO;
    }

    @Override
    public List<Customer> findAll() {
        return customerDAO.findAll();
    }
    
    @Override
    public Customer findById(Long id) {
        return customerDAO.findById(id);
    }

    @Override
    public List<Customer> findByFullNameBefore(String fullName) {
        return customerDAO.findByFullNameBefore(fullName);
    }

    @Override
    public List<Customer> findByFullNameAfter(String fullName) {
        return customerDAO.findByFullNameAfter(fullName);
    }
}