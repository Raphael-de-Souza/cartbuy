package com.rss.cartbuy.model;

import java.math.BigDecimal;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Document
public @Data class CommerceItem {

	@Id
	private String id;

	private String product_id;
	private Integer quantity;
	private Double amount;

	public CommerceItem(String product_id, Integer quantity,Double amount) {
		super();
		this.product_id = product_id;
		this.quantity = quantity;
		this.amount = (amount * quantity);
	}
	
	public CommerceItem(String product_id, Integer quantity) {
		super();
		this.product_id = product_id;
		this.quantity = quantity;
		this.amount = (quantity * 10.0);
	}


	

}
