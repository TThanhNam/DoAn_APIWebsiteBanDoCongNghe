package com.example.cartService.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.cartService.entity.Cart;
import com.example.cartService.model.CartAndCartDetail;
import com.example.cartService.model.ProductOfCartDetail;
import com.example.cartService.repository.CartRepository;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;

@Service
public class CartService {
	
	private final String CART_RETRY = "Cart_Retry";
	private final String CART_CB = "Cart_CB";
	private final String CART_RATELM = "Cart_RateLM";
	@Autowired
	private CartRepository cartRepository;
	
	@Autowired
	private RestTemplate restTemplate;

	public Cart getOneCart(int cartID) {
		return cartRepository.findById(cartID).get();
	}

	public Cart saveAndFlush(Cart cart) {
		return cartRepository.saveAndFlush(cart);
	}

	public List<Cart> getCarts() {
		return cartRepository.findAll();
	}

//	@CircuitBreaker(name = CART_CB)
//	@RateLimiter(name = CART_RATELM)
	@Retry(name = CART_RETRY, fallbackMethod = "fallback")
	public CartAndCartDetail getCartAndCartDetailByCartId(int id) {
		System.out.println("Đang kết nối tới sevice...");
		Cart cart = getOneCart(id);
		double totalMoney = 0;
		ResponseEntity<ProductOfCartDetail[]> response = restTemplate
				.getForEntity("http://localhost:9002/CartDetail/getByCartId/" + cart.getCartID(),
						ProductOfCartDetail[].class);
		List<ProductOfCartDetail> ls = Arrays.asList(response.getBody());
		for (ProductOfCartDetail productOfCartDetail : ls) {
			totalMoney += productOfCartDetail.getProduct().getPricePD() * productOfCartDetail.getCartDetail().getQuantity();
		}
		cart.setTotalMoney(totalMoney);
		return new CartAndCartDetail(cart, ls);
	}
	
	public CartAndCartDetail fallback(Exception e) {
		System.out.println("Không thể kết nối tới service");
		return new CartAndCartDetail();
	}
	
	public Cart UpdateTotalMoney(int id,double totalMoney) {
		Cart cart = getOneCart(id);
		cart.setTotalMoney(totalMoney);
		return saveAndFlush(cart);		
	}
	
	public String deleteCart(int cartID) {
		cartRepository.deleteById(cartID);
		return "Xoa thanh cong"; 
	}

	public String deleteAll() {
		cartRepository.deleteAll();
		return "Xóa hết thành công";
	}
	
	

		
	
}
