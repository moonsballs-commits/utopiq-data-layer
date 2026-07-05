package com.example.springdemo.service;

import com.example.springdemo.dto.CreateCustomerRequest;
import com.example.springdemo.dto.CustomerResponse;

public interface CustomerService {
    CustomerResponse createCustomer(CreateCustomerRequest request);
    CustomerResponse getCustomerById(Long id);

}

// @Service
// public class CustomerService {
//     private final List<Customer> customers = new ArrayList<>();

//     public CustomerService() {
//         customers.add(
//             new Customer(
//                 1L, 
//                 "Edith", 
//                 "3123456789026154", 
//                 "0811111111"));
                
//         customers.add(
//             new Customer(
//                 2L, 
//                 "Bennett", 
//                 "3128464736483927", 
//                 "0822222222"));
//         customers.add(
//             new Customer(
//                 3L, 
//                 "Fadhly", 
//                 "3192758473659386", 
//                 "0833333333"));
//     }

//     public List<Customer> getAll() {
//         return this.customers;
//     }

//     public Customer getCustomerById(Long id) {
//         return customers.stream()
//             .filter(customer -> customer.getId().equals(id))
//             .findFirst()
//             .orElseThrow(() -> new com.example.springdemo.common.CustomerNotFoundException(
//                 "Customer with id " + id + " not found"));
//     }

//     public Customer createCustomer(Customer customer) {
//         boolean identityNumberExists = customers.stream()
//             .anyMatch(existingCustomer -> existingCustomer.getIdentityNumber()
//             .equals(customer.getIdentityNumber()));
            
//             if (identityNumberExists) {
//                 throw new com.example.springdemo.common.DuplicateIdentityNumberException(
//                     "Identity number already exists");
//             }

//         Long newId = customers.stream()
//             .mapToLong(Customer::getId)
//             .max()
//             .orElse(0L) + 1;
//             customer.setId(newId);
//             customers.add(customer);
//         return customer;
//     }
// }