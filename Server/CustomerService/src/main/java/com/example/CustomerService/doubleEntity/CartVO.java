package com.example.CustomerService.doubleEntity;

public class CartVO {
	private int cartID;
	private int idCus;
	private double totalMoney = 0;
	
	public CartVO() {
		super();
	}
		
	public CartVO(int cartID, int idCus, double totalMoney) {
		super();
		this.cartID = cartID;
		this.idCus = idCus;
		this.totalMoney = totalMoney;
	}

	public CartVO(int idCus, double totalMoney) {
		super();
		this.idCus = idCus;
		this.totalMoney = totalMoney;
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
		return "CartVO [cartID=" + cartID + ", idCus=" + idCus + ", totalMoney=" + totalMoney + "]";
	}

	
}
