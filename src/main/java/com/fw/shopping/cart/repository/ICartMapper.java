package com.fw.shopping.cart.repository;

import java.util.List;

import com.fw.shopping.cart.model.CartVO;
import com.fw.shopping.member.model.MemberVO;

public interface ICartMapper {

	void addCart(CartVO cart);
	
	void deleteCart(int cartNo);
	
	List<CartVO> getCartList(MemberVO member);
	
}
