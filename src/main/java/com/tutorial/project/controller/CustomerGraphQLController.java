package com.tutorial.project.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tutorial.project.graphQlUtilities.GraphQLUtility;

import graphql.ExecutionResult;
import graphql.GraphQL;

@RestController
public class CustomerGraphQLController {

	private GraphQL graphQL;
	private GraphQLUtility graphQlUtility;

	@Autowired
	CustomerGraphQLController(GraphQLUtility graphQlUtility) throws IOException {
		this.graphQlUtility = graphQlUtility;
		graphQL = graphQlUtility.createGraphQlObject();
	}
	
	@PostMapping(value = "/customerQuery")
	public ResponseEntity<?> query(@RequestBody String query) {
		ExecutionResult result = graphQL.execute(query);
		System.out.println("errors: "+result.getErrors());
        return ResponseEntity.ok(result.getData());
	}
}
