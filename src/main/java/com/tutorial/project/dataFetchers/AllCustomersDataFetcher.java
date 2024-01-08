package com.tutorial.project.dataFetchers;

import java.util.List;

import org.springframework.stereotype.Component;

import com.tutorial.project.models.Customer;
import com.tutorial.project.service.CustomerService;

import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;

@Component
public class AllCustomersDataFetcher implements DataFetcher<List<Customer>>{

	
	private final CustomerService customerService;
	
	
	public AllCustomersDataFetcher(CustomerService customerService) {
		this.customerService = customerService;
	}
	
	@Override
	public List<Customer> get(DataFetchingEnvironment environment) throws Exception {
		return customerService.findAllCustomers();
	}
}
