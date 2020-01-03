package com.rss.cartbuy.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.stereotype.Component;

import lombok.Data;

import org.springframework.context.annotation.ScopedProxyMode;

@Component
@Scope(proxyMode=ScopedProxyMode.TARGET_CLASS, value="session")
public @Data class CartBuy {

	@Id
	private String id;
	
	@DBRef
	private List<CommerceItem> commerceItems = new ArrayList<>();
	
	private BigDecimal amount;

	public Double getTotalCosts(){
	    double totalCost = commerceItems
		    .stream()
		    .mapToDouble(item -> item.getAmount().doubleValue())
		    .sum();
	    
	    return totalCost;
	}
}
