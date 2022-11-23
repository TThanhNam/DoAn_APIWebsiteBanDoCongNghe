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

import com.example.Order.Model.OrderCart;
import com.example.Order.Model.OrderCustomer;
import com.example.Order.Model.Order_Cart_Customer;
import com.example.Order.Entity.OrderO;
import com.example.Order.Service.OrderService;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
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
//	@RateLimiter(name = "getOCU", fallbackMethod = "rateLimitterFallBack")
//	@CircuitBreaker(name = "OrderCart")
	@Retry(name = "OrderService")
	public OrderO getById(@PathVariable int id) {		
		System.out.println("So lan call thu " +solan);
		solan++;
		return orderService.findById(id);
	}
	
	@PostMapping("/")
	public OrderO createOrder(@RequestBody OrderO order) {
		System.out.println(order);
		// TODO Auto-generated method stub
		return orderService.saveAndFlush(order);
	}
	
	@CacheEvict(value = "orders",allEntries = false,key = "#id")
	@DeleteMapping("/{id}")
	public String deleteOrder(@PathVariable int id) {
		orderService.deleteById(id);
		return "Delete id" + id;
	}
	
	@Cacheable(key = "#id",value ="orders")
	@Retry(name = "OrderService")
	@GetMapping("/call/{id}")
	public Order_Cart_Customer getOCC(@PathVariable int id) {
		System.out.println("So lan call thu " +solan);
		solan++;
		return orderService.findByIdOCC(id);
	}
	
	@Cacheable(key = "#id",value ="orders")
	@GetMapping("/call1/{id}")
	public OrderCart getOC(@PathVariable int id) {
		return orderService.findbyOC(id);
	}
	
	@Cacheable(key = "#id",value ="orders")
	@GetMapping("/call2/{id}")
	@RateLimiter(name = "getOCU", fallbackMethod = "rateLimitterFallBack")
	public OrderCustomer getOCU(@PathVariable int id) {
		return orderService.findbyOCu(id);
	}
	
	@CachePut(value = "orders",key = "#id")
	@PutMapping("/{id}")
	public OrderO update(@PathVariable int id, @RequestBody OrderO order) {
		return orderService.update(id, order);
	}
	
	public OrderCustomer rateLimitterFallBack(Exception e) {
		for (int i = 0; i < 5; i++) {
			System.out.println("Quá nhiều request");
		}
		return null;
	}
	
}
