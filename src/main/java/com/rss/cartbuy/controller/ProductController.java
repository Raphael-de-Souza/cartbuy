package com.rss.cartbuy.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rss.cartbuy.model.Product;
import com.rss.cartbuy.service.ProductService;

@RestController
@RequestMapping(value = "/api")
public class ProductController {

	@Autowired
	private ProductService productService;

	/**
	 * Get Products.
	 * @return List<Product>
	 */
	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/products", method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Product>> productsGet() {

		HttpHeaders httpHeaders = new HttpHeaders();
		List<Product> products = productService.findAll();
		
		return new ResponseEntity<List<Product>>(products, httpHeaders, HttpStatus.OK);
	}
	
	
	/**
	 * Get Product by ID.
	 * @return Product
	 */
	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/product/{productId}", method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public Optional<Product> productsbyId(@PathVariable  String productId) {
		return productService.findbyId(productId);
	}
	
	/**
	 * Delete Product.
	 * @return void
	 */
	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/product/{productId}", method = RequestMethod.DELETE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public void deleteProductById(@PathVariable  String productId) {
		productService.deleteProduct(productsbyId(productId).get());
	}
	
	/**
	 * Insert Product.
	 * @return void
	 */
	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/product", method = RequestMethod.PUT,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public void saveProduct(@Valid @RequestBody Product product) {
		productService.saveProduct(product);
	}
	
	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/product/{productId}", method = RequestMethod.PUT,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public void updateProductById(@PathVariable  String productId,
            					  @Valid @RequestBody Product product) {
		productsbyId(productId)
		.map(productData -> {
             productData.setImageUrl(product.getImageUrl());
             productData.setInfo(product.getInfo());
             productData.setName(product.getName());
             productData.setPrice(product.getPrice());
             saveProduct(productData);
             return ResponseEntity.ok().body(productData);
         }).orElse(ResponseEntity.notFound().build());
	}
}
