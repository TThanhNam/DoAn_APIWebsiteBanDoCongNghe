package com.example.Product.service;

import java.util.List;

import com.example.Product.entity.Product;

public interface ProductService {
	public void saveProduct(Product product);
	public List<Product> getProduct();
	public void deleteProduct(int idPD);
	public Product updateProduct(Product product);
	public Product getProduct(int idPD);
	

}
