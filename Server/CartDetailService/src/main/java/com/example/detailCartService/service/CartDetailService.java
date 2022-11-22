package com.example.detailCartService.service;

import java.net.ConnectException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.detailCartService.entity.CartDetail;
import com.example.detailCartService.model.Product;
import com.example.detailCartService.model.ProductOfCartDetail;
import com.example.detailCartService.repository.CartDetailRepository;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;

@Service
public class CartDetailService {
	
	private final String CARTDETAIL_RETRY = "CartDetail_Retry";
	private final String CARTDETAIL_CB = "CartDetail_CB";
	private final String CARTDETAIL_RATELM = "CartDetail_RateLM";
	
	@Autowired
	private CartDetailRepository cartDetailRepository;
	
	@Autowired
	private RestTemplate restTemplate;
	
	public List<CartDetail> findAll() {
		return cartDetailRepository.findAll();
	}
	
	
//	@CircuitBreaker(name = CARTDETAIL_CB)
//	@RateLimiter(name = CARTDETAIL_RATELM)
	@Retry(name = CARTDETAIL_RETRY, fallbackMethod = "fallback")
	public List<ProductOfCartDetail> findAllCartDetalAndProduct() {
		System.out.println("Đang kết nối tới sevice...");
		List<ProductOfCartDetail> lsProductOfCartDetails = new ArrayList<>();
		List<CartDetail> lsCartDetails = cartDetailRepository.findAll();
		for (CartDetail cartDetail : lsCartDetails) {
			Product product = restTemplate.getForObject("http://localhost:9004/Product/" + cartDetail.getProductID(), Product.class);
			lsProductOfCartDetails.add(new ProductOfCartDetail(cartDetail, product));
		}
		return lsProductOfCartDetails;
	}
//	@CircuitBreaker(name = CARTDETAIL_CB)
//	@RateLimiter(name = CARTDETAIL_RATELM)
	@Retry(name = CARTDETAIL_RETRY)
	public ProductOfCartDetail findById(int id) {
		System.out.println("Đang kết nối tới sevice...");
		CartDetail cartDetail = cartDetailRepository.findById(id).get();
		Product product = restTemplate.getForObject("http://localhost:9004/Product/" + cartDetail.getProductID(), Product.class);
		return new ProductOfCartDetail(cartDetail, product);
	}
//	@CircuitBreaker(name = CARTDETAIL_CB)
//	@RateLimiter(name = CARTDETAIL_RATELM)
	@Retry(name = CARTDETAIL_RETRY, fallbackMethod = "fallback")
	public List<ProductOfCartDetail> getCartDetalAndProductByCartId(int id) {
		System.out.println("Đang kết nối tới sevice...");
		List<CartDetail> lsCartDetails = cartDetailRepository.getCartDetalAndProductByCartId(id);
		List<ProductOfCartDetail> lsProductOfCartDetails = new ArrayList<>();
		for (CartDetail i : lsCartDetails) {
			 Product product = restTemplate.getForObject("http://localhost:9004/Product/" + i.getProductID(), Product.class);
			 lsProductOfCartDetails.add(new ProductOfCartDetail(i, product));
		}
		return lsProductOfCartDetails;
	}
	
	public List<ProductOfCartDetail> fallback(Exception e) {
		System.out.println("Không thể kết nối tới service");
		return new ArrayList<ProductOfCartDetail>();
	}
	
	public CartDetail saveAndFlush(CartDetail cartDetail) {
		double totalMoney = 0;
		List<CartDetail> lsCartDetails = cartDetailRepository.getCartDetalAndProductByCartId(cartDetail.getCartID());
		lsCartDetails.add(cartDetail);
		for (CartDetail i : lsCartDetails) {
			 Product product = restTemplate.getForObject("http://localhost:9004/Product/" + i.getProductID(), Product.class);
			 totalMoney += product.getPricePD() * i.getQuantity();
		}
		restTemplate.put("http://localhost:9001/Cart/updateTotalMoney/" + cartDetail.getCartID() + "/" + totalMoney,String.class);
		return cartDetailRepository.saveAndFlush(cartDetail);
	}

	public void deleteById(Integer id) {
		cartDetailRepository.deleteById(id);
	}

	public void deleteAll() {
		cartDetailRepository.deleteAll();
	}
}
