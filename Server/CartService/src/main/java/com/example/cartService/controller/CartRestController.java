package com.example.cartService.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.cartService.entity.Cart;
import com.example.cartService.model.CartAndCartDetail;
import com.example.cartService.service.CartService;

@RestController
@RequestMapping("/Cart")
public class CartRestController {
	@Autowired
	private CartService cartService;
	
	@GetMapping("/")
	public List<Cart> getCarts(){
		return cartService.getCarts();
	}
	
	@GetMapping("/getCartAndCartDetail/{id}")
	private CartAndCartDetail getCartAndCartDetail(@PathVariable int id) {
		// TODO Auto-generated method stub
		return cartService.getCartAndCartDetailByCartId(id);
	}
	
	@PostMapping("/")
	public Cart saveCart(@RequestBody Cart cart) {
		return cartService.saveAndFlush(cart);
	}
	
	@GetMapping("/{id}")
	public Cart getCartById(@PathVariable int id) {
		return cartService.getOneCart(id);
	}
	
	@DeleteMapping("/{id}")
	public String deleteCartById(@PathVariable int id) {
		return cartService.deleteCart(id);
	}
	
	@DeleteMapping("/")
	public String deleteCartById() {
		return cartService.deleteAll();
	}
	
	@PutMapping("/")
	public Cart updateCart(@RequestBody Cart cart) {
		return cartService.saveAndFlush(cart);
	}
}
