package com.example.Order.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Order.Model.OrderOOD;
import com.example.Order.Repository.OrderRepository;

@Service
public class OrderService {
	
	@Autowired
	private OrderRepository orderRepository;

	public List<OrderOOD> findAll() {
		return orderRepository.findAll();
	}
	
	

	public OrderOOD findById(Integer id) {
		return orderRepository.findById(id).get();
	}

	public OrderOOD saveAndFlush(OrderOOD orderOOD) {
		return orderRepository.saveAndFlush(orderOOD);
	}

	public void deleteById(Integer id) {
		orderRepository.deleteById(id);
	}
	
	
}
