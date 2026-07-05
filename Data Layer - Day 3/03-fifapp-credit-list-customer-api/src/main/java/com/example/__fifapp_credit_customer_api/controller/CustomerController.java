package com.example.__fifapp_credit_customer_api.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.__fifapp_credit_customer_api.model.Customer;

@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {
    private List<Customer> customers = new ArrayList<>(
        List.of(
            new Customer(1L, "Edith", "3123456789026154", "0811111111"),
            new Customer(2L, "Bennett", "3128464736483927", "0822222222"),
            new Customer(3L, "Fadhly", "3192758473659386", "0833333333")
        )
    );

    @GetMapping("/hello")
    public String hello() {
        return "Spadaaaaaa";
    }

    @GetMapping
    public List<Customer> getAll() {
        return customers;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable Long id) {
        return customers.stream()
                .filter(c -> c.getId().equals(id))
                .findFirst()
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
