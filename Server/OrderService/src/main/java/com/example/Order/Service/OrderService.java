package com.example.Order.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.Order.Model.Customer;
import com.example.Order.Model.CustomerOfOrder;
import com.example.Order.Model.OrderOOD;
import com.example.Order.Repository.OrderRepository;

@Service
public class OrderService {
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private RestTemplate restTemplate;

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
	
	public CustomerOfOrder findByIdCustomerOrder(int id) {
		OrderOOD order = orderRepository.findById(id).get();
		Customer customer = restTemplate.getForObject("http://localhost:9005/Customer/"+order.getIdCus(),Customer.class);
		CustomerOfOrder co = new CustomerOfOrder(order,customer);
		return co;
	}
}
