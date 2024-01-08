package com.tutorial.project.dataFetchers;

import org.springframework.stereotype.Component;

import com.tutorial.project.models.Order;
import com.tutorial.project.service.OrderService;

import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;

@Component
public class OrderDataFetcher implements DataFetcher<Order>{

	private final OrderService orderService;
	
	OrderDataFetcher(OrderService orderService){
		this.orderService = orderService;
	}
	
	@Override
	public Order get(DataFetchingEnvironment environment) throws Exception {
		String arg = environment.getArgument("id");
		
		return orderService.findOneById(Integer.valueOf(arg));
	}

}
