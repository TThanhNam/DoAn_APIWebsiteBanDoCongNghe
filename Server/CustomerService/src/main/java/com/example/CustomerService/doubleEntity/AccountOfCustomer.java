package com.example.CustomerService.doubleEntity;

import java.io.Serializable;

import com.example.CustomerService.entity.Customer;

public class AccountOfCustomer implements Serializable {
	private AccountCustomer accountCustomer;
	private Customer customer;

	public AccountCustomer getAccountCustomer() {
		return accountCustomer;
	}

	public void setAccountCustomer(AccountCustomer accountCustomer) {
		this.accountCustomer = accountCustomer;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public AccountOfCustomer(AccountCustomer accountCustomer, Customer customer) {
		super();
		this.accountCustomer = accountCustomer;
		this.customer = customer;
	}

	public AccountOfCustomer() {
		super();
	}

	

}
