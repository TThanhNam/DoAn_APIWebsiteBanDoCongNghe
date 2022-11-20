package com.example.cartService.model;

public class ProductOfCartDetail {
	
	private CartDetail cartDetail;
	private Product product;
	public ProductOfCartDetail() {
		super();
	}
	public ProductOfCartDetail(CartDetail cartDetail, Product product) {
		super();
		this.cartDetail = cartDetail;
		this.product = product;
	}
	public CartDetail getCartDetail() {
		return cartDetail;
	}
	public void setCartDetail(CartDetail cartDetail) {
		this.cartDetail = cartDetail;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	@Override
	public String toString() {
		return "ProductOfCartDetail [cartDetail=" + cartDetail + ", product=" + product + "]";
	}
	
	
}
