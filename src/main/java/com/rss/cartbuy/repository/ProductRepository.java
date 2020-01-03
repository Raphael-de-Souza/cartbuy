package com.rss.cartbuy.repository;

import com.rss.cartbuy.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends MongoRepository<Product, String> {
	/**We’ve extended TodoRepository with MongoRepository interface provided by spring-data-mongodb. 
	 * The MongoRepository interface defines methods for all the CRUD operations on the Document like 
	 * finAll(), fineOne(), save(), delete() etc.
	 * 
	 * Spring Boot automatically plugs in an implementation of MongoRepository interface called SimpleMongoRepository 
	 * at runtime. So, All of the CRUD methods defined by MongoRepository are readily available to you without doing anything.
	 * 
	 * You can check out all the methods available for use from SimpleMongoRepository’s documentation.
	 * */
} 
