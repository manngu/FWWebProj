package com.fw.shopping.order.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.fw.shopping.commons.SearchVO;
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
	
	//////관리자//////
	@Override
	public List<OrderDetailVO> getAdminOdrList(SearchVO search) {
		return mapper.getAdminOdrList(search);
	}
	

	@Override
	public int countOrders(SearchVO search) {
		return mapper.countOrders(search);
	}

	@Override
	public void admitProb(int orderDetailNo) {
		mapper.admitProb(orderDetailNo);

	}
	
	@Override
	public void rejectProb(int orderDetailNo) {
		mapper.rejectProb(orderDetailNo);
	}

	@Override
	public void enrollInvoice(int orderDetailNo, int invoiceNo) {
		mapper.enrollInvoice(orderDetailNo, invoiceNo);
		
	}
	
	@Override
	public void deliverComplete(int orderDetailNo) {
		mapper.deliverComplete(orderDetailNo);
		
	}
	//////////////////////





}
