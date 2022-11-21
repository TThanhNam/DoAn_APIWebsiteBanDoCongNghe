package com.example.Order.Model;

import com.example.Order.Entity.OrderO;

public class Order_Cart_Customer {
	private OrderO order;
	private Customer customer;
	private Cart cart;
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
	public Cart getCart() {
		return cart;
	}
	public void setCart(Cart cart) {
		this.cart = cart;
	}
	public Order_Cart_Customer(OrderO order, Customer customer, Cart cart) {
		super();
		this.order = order;
		this.customer = customer;
		this.cart = cart;
	}
	public Order_Cart_Customer() {
		super();
	}
	@Override
	public String toString() {
		return "Order_Cart_Customer [ordeOr=" + order + ", customer=" + customer + ", cart=" + cart + "]";
	}
	
}
