package com.fw.shopping.cart.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.fw.shopping.cart.model.CartJoinVO;
import com.fw.shopping.cart.model.CartVO;
import com.fw.shopping.cart.repository.ICartMapper;

@Service
public class CartService implements ICartService {
	
	@Inject
	ICartMapper mapper;
	
	@Override
	public List<CartJoinVO> getCartList(int userNo) {
		return mapper.getCartList(userNo);
	}
	
	@Override
	public void deleteCart(int cartNo) {
		mapper.deleteCart(cartNo);
		
	}
	
	
	
	
	

	@Override
	public void addCart(CartVO cart) {
		// TODO Auto-generated method stub
		
	}




}
