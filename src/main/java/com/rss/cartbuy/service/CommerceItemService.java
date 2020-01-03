package com.rss.cartbuy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rss.cartbuy.model.CommerceItem;
import com.rss.cartbuy.repository.CommerceItemRepository;

@Service
public class CommerceItemService {

    @Autowired
    private CommerceItemRepository commerceItemRepository;
    
    @Transactional
    public void delete(String id){
	commerceItemRepository.deleteById(id);
    }
    
    @Transactional
    public void save(CommerceItem commerceItem){
	commerceItemRepository.save(commerceItem);
    }
}
