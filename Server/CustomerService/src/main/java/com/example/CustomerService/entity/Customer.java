package com.example.CustomerService.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;

@Entity
public class Customer implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8688810190781019781L;

	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idCus;
	private int idAcc;
	private String nameCus;
	private String sexCus;
	private String phoneCus;
	private String addressCus;
	@CreationTimestamp
	private Date joinDateCus;
	private int cartId;

	public Customer() {
		super();
	}

	

	public Customer(int idCus, int idAcc, String nameCus, String sexCus, String phoneCus, String addressCus,
			Date joinDateCus, int cartId) {
		super();
		this.idCus = idCus;
		this.idAcc = idAcc;
		this.nameCus = nameCus;
		this.sexCus = sexCus;
		this.phoneCus = phoneCus;
		this.addressCus = addressCus;
		this.joinDateCus = joinDateCus;
		this.cartId = cartId;
	}



	public int getIdCus() {
		return idCus;
	}

	public void setIdCus(int idCus) {
		this.idCus = idCus;
	}

	public int getIdAcc() {
		return idAcc;
	}

	public void setIdAcc(int idAcc) {
		this.idAcc = idAcc;
	}

	public String getNameCus() {
		return nameCus;
	}

	public void setNameCus(String nameCus) {
		this.nameCus = nameCus;
	}

	public String getSexCus() {
		return sexCus;
	}

	public void setSexCus(String sexCus) {
		this.sexCus = sexCus;
	}

	public String getPhoneCus() {
		return phoneCus;
	}

	public void setPhoneCus(String phoneCus) {
		this.phoneCus = phoneCus;
	}

	public String getAddressCus() {
		return addressCus;
	}

	public void setAddressCus(String addressCus) {
		this.addressCus = addressCus;
	}

	public Date getJoinDateCus() {
		return joinDateCus;
	}

	public void setJoinDateCus(Date joinDateCus) {
		this.joinDateCus = joinDateCus;
	}

	public int getCartId() {
		return cartId;
	}

	public void setCartId(int cartId) {
		this.cartId = cartId;
	}

	@Override
	public String toString() {
		return "Customer [idCus=" + idCus + ", idAcc=" + idAcc + ", nameCus=" + nameCus + ", sexCus=" + sexCus
				+ ", phoneCus=" + phoneCus + ", addressCus=" + addressCus + ", joinDateCus=" + joinDateCus + ", cartId="
				+ cartId + "]";
	}

	
}
