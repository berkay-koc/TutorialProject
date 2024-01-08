//package com.tutorial.project.controller;
//
//import java.util.Optional;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.tutorial.project.models.Customer;
//import com.tutorial.project.models.Order;
//import com.tutorial.project.repository.CustomerRepository;
//import com.tutorial.project.repository.OrderRepository;
//
//@RestController
//public class CustomerController {
//
//	@Autowired
//	CustomerRepository customerRepository;
//	
//	@Autowired
//	OrderRepository orderRepository;
//	
//	@PostMapping("/api/addCustomer")
//	public void addCustomer(@RequestBody Customer customer) {
//		customerRepository.save(customer);
//	}
//	
//	@PostMapping("/api/addOrder")
//	public void addOrder(@RequestBody Order order) {
//		orderRepository.save(order);
//	}
//}
