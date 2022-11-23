package com.example.cartService.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
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

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;

@RestController
@RequestMapping("/Cart")
public class CartRestController {
	private final String CART_RETRY = "Cart_Retry";
	private final String CART_CB = "Cart_CB";
	private final String CART_RATELM = "Cart_RateLM";
	
	@Autowired
	private CartService cartService;

	@GetMapping("/")
	@CircuitBreaker(name = CART_CB)
	@RateLimiter(name = CART_RATELM)
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
	
	@PutMapping("/")
	public Cart updateCart(@RequestBody Cart cart) {
		return cartService.saveAndFlush(cart);
	}
	
	@PutMapping("/updateTotalMoney/{id}/{tt}")
	public Cart updateTotalMoney(@PathVariable int id, @PathVariable double tt) {
		return cartService.UpdateTotalMoney(id,tt);
	}
}
