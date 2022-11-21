package com.example.cartService.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.cartService.entity.Cart;
import com.example.cartService.entity.CartAndCartDetail;
import com.example.cartService.entity.ProductOfCartDetail;
import com.example.cartService.repository.CartRepository;

import io.github.resilience4j.retry.annotation.Retry;

@Service
public class CartService {
	@Autowired
	private CartRepository cartRepository;
	
	@Autowired
	private RestTemplate restTemplate;

	public Cart getOneCart(int cartID) {
		return cartRepository.findById(cartID).get();
	}

	public Cart saveCart(Cart cart) {
		return cartRepository.save(cart);
	}

	public List<Cart> getCarts() {
		return cartRepository.findAll();
	}
	
	@Retry(name = "CARTSERVICE")
	public CartAndCartDetail getCartAndCartDetailByCartId(int id) {
		Cart cart = getOneCart(id);
		ResponseEntity<ProductOfCartDetail[]> response = restTemplate
				.getForEntity("http://localhost:9002/CartDetail/getByCartId/" + cart.getCartID(),
						ProductOfCartDetail[].class);
		List<ProductOfCartDetail> ls = Arrays.asList(response.getBody());
		return new CartAndCartDetail(cart, ls);
	}
	
	public String deleteCart(int cartID) {
		cartRepository.deleteById(cartID);
		return "Xoa thanh cong"; 
	}

	public Cart update(int id ,Cart cart) {
		Cart cart1 = cartRepository.findById(id).orElse(null);
		if(cart1 == null) {
			return null;}
		cart1.setTotalMoney(cart.getTotalMoney());
		return cartRepository.save(cart1);
	}
		
	
}
