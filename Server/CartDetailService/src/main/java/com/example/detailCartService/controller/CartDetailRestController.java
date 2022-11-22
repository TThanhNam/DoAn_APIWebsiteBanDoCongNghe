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

@RestController
@RequestMapping("/CartDetail")
public class CartDetailRestController {
	
	@Autowired
	private CartDetailService cartDetailService; 
	
	@GetMapping("/")
	public List<CartDetail> getCartDetails(){
		return cartDetailService.findAll();
	}
	
	@GetMapping("/{id}")
	public ProductOfCartDetail getCartDetailID(@PathVariable int id) {
		return cartDetailService.findById(id);
	}
	
	@GetMapping("/CartDetailAndProduct")
	private List<ProductOfCartDetail> getCartDetailAndProduct() {
		// TODO Auto-generated method stub
		return cartDetailService.findAllCartDetalAndProduct();
	}
	
	@GetMapping("/getByCartId/{id}")
	private List<ProductOfCartDetail> getByCartId(@PathVariable int id) {
		// TODO Auto-generated method stub
		return cartDetailService.getCartDetalAndProductByCartId(id);
	}
		
	@PostMapping("/")
	public CartDetail saveCartDetail(@RequestBody CartDetail cartDetail) {
		return cartDetailService.saveAndFlush(cartDetail);
	}
	
	@DeleteMapping("/{id}")
	public String deleteCartDetail(@PathVariable int id) {
		cartDetailService.deleteById(id);
		return "Xóa thành công " + id;
	}
	
	@DeleteMapping("/")
	public String deleteAllCartDetail() {
		cartDetailService.deleteAll();
		return "Xóa thành công ";
	}
	
	@PutMapping("/")
	public CartDetail update(@RequestBody CartDetail cartDetail) {
		return cartDetailService.saveAndFlush(cartDetail);
	}
	
}
