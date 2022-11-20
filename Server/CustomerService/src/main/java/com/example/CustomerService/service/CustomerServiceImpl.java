package com.example.CustomerService.service;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.example.CustomerService.doubleEntity.AccountCustomer;
import com.example.CustomerService.doubleEntity.AccountOfCustomer;
import com.example.CustomerService.doubleEntity.CartVO;
import com.example.CustomerService.entity.Customer;
import com.example.CustomerService.repository.CustomerRepository;
import com.fasterxml.jackson.databind.util.JSONPObject;

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
	
	public String deleteAll() {
		customerRepository.deleteAll();
		return "Xóa hết thành công";
	}

	public Customer saveCustomer(Customer customer) throws RestClientException, URISyntaxException {
		int cusID = (int) Math.floor(((Math.random() * 899999) + 100000));
		customer.setIdCus(cusID);
		CartVO cartVO = new CartVO(cusID, 0);
		HttpEntity<CartVO> reques = new HttpEntity<>(cartVO);
		ResponseEntity<CartVO> cart = restTemplate.postForEntity("http://localhost:9001/Cart/", reques, CartVO.class);
		System.out.println(cart);
		return customerRepository.save(customer);
	}

	public Customer updateCustomer(int id, Customer customer) {
		Customer customer1 = customerRepository.findById(id).orElse(null);
		if (customer1 == null) {
			return null;
		}
		customer1.setAddressCus(customer.getAddressCus());
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
