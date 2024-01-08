package com.tutorial.project.dataFetchers;

import org.springframework.stereotype.Component;

import com.tutorial.project.models.Customer;
import com.tutorial.project.service.CustomerService;

import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;

@Component
public class CustomerDataFetcher implements DataFetcher<Customer>{

	
	private final CustomerService customerService;
	
	
	CustomerDataFetcher(CustomerService customerService) {
		this.customerService = customerService;
	}
	
	@Override
	public Customer get(DataFetchingEnvironment environment) throws Exception {
		String customerId = environment.getArgument("id");
		Customer customer = customerService.findOneById(Integer.valueOf(customerId));
		return customer;
	}

}
