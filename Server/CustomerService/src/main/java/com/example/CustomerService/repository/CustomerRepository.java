package com.example.CustomerService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.CustomerService.entity.Customer;
@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
	
}
