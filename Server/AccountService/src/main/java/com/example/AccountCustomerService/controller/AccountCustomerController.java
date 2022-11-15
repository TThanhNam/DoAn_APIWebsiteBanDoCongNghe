package com.example.AccountCustomerService.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.AccountCustomerService.entity.AccountCustomer;
import com.example.AccountCustomerService.service.AccountCustomerServiceImpl;

@RestController
@RequestMapping("/Account")
public class AccountCustomerController {
	@Autowired
	private AccountCustomerServiceImpl accountCustomerServiceImpl;
	
	@GetMapping("/")
	public List<AccountCustomer> findAll(){
		return accountCustomerServiceImpl.findAll();
	}
	
	@GetMapping("/{id}")
	public AccountCustomer findById(@PathVariable int id) {
		return accountCustomerServiceImpl.findById(id);
	}
	
	@DeleteMapping("/{id}")
	public String deleteById(@PathVariable int id) {
		return accountCustomerServiceImpl.deleteById(id);
	}
	
	@PostMapping("/save")
	public AccountCustomer saveAccountCustomer (@RequestBody AccountCustomer acc) {
		return accountCustomerServiceImpl.saveAccountCustomer(acc);
	}
	
	@PutMapping("/{id}")
	public AccountCustomer updateAccountCustomer (@PathVariable int id,@RequestBody AccountCustomer account) {
		return accountCustomerServiceImpl.updateAccountCustomer(id, account);
	}
}
