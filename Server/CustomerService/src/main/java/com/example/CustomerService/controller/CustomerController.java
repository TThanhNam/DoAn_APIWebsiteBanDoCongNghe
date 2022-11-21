package com.example.CustomerService.controller;

import java.net.URISyntaxException;
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
import org.springframework.web.client.RestClientException;

import com.example.CustomerService.doubleEntity.AccountOfCustomer;
import com.example.CustomerService.entity.Customer;
import com.example.CustomerService.service.CustomerServiceImpl;

@RequestMapping("/Customer")
@RestController
public class CustomerController {
	@Autowired
	private CustomerServiceImpl customerServiceImpl;

	@GetMapping("/")
	public List<Customer> findAll() {
		return customerServiceImpl.findAll();
	}
	
	@DeleteMapping("/{id}")
	public String deleteById(@PathVariable int id) {
		return customerServiceImpl.deleteById(id);
	}
	@PostMapping("/save")
	public Customer saveCustomer(@RequestBody Customer customer) throws RestClientException, URISyntaxException {
		return customerServiceImpl.saveCustomer(customer);
	}
	@PutMapping("/{id}")
	public Customer updateCustomer(@PathVariable int id,@RequestBody Customer customer) {
		return customerServiceImpl.updateCustomer(id, customer);
	}
	
	@GetMapping("/call/{id}")
	public AccountOfCustomer getAccountOfCustomer(@PathVariable int id) {
		return customerServiceImpl.getAccountOfCustomer(id);
	}
	
	@GetMapping("/{id}")
	public Customer getCustomerbyId(@PathVariable int id) {
		return customerServiceImpl.findById(id);
	}
}	
