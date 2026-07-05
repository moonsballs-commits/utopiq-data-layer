package com.example.springdemo.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Repository;
import com.example.springdemo.model.Customer;

@Repository
public class CustomerRepository {
    private final List<Customer> customers = new ArrayList<>();
    public CustomerRepository() {
        customers.add(
            new Customer(
                1L,
                "Edith",
                "3123456789026154",
                "0811111111"
            )
        );

        customers.add(
            new Customer(
                2L,
                "Bennett",
                "3128464736483927",
                "0822222222"
            )
        );

        customers.add(
            new Customer(
                3L,
                "Fadhly",
                "3192758473659386",
                "0833333333"
            )
        );
    }

    public List<Customer> findAll() {
        return customers;
    }

    public Optional<Customer> findById(Long id) {
        return customers.stream()
            .filter(customer -> customer.getId().equals(id))
            .findFirst();
    }

    public Optional<Customer> findByIdentityNumber(
        String identityNumber) {
        return customers.stream()
            .filter(customer -> customer.getIdentityNumber()
            .equals(identityNumber))
            .findFirst();
    }

    public Customer save(Customer customer) {
        Long newId = customers.stream()
            .mapToLong(Customer::getId)
            .max()
            .orElse(0L) + 1;
        customer.setId(newId);
        customers.add(customer);
        return customer;
    }
}