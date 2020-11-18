package com.fw.shopping.cart.repository;

import java.util.List;

import com.fw.shopping.cart.model.CartJoinVO;
import com.fw.shopping.cart.model.CartVO;

public interface ICartMapper {
	
	List<CartJoinVO> getCartList(int userNo);
	
	void deleteCart(int cartNo);

	void addCart(CartVO cart);
	
}
