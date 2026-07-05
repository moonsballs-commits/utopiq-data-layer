package com.example.springdemo.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import com.example.springdemo.model.Customer;

@Service
public class CustomerService {
    private final List<Customer> customers = new ArrayList<>();

    public CustomerService() {
        customers.add(new Customer(1L, "Edith", "3123456789026154", "0811111111"));
        customers.add(new Customer(2L, "Bennett", "3128464736483927", "0822222222"));
        customers.add(new Customer(3L, "Fadhly", "3192758473659386", "0833333333"));
    }

    public List<Customer> getAll() {
        return this.customers;
    }

    public Customer getCustomerById (Long id) {
        return this.customers.stream()
            .filter(c -> c.getId().equals(id))
            .findFirst()
            .orElse(null);
    }

    public Customer createCustomer(Customer customer) {
        Long newId = customers.stream()
                .mapToLong(Customer::getId)
                .max()
                .orElse(0L) + 1;
        customer.setId(newId);
        customers.add(customer);
        return customer;
    }
}