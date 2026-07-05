package com.example.springdemo.dao;

import java.util.List;
import org.springframework.stereotype.Repository;
import com.example.springdemo.entity.Customer;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;


@Repository
public class CustomerDAOJpaImpl implements CustomerDAO {
    private final EntityManager entityManager;

    public CustomerDAOJpaImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Customer> findAll() {
        TypedQuery<Customer> query = entityManager.createQuery("from Customer", Customer.class);
        return query.getResultList();
    }

    @Override
    public Customer findById(Long id) {
        return entityManager.find(Customer.class, id);
    }
}
