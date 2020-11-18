package com.fw.shopping.order.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fw.shopping.order.model.OrderDetailVO;
import com.fw.shopping.order.model.OrderJoinVO;
import com.fw.shopping.order.model.OrderVO;
import com.fw.shopping.order.repository.IOrderMapper;

@Service
public class OrderService implements IOrderService {
	
	@Autowired
	private IOrderMapper mapper;

	@Override
	public void addOrder(OrderVO order) {
		mapper.addOrder(order);
		
	}
	
	@Override
	public void addOdrDetail(OrderDetailVO ordDetail) {
		mapper.addOdrDetail(ordDetail);
		
	}

	@Override
	public List<OrderJoinVO> getOrderList(String orderId) {
		List<OrderJoinVO> List = mapper.getOrderList(orderId);
		return List;
	}

	@Override
	public List<OrderJoinVO> getMyOrderList(Integer userNo) {
		List<OrderJoinVO> List = mapper.getMyOrderList(userNo);
		return List;
	}

	@Override
	public int modifyGdsCount(OrderJoinVO od) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int enrollInvoiceNo(String orderDetailNo, Long invoiceNo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deliveryComplete() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<OrderJoinVO> getOrderInfo(String orderId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void orderStatus(OrderJoinVO order) {
		mapper.orderStatus(order);
		
	}

	@Override
	public List<OrderJoinVO> getOdDetailNoList(Integer orderDetailNo) {
		List<OrderJoinVO> List = mapper.getOdDetailNoList(orderDetailNo);
		return List;
	}



}
