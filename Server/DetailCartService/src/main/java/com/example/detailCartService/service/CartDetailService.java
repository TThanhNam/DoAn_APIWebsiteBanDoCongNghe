package com.example.detailCartService.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.detailCartService.entity.CartDetail;
import com.example.detailCartService.entity.Product;
import com.example.detailCartService.entity.ProductOfCartDetail;
import com.example.detailCartService.repository.CartDetailRepository;

@Service
public class CartDetailService {
	
	@Autowired
	private CartDetailRepository cartDetailRepository;
	
	@Autowired
	private RestTemplate restTemplate;
	
	public List<CartDetail> findAll() {
		return cartDetailRepository.findAll();
	}

	public List<ProductOfCartDetail> findAllCartDetalAndProduct() {
		List<ProductOfCartDetail> lsProductOfCartDetails = new ArrayList<>();
		List<CartDetail> lsCartDetails = cartDetailRepository.findAll();
		for (CartDetail cartDetail : lsCartDetails) {
			Product product = restTemplate.getForObject("http://localhost:9004/Product/" + cartDetail.getProductID(), Product.class);
			lsProductOfCartDetails.add(new ProductOfCartDetail(cartDetail, product));
		}
		return lsProductOfCartDetails;
	}
	
	public ProductOfCartDetail findById(int id) {
		 CartDetail cartDetail = cartDetailRepository.findById(id).get();
		 Product product = restTemplate.getForObject("http://localhost:9004/Product/" + cartDetail.getProductID(), Product.class);
		 return new ProductOfCartDetail(cartDetail, product);
	}
	
	
	public CartDetail saveAndFlush(CartDetail cartDetail) {
		return cartDetailRepository.saveAndFlush(cartDetail);
	}


	public void deleteById(Integer id) {
		cartDetailRepository.deleteById(id);
	}
	
	public List<ProductOfCartDetail> getCartDetalAndProductByCartId(int id) {
		List<CartDetail> lsCartDetails = cartDetailRepository.getCartDetalAndProductByCartId(id);
		List<ProductOfCartDetail> lsProductOfCartDetails = new ArrayList<>();
		for (CartDetail i : lsCartDetails) {
			 Product product = restTemplate.getForObject("http://localhost:9004/Product/" + i.getProductID(), Product.class);
			 lsProductOfCartDetails.add(new ProductOfCartDetail(i, product));
		}
		return lsProductOfCartDetails;
	}
	
	public CartDetail update(int id,CartDetail cartDetail) {
		CartDetail caDetail1 = cartDetailRepository.findById(id).orElse(null);
		if(caDetail1 == null) {
			return null;
		}
		caDetail1.setCartID(cartDetail.getCartID());
		caDetail1.setProductID(cartDetail.getProductID());
		caDetail1.setQuantity(cartDetail.getQuantity());
		return cartDetailRepository.save(caDetail1);
	}
}
