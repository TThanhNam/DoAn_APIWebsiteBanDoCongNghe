package com.example.Product.service;

import java.util.List;

import com.example.Product.entity.Product;

public interface ProductService {
	public Product saveProduct(Product product);
	public List<Product> getProduct();
	public String deleteProduct(int idPD);
	public Product updateProduct(int idPD, Product product);
	public Product getProduct(int idPD);
	
	

}
