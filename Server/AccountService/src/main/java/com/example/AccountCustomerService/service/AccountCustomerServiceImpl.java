package com.example.AccountCustomerService.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.AccountCustomerService.entity.AccountCustomer;
import com.example.AccountCustomerService.entity.Customer;
import com.example.AccountCustomerService.repository.AccountCustomerRepository;

@Service
public class AccountCustomerServiceImpl {
	@Autowired
	private AccountCustomerRepository accountCustomerRepository;
	@Autowired
	private RestTemplate restTemplate;

	public List<AccountCustomer> findAll() {
		return accountCustomerRepository.findAll();
	}

	public AccountCustomer findById(int id) {
		Optional<AccountCustomer> acc = accountCustomerRepository.findById(id);
		if (acc.isPresent()) {
			System.out.println("Đã tìm thấy");
			return acc.get();
		} else {
			throw new RuntimeException("Server không phản hồi");
		}
	}
	
	public String deleteById(int id) {
		accountCustomerRepository.deleteById(id);
		return "Xoa thanh cong";
	}

	public void deleteAll() {
		accountCustomerRepository.deleteAll();
	}

	public AccountCustomer saveAccountCustomer(AccountCustomer acc) {
		RestTemplate restTemplate = new RestTemplate();
		String link = "http://localhost:9005/Customer/";
		Date date = new Date();
		Random random = new Random();
		acc = new AccountCustomer(random.nextInt(10000),random.nextInt(10000),acc.getAccount(),acc.getPassword());
		Customer customer = new Customer(acc.getIdCus(), acc.getIdAcc(),"","","","", date);
		HttpEntity<Customer> request = new HttpEntity<>(customer);
		Customer foo = restTemplate.postForObject(link, request, Customer.class);
		return accountCustomerRepository.save(acc);
	}

	public AccountCustomer updateAccountCustomer(int id, AccountCustomer account) {
		AccountCustomer accCus = accountCustomerRepository.findById(id).orElse(null);
		if (accCus == null) {
			return null;
		}
		accCus.setAccount(account.getAccount());
		accCus.setPassword(account.getPassword());
		return accountCustomerRepository.save(accCus);
	}
	public List<AccountCustomer> login(String account, String password) {
		return accountCustomerRepository.login(account, password);
	}
}
