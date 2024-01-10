package com.tutorial.project.dataFetchers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tutorial.project.models.Order;
import com.tutorial.project.service.OrderService;

import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;

@Component
public class OrdersByNameDataFetcher implements DataFetcher<List<Order>> {

	@Autowired
	OrderService orderService;

	@Override
	public List<Order> get(DataFetchingEnvironment environment) throws Exception {
		String arg = environment.getArgument("name");

		return orderService.findOrdersByName(arg);
	}

}
