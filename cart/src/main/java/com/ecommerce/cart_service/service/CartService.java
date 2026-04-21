package com.ecommerce.cart_service.service;

import com.ecommerce.cart_service.entity.Cart;
import com.ecommerce.cart_service.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService {
    @Autowired
    private CartRepository repository;
    @Autowired
    private ProductClient productClient;
    @Autowired
    private UserClient userClient;

    public Cart addToCart(Cart cart){
        userClient.getUser(cart.getUserId());
        productClient.getProduct(cart.getProductId());
        return repository.save(cart);
    }

    public List<Cart> getUserCart(Long userId){
        return repository.findByUserId(userId);
    }

    public void remove(Long id){
        repository.deleteById(id);
    }
}
