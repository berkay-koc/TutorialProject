package com.tutorial.project.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.tutorial.project.models.Customer;


public interface CustomerRepository extends MongoRepository<Customer, Integer>{

	public Optional<Customer> findById(Integer id);
}
