package com.example.springdemo.service;

import com.example.springdemo.dao.CustomerRepository;
import com.example.springdemo.dto.CreateCustomerRequest;
import org.springframework.stereotype.Service;
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
        Customer customer = new Customer(
            request.getFullName(),
            request.getPhoneNumber(),
            request.getEmail()
        );
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
        return new CustomerResponse(
            customer.getId(),
            customer.getFullName(),
            customer.getPhoneNumber(),
            customer.getEmail()
        );
    }
}
    // @Override
    // public List<Customer> findAll() {
    //     return customerRepository.findAll();
    // }
    
    // @Override
    // public Customer findById(Long id) {
    //     Optional<Customer> customer = customerRepository.findById(id);
    //     if (customer.isPresent()) {
    //         return customer.get();
    //     }
    //     return null;
    // }

    // @Transactional
    // @Override
    // public Customer save(Customer customer) {
    //     return customerRepository.save(customer);
    // }

    // @Transactional
    // @Override
    // public Customer deleteById(Long id) {
    //     Optional<Customer> customer = customerRepository.findById(id);
    //     if (customer.isPresent()) {
    //         Customer deletedCustomer = customer.get();
    //         customerRepository.deleteById(id);
    //         return deletedCustomer;
    //     }
    //     throw new CustomerNotFoundException(id);
    // }
// }