package com.rss.cartbuy.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;

import com.rss.cartbuy.model.CartBuy;


public interface CartBuyRepository extends MongoRepository<CartBuy, String> {

}
