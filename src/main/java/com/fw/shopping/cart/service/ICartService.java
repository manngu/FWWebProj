package com.fw.shopping.cart.service;

import java.util.List;

import com.fw.shopping.cart.model.CartJoinVO;
import com.fw.shopping.cart.model.CartVO;

public interface ICartService {

	
	List<CartJoinVO> getCartList(int userNo);
	
	void deleteCart(int cartNo);
	
	void addCart(CartVO cart);

}
