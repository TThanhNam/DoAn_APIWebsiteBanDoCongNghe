package com.example.detailCartService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.detailCartService.entity.CartDetail;
@Repository
public interface CartDetailRepository extends JpaRepository<CartDetail, Integer>{

}
