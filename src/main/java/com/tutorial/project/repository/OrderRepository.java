package com.tutorial.project.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.tutorial.project.models.Order;

public interface OrderRepository extends MongoRepository<Order, Integer>{
	Optional<Order> findById(Integer id);
	
	List<Order> findOrdersByOwnerName(String name);
}
