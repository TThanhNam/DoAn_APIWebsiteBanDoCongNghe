package com.example.cartService.entity;

import java.util.List;

public class CartAndCartDetail {
	private Cart cart;
	private List<ProductOfCartDetail> lsCartDetails;
	public CartAndCartDetail() {
		super();
	}
	public CartAndCartDetail(Cart cart, List<ProductOfCartDetail> lsCartDetails) {
		super();
		this.cart = cart;
		this.lsCartDetails = lsCartDetails;
	}
	public Cart getCart() {
		return cart;
	}
	public void setCart(Cart cart) {
		this.cart = cart;
	}
	public List<ProductOfCartDetail> getLsCartDetails() {
		return lsCartDetails;
	}
	public void setLsCartDetails(List<ProductOfCartDetail> lsCartDetails) {
		this.lsCartDetails = lsCartDetails;
	}
	@Override
	public String toString() {
		return "CartAndCartDetail [cart=" + cart + ", lsCartDetails=" + lsCartDetails + "]";
	}
}
