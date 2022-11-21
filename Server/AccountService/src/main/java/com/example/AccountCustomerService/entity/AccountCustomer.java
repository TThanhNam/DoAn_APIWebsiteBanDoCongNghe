package com.example.AccountCustomerService.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class AccountCustomer implements Serializable {
	@Id
	private int idAcc;
	private int idCus;
	private String account;
	private String password;

	public int getIdAcc() {
		return idAcc;
	}

	public void setIdAcc(int idAcc) {
		this.idAcc = idAcc;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getIdCus() {
		return idCus;
	}

	public void setIdCus(int idCus) {
		this.idCus = idCus;
	}

	public AccountCustomer(int idAcc, int idCus, String account, String password) {
		super();
		this.idAcc = idAcc;
		this.idCus = idCus;
		this.account = account;
		this.password = password;
	}

	public AccountCustomer() {
		super();
	}

	@Override
	public String toString() {
		return "AccountCustomer [idAcc=" + idAcc + ", idCus=" + idCus + ", account=" + account + ", password="
				+ password + "]";
	}



}
