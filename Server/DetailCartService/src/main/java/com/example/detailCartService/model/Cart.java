package com.example.detailCartService.model;

import java.io.Serializable;

public class Cart implements Serializable {

	private int cartID;
	private int idCus;
	private double totalMoney = 0;
	
	public Cart(int cartID, int idCus, double totalMoney) {
		super();
		this.cartID = cartID;
		this.idCus = idCus;
		this.totalMoney = totalMoney;
	}

	public Cart(int idCus, double totalMoney) {
		super();
		this.idCus = idCus;
		this.totalMoney = totalMoney;
	}

	public Cart() {
		super();
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

	public double getTotalMoney() {
		return totalMoney;
	}

	public void setTotalMoney(double totalMoney) {
		this.totalMoney = totalMoney;
	}
	
	@Override
	public String toString() {
		return "Cart [cartID=" + cartID + ", totalMoney=" + totalMoney + "]";
	}

}
