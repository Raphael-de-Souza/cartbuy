package com.rss.cartbuy.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.rss.cartbuy.model.Product;
import com.rss.cartbuy.repository.ProductRepository;

@Service
public class ProductService {
    
    @Autowired
    private ProductRepository productRepository;

    @Transactional
    public List<Product> findAll() {
    	return productRepository.findAll();
    }
    
    @Transactional
    public Optional<Product> findbyId(final String productId) {
    	return productRepository.findById(productId);
    }
    
    @Transactional
    public void deleteProduct(final Product product) {
        productRepository.delete(product);
    }
    
    @Transactional
    public void saveProduct(final Product product) {
        productRepository.save(product);
    }
}
