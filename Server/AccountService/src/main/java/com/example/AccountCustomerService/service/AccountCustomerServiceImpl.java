package com.example.AccountCustomerService.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.AccountCustomerService.entity.AccountCustomer;
import com.example.AccountCustomerService.repository.AccountCustomerRepository;
@Service
public class AccountCustomerServiceImpl {
	@Autowired
	private AccountCustomerRepository accountCustomerRepository;

	public List<AccountCustomer> findAll() {
		return accountCustomerRepository.findAll();
	}

	public AccountCustomer findById(int id) {
		Optional<AccountCustomer> acc = accountCustomerRepository.findById(id);
		return acc.get();
	}

	public String deleteById(int id) {
		accountCustomerRepository.deleteById(id);
		return "Xoa thanh cong";
	}
	
	
	public void deleteAll() {
		accountCustomerRepository.deleteAll();
	}

	public AccountCustomer saveAccountCustomer (AccountCustomer acc) {
		
		return accountCustomerRepository.save(acc);
	}
	
	public AccountCustomer updateAccountCustomer (int id, AccountCustomer account) {
		AccountCustomer accCus = accountCustomerRepository.findById(id).orElse(null);
		if (accCus == null) {
			return null;
		}
		accCus.setAccount(account.getAccount());
		accCus.setPassword(account.getPassword());
		return accountCustomerRepository.save(accCus);
	}
}
