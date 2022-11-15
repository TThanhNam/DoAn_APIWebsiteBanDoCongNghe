package com.example.cartService.service;

import java.util.List;

import com.example.cartService.entity.Cart;

public interface CartService {
	public Cart getOneCart(int cartID);
	public Cart saveCart(Cart cart);
	public List<Cart> getCarts();
	public String deleteCart(int cartID);
	public Cart update(Cart cart);
}
