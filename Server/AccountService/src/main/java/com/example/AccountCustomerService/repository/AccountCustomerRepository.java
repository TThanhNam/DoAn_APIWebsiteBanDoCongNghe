package com.example.AccountCustomerService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.AccountCustomerService.entity.AccountCustomer;
@Repository
public interface AccountCustomerRepository extends JpaRepository<AccountCustomer, Integer> {

}
