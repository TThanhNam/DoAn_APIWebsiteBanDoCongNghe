package com.example.Order.Model;

public class CustomerOfOrder {
	private OrderOOD orderOOD;
	private Customer customer;
	public OrderOOD getOrderOOD() {
		return orderOOD;
	}
	public void setOrderOOD(OrderOOD orderOOD) {
		this.orderOOD = orderOOD;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public CustomerOfOrder(OrderOOD orderOOD, Customer customer) {
		super();
		this.orderOOD = orderOOD;
		this.customer = customer;
	}
	public CustomerOfOrder() {
		super();
	}
	@Override
	public String toString() {
		return "CustomerOfOrder [orderOOD=" + orderOOD + ", customer=" + customer + "]";
	}
	
}
