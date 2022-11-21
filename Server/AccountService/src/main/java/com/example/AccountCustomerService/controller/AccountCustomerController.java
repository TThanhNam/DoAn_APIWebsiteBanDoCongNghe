package com.example.AccountCustomerService.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
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

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;

@RestController
@RequestMapping("/Account")
public class AccountCustomerController {
	@Autowired
	private AccountCustomerServiceImpl accountCustomerServiceImpl;
	int call = 1;

	@GetMapping("/")
	public List<AccountCustomer> findAll() {
		return accountCustomerServiceImpl.findAll();
	}

	@Retry(name = "findOneAccount")
	@GetMapping("/{id}")
	@Cacheable(value = "Account", key = "#id")
	public AccountCustomer findById(@PathVariable int id) {
		System.out.println("Số lần gọi :" + call);
		call++;
		return accountCustomerServiceImpl.findById(id);
	}

	@DeleteMapping("/{id}")
	@CacheEvict(value = "Account", allEntries = false, key = "#id")
	public String deleteById(@PathVariable int id) {
		return accountCustomerServiceImpl.deleteById(id);
	}

	@PostMapping("/save")
	public AccountCustomer saveAccountCustomer(@RequestBody AccountCustomer acc) {
		return accountCustomerServiceImpl.saveAccountCustomer(acc);
	}

	@PutMapping("/{id}")
	@CachePut(value = "Account", key = "#id")
	public AccountCustomer updateAccountCustomer(@PathVariable int id, @RequestBody AccountCustomer account) {
		return accountCustomerServiceImpl.updateAccountCustomer(id, account);
	}

	@GetMapping("/{account}/{password}")
	public String login(@PathVariable String account, @PathVariable String password) {
		List<AccountCustomer> ls = findAll();
		for (AccountCustomer accountCustomer : ls) {
			if (accountCustomer.getAccount().equals(account) && accountCustomer.getPassword().equals(password)) {
				accountCustomerServiceImpl.login(account, password);
				return "Login thành công";
			}
		}
		return "Sai tài khoản hoặc mật khẩu";

	}
}
