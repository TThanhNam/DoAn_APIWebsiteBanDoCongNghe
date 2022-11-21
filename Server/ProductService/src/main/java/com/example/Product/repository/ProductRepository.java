package com.example.Product.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.Product.entity.Product;
public interface ProductRepository extends JpaRepository<Product, Integer>{
	//romPD
	@Query(value = "select * from public.product where romPD = ?", nativeQuery = true)
	public List<Product> findRomPD(int romPD);
	//colorPD
	@Query(value = "select * from public.product where colorPD ILIKE ?", nativeQuery = true)
	public List<Product> findColorPD(String colorPD);
	//pricePD
	@Query(value = " select * from product where pricePD < 5000001", nativeQuery = true)
	public List<Product> findPrice5();
	@Query(value = " select * from product where pricePD < 10000001 and pricePD >4999999", nativeQuery = true)
	public List<Product> findPrice5to10();
	@Query(value = " select * from product where pricePD < 15000001 and pricePD >9999999", nativeQuery = true)
	public List<Product> findPrice10to15();
	@Query(value = " select * from product where pricePD < 20000001 and pricePD >14999999", nativeQuery = true)
	public List<Product> findPrice15to20();
	@Query(value = " select * from product where pricePD >19999999", nativeQuery = true)
	public List<Product> findPrice20();
	//prodecerPD
	@Query(value = " select * from product where prodecerPD = 'iPhone'", nativeQuery = true)
	public List<Product> findIphone();
	@Query(value = " select * from product where prodecerPD = 'SamSung'", nativeQuery = true)
	public List<Product> findSamSung();
	@Query(value = " select * from product where prodecerPD = 'OPPO'", nativeQuery = true)
	public List<Product> findOPPO();
	@Query(value = " select * from product where prodecerPD = 'Nokia'", nativeQuery = true)
	public List<Product> findNokia();
	@Query(value = " select * from product where prodecerPD = 'Xiaomi'", nativeQuery = true)
	public List<Product> findXiaomi();

	//typePD
	@Query(value = "SELECT * FROM public.product WHERE typepd ILIKE ?", nativeQuery = true)
	public List<Product> findBytypePD(String typePD);
	//namePD
	@Query(value = "SELECT * FROM public.product WHERE namepd ILIKE ?", nativeQuery = true)
	public List<Product> findByNamePD(String namePD);
	//ramPD
	@Query(value = "SELECT * FROM public.product WHERE rampd = ?", nativeQuery = true)
	public List<Product> findByRamPD(int ramPD);
}
