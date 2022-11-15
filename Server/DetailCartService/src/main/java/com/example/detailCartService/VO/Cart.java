package com.example.detailCartService.VO;

public class Cart {
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
