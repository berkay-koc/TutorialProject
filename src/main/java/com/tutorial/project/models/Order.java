package com.tutorial.project.models;

import java.math.BigDecimal;

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
public class Order {
	
	@Transient
	public static final String SEQUENCE_NAME = "order_seq";
	
	@Id
	@NonNull
	private Integer id;
	private OrderType orderType;
	private String ownerName;
	private String supplierName;
	private Integer amount;
	private BigDecimal price;
}
