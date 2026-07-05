package com.example.springdemo.service;

import com.example.springdemo.dao.CustomerDAOJpaImpl;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.springdemo.common.CustomerNotFoundException;
import com.example.springdemo.dao.CustomerDAO;
import com.example.springdemo.entity.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {
    private final CustomerDAOJpaImpl customerDAOJpaImpl;
    private final CustomerDAO customerDAO;

    public CustomerServiceImpl(CustomerDAO customerDAO, CustomerDAOJpaImpl customerDAOJpaImpl) {
        this.customerDAO = customerDAO;
        this.customerDAOJpaImpl = customerDAOJpaImpl;
    }

    @Override
    public List<Customer> findAll() {
        return customerDAO.findAll();
    }
    
    @Override
    public Customer findById(Long id) {
        return customerDAO.findById(id);
    }

    @Transactional
    @Override
    public Customer save(Customer customer) {
        return customerDAO.save(customer);
    }

    @Transactional
    @Override
    public Customer deleteById(Long id) {
                Customer customer = customerDAO.findById(id);
        if (customer != null) {
            customerDAO.deleteById(id);
            return customer;
        }
        throw new CustomerNotFoundException(id);
    }
}