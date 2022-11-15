package com.example.Product.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Product.entity.Product;
import com.example.Product.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService{
	 @Autowired
	    private ProductRepository productRepository;

	@Override
	public void saveProduct(Product product) {
		// TODO Auto-generated method stub
		productRepository.save(product);
	}

	@Override
	public List<Product> getProduct() {
		// TODO Auto-generated method stub
		return productRepository.findAll();
	}

	@Override
	public void deleteProduct(int idPD) {
		// TODO Auto-generated method stub
		 productRepository.deleteById(idPD);
	}

	@Override
	public Product updateProduct(Product product) {
		// TODO Auto-generated method stub
		return productRepository.saveAndFlush(product);
	}

	

	@Override
	public Product getProduct(int idPD) {
		 Optional<Product> customer = productRepository.findById(idPD);
         return customer.get(); 
		
	}


	   
}
