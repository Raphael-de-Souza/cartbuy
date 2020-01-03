package com.rss.cartbuy.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rss.cartbuy.model.CommerceItem;
import com.rss.cartbuy.model.CartBuy;
import com.rss.cartbuy.service.CartbuyService;

@RestController
@RequestMapping(value="/api/cart")
public class CartbuyController {

	@Autowired 
	private CartbuyService cartbuyService;
	
	/**
	 * Returns the current Cart Buy for the session.
	 * @param id
	 * @return cartbuy
	 */
	@RequestMapping(value = "/cartbuy", method = RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<CartBuy> shoppingcartGet(){
		HttpHeaders httpHeaders = new HttpHeaders();
		CartBuy cartbuy = null;// cartbuyService.getSessionShoppingCart();
		return new ResponseEntity<CartBuy>(cartbuy, httpHeaders, HttpStatus.OK);
	}
	
	/**
	 * Removes an commerce item from the shopping cart, by commerce item id.
	 * @param id
	 */
	@RequestMapping(value = "/cartbuy/items/{id}", method = RequestMethod.DELETE, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> shoppingcartItemsIdDelete(@RequestParam(required=true) String id){
		HttpHeaders httpHeaders = new HttpHeaders();
		cartbuyService.delete(id);
		return new ResponseEntity<>("Item was removed from the Cart Buy.", httpHeaders, HttpStatus.OK);
	}
	
	/**
	 * Adds an item to the Cart Buy. 
	 * @param product_id
	 * @param quantity
	 */
	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/cartbuy/items", method = RequestMethod.POST, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<CommerceItem> cartbuyItemsPost(HttpSession httpSession, @RequestBody CartVo cart){
		HttpHeaders httpHeaders = new HttpHeaders();
		CommerceItem commerceItem = new CommerceItem(cart.getProduct_id(), cart.getQuantity(), cart.getAmount());
		cartbuyService.insert(commerceItem);
		return new ResponseEntity<>(commerceItem, httpHeaders, HttpStatus.OK);
	}
	
	/**
	 * Adds an item to the Cart Buy. 
	 * @param product_id
	 * @param quantity
	 */
	@RequestMapping(value = "/cartbuy/total", method = RequestMethod.POST, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Double> getTotalCartBuyCosts(HttpSession httpSession){

		//Get cartbuy from session 
	    	CartBuy cartbuy = null;//cartbuyService.findOne(String.valueOf(httpSession.getAttribute("cart_id")));
	    	
		HttpHeaders httpHeaders = new HttpHeaders();
		return new ResponseEntity<Double>(cartbuy.getTotalCosts(), httpHeaders, HttpStatus.OK);

	}
}

class  CartVo{
	
	
	private String product_id;
	
	private Integer quantity;
	private Double amount;
	/**
	 * @return the product_id
	 */
	public String getProduct_id() {
		return product_id;
	}
	/**
	 * @param product_id the product_id to set
	 */
	public void setProduct_id(String product_id) {
		this.product_id = product_id;
	}
	/**
	 * @return the quantity
	 */
	public Integer getQuantity() {
		return quantity;
	}
	/**
	 * @param quantity the quantity to set
	 */
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	/**
	 * @return the amount
	 */
	public Double getAmount() {
		return amount;
	}
	/**
	 * @param amount the amount to set
	 */
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	
	
}


