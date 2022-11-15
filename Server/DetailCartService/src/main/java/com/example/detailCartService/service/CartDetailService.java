package com.example.detailCartService.service;

import java.util.List;

import com.example.detailCartService.VO.CartDetail_Cart;
import com.example.detailCartService.VO.CartDetail_Cart_Product;
import com.example.detailCartService.entity.CartDetail;

public interface CartDetailService {
	public CartDetail getOneCartDetail(int cartDetailID);
	public List<CartDetail> getCartDetails();
	public CartDetail saveCartDetail(CartDetail cartDetail);
	public CartDetail_Cart getCartDetail_Cart(int id);
	public String deleteCartDetail(int cartDetailID);
	public CartDetail update(CartDetail cartDetail);
	public CartDetail_Cart_Product getCartDetail_Cart_Product(int id);
}
