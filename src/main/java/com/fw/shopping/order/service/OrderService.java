package com.fw.shopping.order.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.fw.shopping.order.model.OrderDetailVO;
import com.fw.shopping.order.model.OrderVO;

@Service
public class OrderService implements IOrderService {

	@Override
	public void addOdrDetail(OrderDetailVO od) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addOrder(OrderVO order) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<OrderVO> getOrderList(int userNo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OrderDetailVO> getOdrDetailList(String orderId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int modifyGdsCount(OrderDetailVO od) {
		// TODO Auto-generated method stub
		return 0;
	}

}
