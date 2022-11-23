package com.example.Product.controller;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Product.entity.Product;
import com.example.Product.repository.ProductRepository;
import com.example.Product.service.ProductService;
import com.example.Product.service.ProductServiceImpl;

import io.github.resilience4j.ratelimiter.annotation.RateLimiter;

@RequestMapping("/Product")
@RestController
public class ProductController {
	@Autowired
	private ProductServiceImpl productServiceImpl;
	@PostMapping("/save")
	public Product addProduct(@RequestBody Product product) {
		return productServiceImpl.saveProduct(product);	 
	}

	@GetMapping("/")
	public List<Product> getProduct() {
		return productServiceImpl.getProduct();
	}

	@GetMapping("/{idPD}")
	@Cacheable(value = "Product", key = "#idPD")
	public Product getProduct(@PathVariable int idPD) {
		System.out.println("Lấy từ database");
		return productServiceImpl.getProduct(idPD);
	}

	@DeleteMapping("/{idPD}")
	@CacheEvict(value = "Product",allEntries = false,key = "#idPD")
	public String deleteProduct(@PathVariable int idPD) {
		return productServiceImpl.deleteProduct(idPD);
	}

	@PutMapping("/{idPD}")
	@CachePut(value = "Product",key = "#idPD")
	public Product updateProduct(@PathVariable int idPD,@RequestBody Product product) {
		return productServiceImpl.updateProduct(idPD, product);		
	}
	
	//typePD
	@GetMapping("/getPDbyType/{typePD}")
	@RateLimiter(name = "getProduct",fallbackMethod = "fall")
	public List<Product> getProductByType(@PathVariable String typePD) {
		return productServiceImpl.findBytypePD("%"+typePD+"%");
	}
	//namePD
	@GetMapping("/getPDbyName/{namePD}")
	@RateLimiter(name = "getProduct",fallbackMethod = "fall")
	public List<Product> getProductByName(@PathVariable String namePD) {
		return productServiceImpl.findByNamePD("%"+namePD+"%");
	}
	//ramPD
	@GetMapping("/getPDbyRam/{ramPD}")
	@RateLimiter(name = "getProduct",fallbackMethod = "fall")
	public List<Product> getProductByRam(@PathVariable int ramPD) {
		return productServiceImpl.findByRamPD(ramPD);
	}
	//ramPD
	@GetMapping("/getPDbyRom/{romPD}")
	@RateLimiter(name = "getProduct",fallbackMethod = "fall")
	public List<Product> findRomPD(@PathVariable int romPD) {
		return productServiceImpl.findRomPD(romPD);
		}
	//romPD
	@GetMapping("/getPDbyColor/{colorPD}")
	@RateLimiter(name = "getProduct",fallbackMethod = "fall")
	public List<Product> findColorPD(@PathVariable String colorPD) {
		return productServiceImpl.findColorPD(colorPD);
		}

	//price
	@GetMapping("/0-5tr")
	@RateLimiter(name = "getProduct",fallbackMethod = "fall")
	public List<Product> findPrice5() {
		return productServiceImpl.findPrice5();
	}
	@GetMapping("/5tr-10tr")
	@RateLimiter(name = "getProduct",fallbackMethod = "fall")
	public List<Product> findPrice5to10() {
		return productServiceImpl.findPrice5to10();
	}
	@GetMapping("/10tr-15tr")
	@RateLimiter(name = "getProduct",fallbackMethod = "fall")
	public List<Product> findPrice10to15() {
		return productServiceImpl.findPrice10to15();
	}
	@GetMapping("/15tr-20tr")
	@RateLimiter(name = "getProduct",fallbackMethod = "fall")
	public List<Product> findPrice15to20() {
		return productServiceImpl.findPrice15to20();
	}
	@GetMapping("/20tr-max")
	@RateLimiter(name = "getProduct",fallbackMethod = "fall")
	public List<Product> findPrice20() {
		return productServiceImpl.findPrice20();
	}
	@GetMapping("/iphone")
	@RateLimiter(name = "getProduct",fallbackMethod = "fall")
	public List<Product> findIphone() {
		return productServiceImpl.findIphone();
	}
	@GetMapping("/oppo")
	@RateLimiter(name = "getProduct",fallbackMethod = "fall")
	public List<Product> findOPPO() {
		return productServiceImpl.findOPPO();
	}
	
	@GetMapping("/nokia")
	@RateLimiter(name = "getProduct",fallbackMethod = "fall")
	public List<Product> findNokia() {
		return productServiceImpl.findNokia();
	}
	@GetMapping("/xiaomi")
	@RateLimiter(name = "getProduct",fallbackMethod = "fall")
	public List<Product> findXiaomi() {
		return productServiceImpl.findXiaomi();
	}
	@GetMapping("/samsung")
	@RateLimiter(name = "getProduct",fallbackMethod = "fall")
	public List<Product> findSamSung() {
		return productServiceImpl.findSamSung();
	}
	public List<Product> fall(Exception e) {
		for (int i = 0; i < 5; i++) {
			System.out.println("Quá nhiều request");
		}
		return null;
	}
}
