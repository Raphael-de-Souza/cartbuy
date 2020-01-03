package com.rss.cartbuy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
//@ComponentScan(basePackages={"com.rss.cartbuy"})
//@EnableAutoConfiguration
//@Configuration
public class CartbuyApplication {

	public static void main(String[] args) {
		SpringApplication.run(CartbuyApplication.class, args);
	}
}
