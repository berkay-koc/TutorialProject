package com.tutorial.project.service;

import java.util.List;

import com.tutorial.project.models.Order;

public interface OrderService {

	Order findOneById(Integer id);
	
	List<Order> findOrdersByName(String name);
	
	Order save(Order order);
}
