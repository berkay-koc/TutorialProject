package com.tutorial.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tutorial.project.models.Order;
import com.tutorial.project.service.OrderService;
import com.tutorial.project.service.SequenceGeneratorService;

@RestController
public class OrderController {

	@Autowired
	private OrderService orderService;
	
	@Autowired
	private SequenceGeneratorService generatorService;
	
	@PostMapping("/api/addOrder")
	public void addOrder(@RequestBody Order order) {
		order.setId(generatorService.getSequenceNumber(Order.SEQUENCE_NAME));
		orderService.save(order);
	}
}
