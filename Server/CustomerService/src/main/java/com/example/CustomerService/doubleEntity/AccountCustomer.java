package com.example.CustomerService.doubleEntity;

import java.io.Serializable;

public class AccountCustomer implements Serializable {
	private int idAcc;
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

	public AccountCustomer(int idAcc, String account, String password) {
		super();
		this.idAcc = idAcc;
		this.account = account;
		this.password = password;
	}

	public AccountCustomer() {
		super();
	}

	@Override
	public String toString() {
		return "AccountCustomer [idAcc=" + idAcc + ", account=" + account + ", password=" + password + "]";
	}

}
