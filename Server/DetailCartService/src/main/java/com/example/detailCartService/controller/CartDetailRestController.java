package com.example.detailCartService.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.detailCartService.VO.CartDetail_Cart;
import com.example.detailCartService.VO.CartDetail_Cart_Product;
import com.example.detailCartService.entity.CartDetail;
import com.example.detailCartService.service.CartDetailService;

@RestController
@RequestMapping("/CartDetail")
public class CartDetailRestController {
	
	@Autowired
	private CartDetailService cartDetailService;
	
	@GetMapping("/{id}")
	public CartDetail getCartDetailID(@PathVariable int id) {
		return cartDetailService.getOneCartDetail(id);
	}
	
	@GetMapping("/call/{id}")
	public CartDetail_Cart getCartDetail_Cart(@PathVariable int id) {
		return cartDetailService.getCartDetail_Cart(id);
	}
	
	@GetMapping("/calls/{id}")
	public CartDetail_Cart_Product getCartDetail_Cart_Product(@PathVariable int id) {
		return cartDetailService.getCartDetail_Cart_Product(id);
	}
	
	@PostMapping("/saveCartDetail")
	public CartDetail saveCartDetail(@RequestBody CartDetail cartDetail) {
		return cartDetailService.saveCartDetail(cartDetail);
	}
	
	@GetMapping("/")
	public List<CartDetail> getCartDetails(){
		return cartDetailService.getCartDetails();
	}
	
	@PostMapping("/update")
	public CartDetail update(CartDetail cartDetail) {
		return cartDetailService.update(cartDetail);
	}
	@DeleteMapping("/{id}")
	public String deleteCartDetail(@PathVariable int id) {
		return cartDetailService.deleteCartDetail(id);
	}
}
