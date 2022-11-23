package com.example.Order.Model;

import java.io.Serializable;

import com.example.Order.Entity.OrderO;

public class OrderCart implements Serializable{
	private OrderO order;
	private Cart cart;
	public OrderO getOrder() {
		return order;
	}
	public void setOrder(OrderO order) {
		this.order = order;
	}
	public Cart getCart() {
		return cart;
	}
	public void setCart(Cart cart) {
		this.cart = cart;
	}
	public OrderCart(OrderO order, Cart cart) {
		super();
		this.order = order;
		this.cart = cart;
	}
	public OrderCart() {
		super();
	}
	@Override
	public String toString() {
		return "OrderCart [order=" + order + ", cart=" + cart + "]";
	}
	
}
