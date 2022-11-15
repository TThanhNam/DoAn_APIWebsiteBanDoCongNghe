package com.example.detailCartService.VO;

import com.example.detailCartService.entity.CartDetail;

public class CartDetail_Cart_Product {
	private CartDetail cartDetail;
	private Cart cart;
	private Product product;
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
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public CartDetail_Cart_Product(CartDetail cartDetail, Cart cart, Product product) {
		super();
		this.cartDetail = cartDetail;
		this.cart = cart;
		this.product = product;
	}
	public CartDetail_Cart_Product() {
		super();
	}
	@Override
	public String toString() {
		return "CartDetail_Cart_Product [cartDetail=" + cartDetail + ", cart=" + cart + ", product=" + product + "]";
	}
	
}
