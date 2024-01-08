package com.tutorial.project.service.impl;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.tutorial.project.models.Customer;
import com.tutorial.project.repository.CustomerRepository;
import com.tutorial.project.service.CustomerService;

@Service
public class CustomerServiceImplementation implements CustomerService{
	
	private final CustomerRepository customerRepository;
	
	
	CustomerServiceImplementation(CustomerRepository customerRepository) {
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

}
