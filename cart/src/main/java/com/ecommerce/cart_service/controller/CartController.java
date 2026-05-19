package com.ecommerce.cart_service.controller;

import com.ecommerce.cart_service.entity.Cart;
import com.ecommerce.cart_service.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cart")
public class CartController {
    @Autowired
    private CartService cartService;

    @PostMapping
    public Cart add(@RequestBody Cart cart){
        return cartService.addToCart(cart);
    }

    @GetMapping("/{userId}")
    public List<Cart> getCart(@PathVariable Long userId){
        return cartService.getUserCart(userId);
    }
    @GetMapping
    public List<Cart> getAllCarts(){
        return cartService.getAllUserCart();
    }
    @DeleteMapping("/{id}")
    public void remove(@PathVariable Long id){
        cartService.remove(id);
    }
}
