package com.tutorial.project.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import com.tutorial.project.models.Customer;
import com.tutorial.project.repository.CustomerRepository;
import com.tutorial.project.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService{
	
	private final CustomerRepository customerRepository;
	
	@Autowired
	private MongoOperations mongoOperations;
	
	
	CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }
	
	@Override
    public Customer findOneById(Integer id) {
        return customerRepository.findById(id).orElseGet(null);
    }

	@Override
	public List<Customer> findAllCustomers() {
        return customerRepository.findAll();
	}

	@Override
	public Customer save(Customer customer) {
		return customerRepository.save(customer);
	}

}
