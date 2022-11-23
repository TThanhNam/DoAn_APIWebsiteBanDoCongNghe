package com.example.Order.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.Order.Model.Cart;
import com.example.Order.Model.Customer;
import com.example.Order.Model.OrderCart;
import com.example.Order.Model.OrderCustomer;
import com.example.Order.Model.Order_Cart_Customer;
import com.example.Order.Entity.OrderO;
import com.example.Order.Repository.OrderRepository;

@Service
public class OrderService {
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private RestTemplate restTemplate;

	public List<OrderO> findAll() {
		return orderRepository.findAll();
	}

	public OrderO findById(Integer id) {
		return orderRepository.findById(id).get();
	}
	
	public void deleteById(Integer id) {
		orderRepository.deleteById(id);
	}
	
	public OrderO saveAndFlush(OrderO order) {
		return orderRepository.saveAndFlush(order);
	}

	public Order_Cart_Customer findByIdOCC(int id) {
		OrderO order = orderRepository.findById(id).get();
		Customer customer = restTemplate.getForObject("http://localhost:9005/Customer/"+order.getIdCus(),Customer.class);
		Cart cart = restTemplate.getForObject("http://localhost:9001/Cart/"+order.getCartID(),Cart.class);
		Order_Cart_Customer co = new  Order_Cart_Customer(order, cart, customer);
		return co;
	}
	
	public OrderCart findbyOC(int id) {
		OrderO order = orderRepository.findById(id).get();
		Cart cart = restTemplate.getForObject("http://localhost:9001/Cart/"+order.getCartID(),Cart.class);
		OrderCart co = new OrderCart(order, cart);
		return co;
	}
	
	public OrderCustomer findbyOCu(int id) {
		OrderO order = orderRepository.findById(id).get();
		Customer customer = restTemplate.getForObject("http://localhost:9005/Customer/"+order.getIdCus(),Customer.class);
		OrderCustomer co = new OrderCustomer(order, customer);
		return co;
	}
	
	public OrderO update(int id, OrderO order ) {
		OrderO order1 = orderRepository.findById(id).orElse(null);
		if (order1 == null) {
			return null;
		}
		order1.setCartID(order.getCartID());
		order1.setIdCus(order.getIdCus());
		order1.setAddress(order.getAddress());
		order1.setDeliveryWay(order.getDeliveryWay());
		order1.setWayToPay(order.getWayToPay());
		return orderRepository.save(order1);
	}

	
}
