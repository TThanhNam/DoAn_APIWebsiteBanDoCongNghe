package com.example.cartService.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.cartService.entity.Cart;
import com.example.cartService.repository.CartRepository;

@Service
public class CartServiceImpl implements CartService  {
	@Autowired
	private CartRepository cartRepository;

	@Override
	public Cart getOneCart(int cartID) {
		return cartRepository.findById(cartID).get();
	}

	@Override
	public Cart saveCart(Cart cart) {
		return cartRepository.save(cart);
	}

	@Override
	public List<Cart> getCarts() {
		return cartRepository.findAll();
	}

	public String deleteCart(int cartID) {
		cartRepository.deleteById(cartID);
		return "Xoa thanh cong"; 
		
	}

	public Cart update(Cart cart) {
		return cartRepository.saveAndFlush(cart);
	}
	
}
