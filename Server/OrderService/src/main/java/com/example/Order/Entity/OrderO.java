package com.example.Order.Entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "orders")
public class OrderO implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int orderID;
	private int idCus;
	private int cartID;
	private String address;
	private String wayToPay;
	private String deliveryWay;
	public int getOrderID() {
		return orderID;
	}
	public void setOrderID(int orderID) {
		this.orderID = orderID;
	}
	public int getIdCus() {
		return idCus;
	}
	public void setIdCus(int idCus) {
		this.idCus = idCus;
	}
	public int getCartID() {
		return cartID;
	}
	public void setCartID(int cartID) {
		this.cartID = cartID;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getWayToPay() {
		return wayToPay;
	}
	public void setWayToPay(String wayToPay) {
		this.wayToPay = wayToPay;
	}
	public String getDeliveryWay() {
		return deliveryWay;
	}
	public void setDeliveryWay(String deliveryWay) {
		this.deliveryWay = deliveryWay;
	}
	public OrderO(int orderID, int idCus, int cartID, String address, String wayToPay, String deliveryWay) {
		super();
		this.orderID = orderID;
		this.idCus = idCus;
		this.cartID = cartID;
		this.address = address;
		this.wayToPay = wayToPay;
		this.deliveryWay = deliveryWay;
	}
	public OrderO() {
		super();
	}
	@Override
	public String toString() {
		return "OrderO [orderID=" + orderID + ", idCus=" + idCus + ", cartID=" + cartID + ", address=" + address
				+ ", wayToPay=" + wayToPay + ", deliveryWay=" + deliveryWay + "]";
	}
	
	
	
}
