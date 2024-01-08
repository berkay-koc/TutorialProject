package com.tutorial.project.graphQlUtilities;

import java.io.File;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import com.tutorial.project.dataFetchers.AllCustomersDataFetcher;
import com.tutorial.project.dataFetchers.AllOrdersDataFetcher;
import com.tutorial.project.dataFetchers.CustomerDataFetcher;
import com.tutorial.project.dataFetchers.OrderDataFetcher;

import graphql.GraphQL;
import graphql.Scalars;
import graphql.scalars.ExtendedScalars;
import graphql.schema.GraphQLScalarType;
import graphql.schema.GraphQLSchema;
import graphql.schema.idl.RuntimeWiring;
import graphql.schema.idl.SchemaGenerator;
import graphql.schema.idl.SchemaParser;
import graphql.schema.idl.TypeDefinitionRegistry;
import jakarta.annotation.PostConstruct;

import static graphql.GraphQL.newGraphQL;

@Component
public class GraphQLUtility {

	@Value("classpath:schemas.graphqls")
	private Resource schemaResource;
	private GraphQL graphQl;
	private CustomerDataFetcher customerDataFetcher;
	private AllCustomersDataFetcher allCustomersDataFetcher;
	private OrderDataFetcher orderDataFetcher;
	private AllOrdersDataFetcher allOrdersDataFetcher;

	public GraphQLUtility(CustomerDataFetcher customerDataFetcher, AllCustomersDataFetcher allCustomersDataFetcher,
			OrderDataFetcher orderDataFetcher, AllOrdersDataFetcher allOrdersDataFetcher) throws IOException {
		this.customerDataFetcher = customerDataFetcher;
		this.allCustomersDataFetcher = allCustomersDataFetcher;
		this.orderDataFetcher = orderDataFetcher;
		this.allOrdersDataFetcher = allOrdersDataFetcher;
	}

	@PostConstruct
	public GraphQL createGraphQlObject() throws IOException {
		File schemas = schemaResource.getFile();
		TypeDefinitionRegistry typeRegistry = new SchemaParser().parse(schemas);
		RuntimeWiring wiring = buildRuntimeWiring();
		GraphQLSchema schema = new SchemaGenerator().makeExecutableSchema(typeRegistry, wiring);
		return newGraphQL(schema).build();
	}

	public RuntimeWiring buildRuntimeWiring() {
		return RuntimeWiring.newRuntimeWiring().scalar(ExtendedScalars.GraphQLBigDecimal)
				.type("Query",
						typeWiring -> typeWiring.dataFetcher("customers", allCustomersDataFetcher)
								.dataFetcher("customer", customerDataFetcher).dataFetcher("orderById", orderDataFetcher)
								.dataFetcher("orderByName", allOrdersDataFetcher))
				.build();
	}
}
