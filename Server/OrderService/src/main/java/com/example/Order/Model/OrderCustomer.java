package com.example.Order.Model;

import java.io.Serializable;

import com.example.Order.Entity.OrderO;

public class OrderCustomer implements Serializable{
	private OrderO order;
	private Customer customer;
	public OrderO getOrder() {
		return order;
	}
	public void setOrder(OrderO order) {
		this.order = order;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public OrderCustomer(OrderO order, Customer customer) {
		super();
		this.order = order;
		this.customer = customer;
	}
	public OrderCustomer() {
		super();
	}
	@Override
	public String toString() {
		return "OrderCustomer [order=" + order + ", customer=" + customer + "]";
	}
	
}
