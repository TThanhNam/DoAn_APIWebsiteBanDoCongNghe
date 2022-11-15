package com.example.detailCartService.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "cartDetails")
public class CartDetail implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cartDetailID;
	private int cartID;
	private int productID;
	private int quantity;
	public int getCartDetailID() {
		return cartDetailID;
	}
	public void setCartDetailID(int cartDetailID) {
		this.cartDetailID = cartDetailID;
	}
	public int getCartID() {
		return cartID;
	}
	public void setCartID(int cartID) {
		this.cartID = cartID;
	}
	public int getProductID() {
		return productID;
	}
	public void setProductID(int productID) {
		this.productID = productID;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public CartDetail(int cartDetailID, int cartID, int productID, int quantity) {
		super();
		this.cartDetailID = cartDetailID;
		this.cartID = cartID;
		this.productID = productID;
		this.quantity = quantity;
	}
	public CartDetail() {
		super();
	}
	@Override
	public String toString() {
		return "CartDetail [cartDetailID=" + cartDetailID + ", cartID=" + cartID + ", productID=" + productID
				+ ", quantity=" + quantity + "]";
	}
	
}
