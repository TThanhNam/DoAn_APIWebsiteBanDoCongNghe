package com.example.AccountCustomerService.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.AccountCustomerService.entity.AccountCustomer;
@Repository
public interface AccountCustomerRepository extends JpaRepository<AccountCustomer, Integer> {
	@Query(value = "SELECT * FROM public.accountcustomer WHERE account like ?1 and password like ?2",nativeQuery = true)
	public List<AccountCustomer> login (String account, String password);
}
