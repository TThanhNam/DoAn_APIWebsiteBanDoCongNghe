package com.example.detailCartService.controller;

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

import com.example.detailCartService.entity.CartDetail;
import com.example.detailCartService.entity.ProductOfCartDetail;
import com.example.detailCartService.service.CartDetailService;

import io.github.resilience4j.retry.annotation.Retry;

@RestController
@RequestMapping("/CartDetail")
public class CartDetailRestController {
	
	@Autowired
	private CartDetailService cartDetailService; 
	
	private int solan = 1;
	
	@GetMapping("/")
	public List<CartDetail> getCartDetails(){
		return cartDetailService.findAll();
	}
	
	
	@GetMapping("/{id}")
	@Retry(name = "DETAILCARTSERVICE")
	@Cacheable(key = "#id",value ="cartDetails")
	public ProductOfCartDetail getCartDetailID(@PathVariable int id) {
		System.out.println("Call lan thu: " +solan);
		solan++;
		System.out.println("Load tu DB");
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
	@CacheEvict(value = "cartDetails",allEntries = false,key = "#id")
	public String deleteCartDetail(@PathVariable int id) {
		cartDetailService.deleteById(id);
		return "Xóa thành công " + id;
	}
	
	@PutMapping("/{id}")
	@CachePut(value = "cartDetails",key = "#id")
	public CartDetail update(@PathVariable int id,@RequestBody CartDetail cartDetail) {
		return cartDetailService.update(id, cartDetail);
	}
	
}
