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
	public Product saveProduct(Product product) {
		
		return productRepository.save(product);
	}

	@Override
	public List<Product> getProduct() {
		
		return productRepository.findAll();
	}

	@Override
	public String deleteProduct(int idPD) {
		productRepository.deleteById(idPD);
		 return "Xóa thành công";
	}

	@Override
	public Product updateProduct(int idPD,Product product) {
		Product product1 = productRepository.findById(idPD).orElse(null);
		if (product1 == null) {
			return null;
		}
		product1.setNamePD(product.getNamePD());
		product1.setColorPD(product.getColorPD());
		product1.setDiscriptionPD(product.getDiscriptionPD());
		product1.setPricePD(product.getPricePD());
		product1.setProdecerPD(product.getProdecerPD());
		product1.setRamPD(product.getRamPD());
		product1.setRomPD(product.getRomPD());
		product1.setTypePD(product.getTypePD());
		return productRepository.save(product1);
	}

	

	@Override
	public Product getProduct(int idPD) {
		 Optional<Product> customer = productRepository.findById(idPD);
         return customer.get(); 
		
	}
	
	//TypePD
	@Override
	public List<Product> findBytypePD(String typeTamp) {
		return productRepository.findBytypePD(typeTamp);
	}
	//NamePD
	@Override
	public List<Product> findByNamePD(String nameTamp) {
		return productRepository.findByNamePD(nameTamp);
	}
	//RamPD
	@Override
	public List<Product> findByRamPD(int ramTamp) {
		return productRepository.findByRamPD(ramTamp);
	}

	@Override
	public List<Product> findPrice5() {
		return productRepository.findPrice5();
	}

	@Override
	public List<Product> findPrice5to10() {
		return productRepository.findPrice5to10();
	}

	@Override
	public List<Product> findPrice10to15() {
		return productRepository.findPrice10to15();
	}

	@Override
	public List<Product> findPrice15to20() {
		return productRepository.findPrice15to20();
	}

	@Override
	public List<Product> findPrice20() {
		return productRepository.findPrice20();
	}

	@Override
	public List<Product> findIphone() {
		return productRepository.findIphone();
	}

	@Override
	public List<Product> findSamSung() {
		return productRepository.findSamSung();
	}

	@Override
	public List<Product> findOPPO() {
		return productRepository.findOPPO();
	}

	@Override
	public List<Product> findNokia() {
		return productRepository.findNokia();
	}

	@Override
	public List<Product> findXiaomi() {
		return productRepository.findXiaomi();
	}

	@Override
	public List<Product> findRomPD(int romPD) {
		return productRepository.findRomPD(romPD);
	}

	@Override
	public List<Product> findColorPD(String colorPD) {
		return productRepository.findColorPD(colorPD);
	}

	
	


	   
}
