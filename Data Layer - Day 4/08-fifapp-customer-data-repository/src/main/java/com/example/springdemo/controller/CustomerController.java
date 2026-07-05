package com.example.springdemo.controller;

// import java.util.ArrayList;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.springdemo.service.CustomerService;
import jakarta.validation.Valid;
import com.example.springdemo.dto.CustomerRequest;
import com.example.springdemo.dto.CustomerResponse;
import com.example.springdemo.exception.CustomerNotFoundException;
import com.example.springdemo.model.Customer;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {
    private final CustomerService customerService;
    
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    // private List<Customer> customers = new ArrayList<>(
    //     List.of(
    //         new Customer(
    //             1L, 
    //             "Edith",
    //             "3123456789026154",
    //             "0811111111"),
    //         new Customer(
    //             2L,
    //             "Bennett",
    //             "3128464736483927",
    //             "0822222222"),
    //         new Customer(
    //             3L, 
    //             "Fadhly",
    //             "3192758473659386",
    //             "0833333333")
    //     )
    // );

    private CustomerResponse toResponse(Customer customer) {
        return CustomerResponse.builder()
            .id(customer.getId())
            .fullName(customer.getFullName())
            .identityNumber(customer.getIdentityNumber())
            .phoneNumber(customer.getPhoneNumber())
            .build();
    }

    @GetMapping("/hello")
    public String hello() {
        return "Spadaaaaaa";
    }

    @GetMapping
    public List<CustomerResponse> getAll() {
        return customerService.getAll()
            .stream()
            .map(this::toResponse)
            .toList();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerResponse> getCustomerById(@PathVariable Long id) {
        Customer customer = customerService.getCustomerById(id);
        if (customer == null) {
            throw new CustomerNotFoundException(
                "Customer with id " + id + " not found");
            }
        return ResponseEntity.ok(toResponse(customer));
    }

    @PostMapping
    public ResponseEntity<CustomerResponse> createCustomer(@Valid @RequestBody CustomerRequest request) {
        Customer customer = Customer.builder()
            .fullName(request.getFullName())
            .identityNumber(request.getIdentityNumber())
            .phoneNumber(request.getPhoneNumber())
            .build();
        Customer created = customerService.createCustomer(customer);
        CustomerResponse response = toResponse(created);
        return ResponseEntity
            .status(HttpStatus.CREATED)
            .body(response);
    }
}
