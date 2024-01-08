package com.tutorial.project.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.tutorial.project.models.Order;
import com.tutorial.project.repository.OrderRepository;
import com.tutorial.project.service.OrderService;

@Service
public class OrderServiceImplementation implements OrderService{
	private final OrderRepository orderRepository;
	
	OrderServiceImplementation(OrderRepository orderRepository){
		this.orderRepository = orderRepository;
	}

	@Override
	public Order findOneById(Integer id) {
		return orderRepository.findById(id).orElseGet(null);
	}

	@Override
	public List<Order> findOrdersByName(String name) {
		return orderRepository.findOrdersByOwnerName(name);
	}
	
	
}
