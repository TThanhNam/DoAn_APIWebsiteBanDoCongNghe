package com.example.CustomerService.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.CustomerService.doubleEntity.AccountCustomer;
import com.example.CustomerService.doubleEntity.AccountOfCustomer;
import com.example.CustomerService.entity.Customer;
import com.example.CustomerService.repository.CustomerRepository;

@Service
public class CustomerServiceImpl {
	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private RestTemplate restTemplate;

	public List<Customer> findAll() {
		return customerRepository.findAll();
	}

	public Customer findById(int id) {
		return customerRepository.findById(id).get();
	}

	public String deleteById(int id) {
		customerRepository.deleteById(id);
		return "Xoa thanh cong";
	}

	public Customer saveCustomer(Customer customer) {
		return customerRepository.save(customer);
	}

	public Customer updateCustomer(int id, Customer customer) {
		Customer customer1 = customerRepository.findById(id).orElse(null);
		if (customer1 == null) {
			return null;
		}
		customer1.setAddressCus(customer.getAddressCus());
		customer1.setCartId(customer.getCartId());
		customer1.setIdAcc(customer.getIdAcc());
		customer1.setJoinDateCus(customer.getJoinDateCus());
		customer1.setNameCus(customer.getNameCus());
		customer1.setPhoneCus(customer.getPhoneCus());
		customer1.setSexCus(customer.getSexCus());
		return customerRepository.save(customer1);
	}

	public AccountOfCustomer getAccountOfCustomer(int idCus) {
		Customer customer = customerRepository.findById(idCus).get();
		AccountCustomer accountCustomer = restTemplate
				.getForObject("http://localhost:9006/Account/" + customer.getIdAcc(), AccountCustomer.class);
		AccountOfCustomer accountOfCustomer = new AccountOfCustomer(accountCustomer, customer);
		return accountOfCustomer;
	}
}
