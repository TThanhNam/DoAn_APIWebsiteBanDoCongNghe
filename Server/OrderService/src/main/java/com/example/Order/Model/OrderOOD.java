package com.example.Order.Model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class OrderOOD implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private int OrderId;
	private int idCus;
	private String address;
	private String wayToPay;
	private String deliveryWay;
	private double totalMoney;
	public OrderOOD() {
		super();
	}
	public OrderOOD(int orderId, int idCus, String address, String wayToPay, String deliveryWay, double totalMoney) {
		super();
		OrderId = orderId;
		this.idCus = idCus;
		this.address = address;
		this.wayToPay = wayToPay;
		this.deliveryWay = deliveryWay;
		this.totalMoney = totalMoney;
	}
	public int getOrderId() {
		return OrderId;
	}
	public void setOrderId(int orderId) {
		OrderId = orderId;
	}
	public int getIdCus() {
		return idCus;
	}
	public void setIdCus(int idCus) {
		this.idCus = idCus;
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
	public double getTotalMoney() {
		return totalMoney;
	}
	public void setTotalMoney(double totalMoney) {
		this.totalMoney = totalMoney;
	}
	@Override
	public String toString() {
		return "OrderOOD [OrderId=" + OrderId + ", idCus=" + idCus + ", address=" + address + ", wayToPay=" + wayToPay
				+ ", deliveryWay=" + deliveryWay + ", totalMoney=" + totalMoney + "]";
	}
	
	
}
