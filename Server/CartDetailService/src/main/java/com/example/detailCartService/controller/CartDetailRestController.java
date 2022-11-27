package com.example.detailCartService.controller;

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

import com.example.detailCartService.entity.CartDetail;
import com.example.detailCartService.model.ProductOfCartDetail;
import com.example.detailCartService.service.CartDetailService;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;

@RestController
@RequestMapping("/CartDetail")
public class CartDetailRestController {
	
	private final String CART_RETRY = "Cart_Retry";
	private final String CART_CB = "Cart_CB";
	private final String CART_RATELM = "Cart_RateLM";
	
	@Autowired
	private CartDetailService cartDetailService; 
	
	@GetMapping("/")
	@CircuitBreaker(name = CART_CB)
//	@RateLimiter(name = CART_RATELM)
	public List<CartDetail> getCartDetails(){
		return cartDetailService.findAll();
	}
	
	@GetMapping("/{id}")
	@CircuitBreaker(name = CART_CB)
	@RateLimiter(name = CART_RATELM)
	public ProductOfCartDetail getCartDetailID(@PathVariable int id) {
		return cartDetailService.findById(id);
	}
	
	@GetMapping("/CartDetailAndProduct")
	@CircuitBreaker(name = CART_CB)
	@RateLimiter(name = CART_RATELM)
	public List<ProductOfCartDetail> getCartDetailAndProduct() {
		// TODO Auto-generated method stub
		return cartDetailService.findAllCartDetalAndProduct();
	}
	
	@GetMapping("/getByCartId/{id}")
	@CircuitBreaker(name = CART_CB)
	@RateLimiter(name = CART_RATELM)
	public List<ProductOfCartDetail> getByCartId(@PathVariable int id) {
		// TODO Auto-generated method stub
		return cartDetailService.getCartDetalAndProductByCartId(id);
	}
		
	@PostMapping("/")
	@CircuitBreaker(name = CART_CB)
	@RateLimiter(name = CART_RATELM)
	public CartDetail saveCartDetail(@RequestBody CartDetail cartDetail) {
		return cartDetailService.saveAndFlush(cartDetail);
	}
	
	@DeleteMapping("/{id}")
	@CircuitBreaker(name = CART_CB)
	@RateLimiter(name = CART_RATELM)
	public String deleteCartDetail(@PathVariable int id) {
		cartDetailService.deleteById(id);
		return "Xóa thành công " + id;
	}
	
	@DeleteMapping("/")
	@CircuitBreaker(name = CART_CB)
	@RateLimiter(name = CART_RATELM)
	public String deleteAllCartDetail() {
		cartDetailService.deleteAll();
		return "Xóa thành công ";
	}
	
	@PutMapping("/")
	@CircuitBreaker(name = CART_CB)
	@RateLimiter(name = CART_RATELM)
	public CartDetail update(@RequestBody CartDetail cartDetail) {
		return cartDetailService.saveAndFlush(cartDetail);
	}
	
}
