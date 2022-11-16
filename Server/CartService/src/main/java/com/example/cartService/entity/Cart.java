package com.example.cartService.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Cart implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cartID;
	private double totalMoney;

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

	public Cart(int cartID, double totalMoney) {
		super();
		this.cartID = cartID;
		this.totalMoney = totalMoney;
	}

	public Cart() {
		super();
	}

	@Override
	public String toString() {
		return "Cart [cartID=" + cartID + ", totalMoney=" + totalMoney + "]";
	}

}
