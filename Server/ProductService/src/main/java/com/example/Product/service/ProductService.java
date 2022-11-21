package com.example.Product.service;

import java.util.List;

import com.example.Product.entity.Product;

public interface ProductService {
	public Product saveProduct(Product product);
	public List<Product> getProduct();
	public String deleteProduct(int idPD);
	public Product updateProduct(int idPD, Product product);
	public Product getProduct(int idPD);
	public List<Product> findRomPD(int romPD);
	public List<Product> findColorPD(String colorPD);
	public List<Product> findPrice5();
	public List<Product> findPrice5to10();
	public List<Product> findPrice10to15();
	public List<Product> findPrice15to20();
	public List<Product> findPrice20();
	public List<Product> findIphone();
	public List<Product> findSamSung();
	public List<Product> findOPPO();
	public List<Product> findNokia();
	public List<Product> findXiaomi();	
	public List<Product> findBytypePD(String typeTamp);
	public List<Product> findByNamePD(String nameTamp);
	public List<Product> findByRamPD(int ramTamp);
	

}
