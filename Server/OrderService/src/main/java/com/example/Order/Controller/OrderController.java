package com.example.Order.Controller;

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

import com.example.Order.Model.Order_Cart_Customer;
import com.example.Order.Entity.OrderO;
import com.example.Order.Service.OrderService;

import io.github.resilience4j.retry.annotation.Retry;

@RestController
@RequestMapping("/Order")
public class OrderController {
	@Autowired
	private OrderService orderService;
	private int solan = 1;
	
	@GetMapping("/")
	public List<OrderO> getAllOrder() {
		return orderService.findAll();
	}
	
	@Cacheable(key = "#id",value ="orders")
	@GetMapping("/{id}")
	public OrderO getById(@PathVariable int id) {		
		return orderService.findById(id);
	}
	
	@PostMapping("/")
	private OrderO createOrder(@RequestBody OrderO order) {
		// TODO Auto-generated method stub
		return orderService.saveAndFlush(order);
	}
	
	@CacheEvict(value = "orders",allEntries = false,key = "#id")
	@DeleteMapping("/{id}")
	private String deleteOrder(@PathVariable int id) {
		orderService.deleteById(id);
		return "Delete id" + id;
	}
	
	@Cacheable(key = "#id",value ="orders")
	@GetMapping("/call/{id}")
	public Order_Cart_Customer getOCC(@PathVariable int id) {
		return orderService.findByIdOCC(id);
	}
	
	
	@CachePut(value = "orders",key = "#id")
	@Retry(name = "OrderService")
	@PutMapping("/{id}")
	public OrderO update(@PathVariable int id, @RequestBody OrderO order) {
		System.out.println("Call lan thu : "+ solan);
		solan++;
		System.out.println("Load tu DB");
		return orderService.update(id, order);
	}
	
	
}
