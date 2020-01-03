package com.rss.cartbuy.service;

import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rss.cartbuy.model.CommerceItem;
import com.rss.cartbuy.model.CartBuy;
import com.rss.cartbuy.repository.CommerceItemRepository;
import com.rss.cartbuy.repository.CartBuyRepository;

@Service
public class CartbuyService {

    @Autowired
    private CartBuyRepository cartbuyRepo;

    @Autowired
    private CommerceItemRepository commerceItemRepo;

    @Autowired
    private HttpSession		   httpSession;

    @Transactional
    public Optional<CartBuy> findOne(String id) {
	return cartbuyRepo.findById(id);
    }

    @Transactional
    public void save(CartBuy cartbuy) {
	cartbuyRepo.save(cartbuy);
    }

    public void delete(String id) {
	CartBuy cartbuy = getSessionShoppingCart();
	Optional<CommerceItem> item = commerceItemRepo.findById(id);
	cartbuy.getCommerceItems().remove(item);
	httpSession.setAttribute("shoppingcart", cartbuy);
    }
    
    public void insert(CommerceItem commerceItem) {
	CartBuy cartbuy = getSessionShoppingCart();
	cartbuy.getCommerceItems().add(commerceItem);
	httpSession.setAttribute("shoppingcart", cartbuy);
}

    public CartBuy getSessionShoppingCart() {
	CartBuy cartbuy = (CartBuy) this.httpSession.getAttribute("cartbuy");
	if (cartbuy == null) {
		cartbuy = new CartBuy();
	    this.httpSession.setAttribute("shoppingcart", cartbuy);
	}
	return cartbuy;
    }
}
