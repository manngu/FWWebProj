package com.fw.shopping.cart.service;

import java.util.List;

import com.fw.shopping.cart.model.CartVO;
import com.fw.shopping.member.model.MemberVO;

public interface ICartService {

	void addCart(CartVO cart);
	
	void deleteCart(int cartNo);
	
	List<CartVO> getCartList(MemberVO member);
}
