package com.example.detailCartService.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.detailCartService.entity.CartDetail;
import com.example.detailCartService.model.ProductOfCartDetail;
@Repository
public interface CartDetailRepository extends JpaRepository<CartDetail, Integer>{

	@Query(value = "SELECT * FROM cartdetails WHERE cartid = ?1", nativeQuery = true)
	public List<CartDetail> getCartDetalAndProductByCartId(int id);
}
