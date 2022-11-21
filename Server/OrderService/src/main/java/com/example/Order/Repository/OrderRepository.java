package com.example.Order.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Order.Entity.OrderO;

@Repository
public interface OrderRepository extends JpaRepository<OrderO, Integer>{

}
