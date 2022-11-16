package com.example.Product.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Product.entity.Product;
import com.example.Product.service.ProductService;
import com.example.Product.service.ProductServiceImpl;

@RequestMapping("/Product")
@RestController
public class ProductController {
	@Autowired
	private ProductServiceImpl productService;

	@PostMapping("/save")
	public Product addProduct(@RequestBody Product product) {
		return productService.saveProduct(product);
		 
	}

	@GetMapping("/")
	public List<Product> getProduct() {
		return productService.getProduct();
	}

	@GetMapping("/{idPD}")
	public Product getProduct(@PathVariable int idPD) {
		
		return productService.getProduct(idPD);
	}

	@DeleteMapping("/{idPD}")
	public String deleteProduct(@PathVariable int idPD) {
		
		return productService.deleteProduct(idPD);

	}

	@PutMapping("/{idPD}")
	public Product updateProduct(@PathVariable int idPD,@RequestBody Product product) {
		return productService.updateProduct(idPD, product);
		
	}
}
