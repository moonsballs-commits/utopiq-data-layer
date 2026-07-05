package com.example.__fifapp_credit_customer_api.controller;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.__fifapp_credit_customer_api.model.Customer;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {

    @GetMapping("/hello")
    public String hello() {
        return "Spadaaaaaa";
    }
    
    @GetMapping("/{id}")
    public Customer getCustomerById(@RequestParam Long id) {
        return new Customer (
            id,
            "Edith",
            "3127384628264837",
            "0812736583716384"
        );
    }
}