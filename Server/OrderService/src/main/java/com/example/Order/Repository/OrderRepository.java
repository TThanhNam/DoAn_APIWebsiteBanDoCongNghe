package com.example.Order.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Order.Model.OrderOOD;

@Repository
public interface OrderRepository extends JpaRepository<OrderOOD, Integer>{

}
