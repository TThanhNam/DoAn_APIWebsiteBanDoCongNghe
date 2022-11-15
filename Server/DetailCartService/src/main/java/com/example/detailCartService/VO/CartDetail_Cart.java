package com.example.detailCartService.VO;

import com.example.detailCartService.entity.CartDetail;

public class CartDetail_Cart {
	private CartDetail cartDetail;
	private Cart cart;
	public CartDetail getCartDetail() {
		return cartDetail;
	}
	public void setCartDetail(CartDetail cartDetail) {
		this.cartDetail = cartDetail;
	}
	public Cart getCart() {
		return cart;
	}
	public void setCart(Cart cart) {
		this.cart = cart;
	}
	public CartDetail_Cart(CartDetail cartDetail, Cart cart) {
		super();
		this.cartDetail = cartDetail;
		this.cart = cart;
	}
	public CartDetail_Cart() {
		super();
	}
	@Override
	public String toString() {
		return "CartDetail_Cart [cartDetail=" + cartDetail + ", cart=" + cart + "]";
	}
	
}
