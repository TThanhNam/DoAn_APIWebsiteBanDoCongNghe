package com.example.detailCartService.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.detailCartService.VO.Cart;
import com.example.detailCartService.VO.CartDetail_Cart;
import com.example.detailCartService.VO.CartDetail_Cart_Product;
import com.example.detailCartService.VO.Product;
import com.example.detailCartService.entity.CartDetail;
import com.example.detailCartService.repository.CartDetailRepository;

@Service
public class CartDetailServiceImpl implements CartDetailService {
	@Autowired
	private CartDetailRepository cartDetailRepository;
	
	@Autowired
	private RestTemplate restTemplate;

	@Override
	public CartDetail getOneCartDetail(int cartDetailID) {
		return cartDetailRepository.findById(cartDetailID).get();
	}

	@Override
	public List<CartDetail> getCartDetails() {
		return cartDetailRepository.findAll();
	}

	@Override
	public CartDetail saveCartDetail(CartDetail cartDetail) {
		return cartDetailRepository.save(cartDetail);
	}
	
	public CartDetail_Cart getCartDetail_Cart(int id) {
		CartDetail cartDetail = cartDetailRepository.findById(id).get();
		Cart cart = restTemplate.getForObject("http://localhost:8001/Cart/"+cartDetail.getCartID(),Cart.class);
		CartDetail_Cart co = new CartDetail_Cart(cartDetail, cart);
		return co;
	}

	@Override
	public String deleteCartDetail(int cartDetailID) {
		cartDetailRepository.deleteById(cartDetailID);
		return "Xoa thanh cong";
	}

	@Override
	public CartDetail update(CartDetail cartDetail) {
		return cartDetailRepository.saveAndFlush(cartDetail);
	}

	
	public CartDetail_Cart_Product getCartDetail_Cart_Product(int id) {
		CartDetail cartDetail = cartDetailRepository.findById(id).get();	
		Cart cart = restTemplate.getForObject("http://localhost:8001/Cart/"+cartDetail.getCartID(),Cart.class);
		Product product = restTemplate.getForObject("http://localhost:8003/Product/"+cartDetail.getProductID(),Product.class);
		CartDetail_Cart_Product co = new CartDetail_Cart_Product(cartDetail, cart, product);
		return co;
	}
}
