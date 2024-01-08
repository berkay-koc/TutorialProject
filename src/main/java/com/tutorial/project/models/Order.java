package com.tutorial.project.models;

import java.math.BigDecimal;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.mongodb.lang.NonNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {
	@Id
	@NonNull
	Integer id;
	OrderType orderType;
	String ownerName;
	String supplierName;
	Integer amount;
	BigDecimal price;
}
