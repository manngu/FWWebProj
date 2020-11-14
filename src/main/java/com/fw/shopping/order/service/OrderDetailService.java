package com.fw.shopping.order.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.fw.shopping.admin.model.SearchVO;
import com.fw.shopping.order.model.OrderDetailVO;
import com.fw.shopping.order.model.OrderJoinVO;
import com.fw.shopping.order.model.OrderVO;
import com.fw.shopping.order.repository.IOrderDetailMapper;

@Service
public class OrderDetailService implements IOrderDetailService {
	
	@Inject
	private IOrderDetailMapper mapper;

	@Override
	public void addOdrDetail(OrderDetailVO od) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addOrder(OrderVO order) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<OrderVO> getOrderList(int userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OrderDetailVO> getOdrDetailList(String orderId) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public List<OrderJoinVO> getUODList(Integer userNo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int modifyGdsCount(OrderDetailVO od) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int enrollInvoiceNo(String orderId, String gdsName, String Invoice) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deliveryComplete() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<OrderVO> getOrderList(SearchVO search) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OrderVO getOrderInfo(String orderId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void orderStatus(OrderDetailVO order) {
		mapper.orderStatus(order);
		
	}





}
