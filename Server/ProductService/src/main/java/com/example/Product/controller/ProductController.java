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
		productService.saveProduct(product);
		return product;
	}

	@GetMapping("/")
	public List<Product> getProduct() {
		return productService.getProduct();
	}

	@GetMapping("/{idPD}")
	public Product getProduct(@PathVariable int idPD) {
		Product product = productService.getProduct(idPD);
		if (product == null) {
			return null;
		}
		return product;
	}

	@DeleteMapping("/{idPD}")
	public Product deleteProduct(@PathVariable int idPD) {
		Product product = productService.getProduct(idPD);
		if (product == null) {
			return null;
		}
		productService.deleteProduct(idPD);
		return product;

	}

	@PutMapping("/")
	public Product updateProduct(@RequestBody Product product) {
		productService.saveProduct(product);
		return product;
	}
}
