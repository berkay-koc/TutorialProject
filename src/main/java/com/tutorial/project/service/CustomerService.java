package com.tutorial.project.service;

import java.util.List;

import com.tutorial.project.models.Customer;

public interface CustomerService {

	Customer findOneById(Integer id);
	
	List<Customer> findAllCustomers();
	
	Customer save(Customer customer);
}
