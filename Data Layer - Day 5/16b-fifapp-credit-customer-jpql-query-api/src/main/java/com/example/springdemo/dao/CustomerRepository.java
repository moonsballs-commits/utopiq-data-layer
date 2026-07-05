package com.example.springdemo.dao;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.example.springdemo.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    @Query("""
        SELECT Customer
        FROM Customer customer
        WHERE customer.email = :email
            """)
    Optional<Customer> findByEmailUsingJpql(@Param("email") String email);
}
