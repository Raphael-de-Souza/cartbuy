package com.rss.cartbuy.model;

import java.math.BigDecimal;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Document(collection = "Product")
public @Data class Product {

	@Id
	private String id;
	private String name;
	private String imageUrl;
	private String info;
	private BigDecimal price;

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", imageUrl=" + imageUrl + ", info=" + info + ", price=" + price
				+ "]";
	}
	
	
}
