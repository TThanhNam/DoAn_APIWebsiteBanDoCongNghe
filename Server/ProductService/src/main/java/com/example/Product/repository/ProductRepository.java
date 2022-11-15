package com.example.Product.repository;


import org.springframework.data.jpa.repository.JpaRepository;


import com.example.Product.entity.Product;
public interface ProductRepository extends JpaRepository<Product, Integer>{
	 
}
