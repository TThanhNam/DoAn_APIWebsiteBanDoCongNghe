package com.example.Order.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Order.Model.CustomerOfOrder;
import com.example.Order.Model.OrderOOD;
import com.example.Order.Service.OrderService;

@RestController
@RequestMapping("/OrderOOD")
public class OrderController {
	@Autowired
	private OrderService orderService;
	
	@GetMapping("/")
	private List<OrderOOD> getAllOrder() {
		// TODO Auto-generated method stub
		return orderService.findAll();
	}
	
	@GetMapping("/{id}")
	public OrderOOD getById(@PathVariable int id) {
		return orderService.findById(id);
	}
	
	@PostMapping("/")
	private OrderOOD createOrder(@RequestBody OrderOOD orderOOD) {
		// TODO Auto-generated method stub
		return orderService.saveAndFlush(orderOOD);
	}
	
	@DeleteMapping("/{id}")
	private String deleteOrder(@PathVariable int id) {
		orderService.deleteById(id);
		return "Delete id" + id;
	}
	
	@GetMapping("/call/id")
	public CustomerOfOrder getCustomerOfOrder(int id) {
		return orderService.findByIdCustomerOrder(id);
	}
}
