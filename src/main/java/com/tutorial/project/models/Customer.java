package com.tutorial.project.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import com.mongodb.lang.NonNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer {
	
	@Transient
	public static final String SEQUENCE_NAME = "customer_seq";
	
	@Id
	@NonNull
	private Integer customerId;
	private String name;
	private Integer age;
	private String countryFrom;
	private String countryLiving;
	
}
