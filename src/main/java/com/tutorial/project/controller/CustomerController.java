package com.tutorial.project.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tutorial.project.models.Customer;
import com.tutorial.project.models.Order;
import com.tutorial.project.repository.CustomerRepository;
import com.tutorial.project.repository.OrderRepository;
import com.tutorial.project.service.CustomerService;
import com.tutorial.project.service.OrderService;
import com.tutorial.project.service.SequenceGeneratorService;

@RestController
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private SequenceGeneratorService generatorService;
	
	@PostMapping("/api/addCustomer")
	public void addCustomer(@RequestBody Customer customer) {
		customer.setCustomerId(generatorService.getSequenceNumber(Customer.SEQUENCE_NAME));
		customerService.save(customer);
	}
	
	
}
