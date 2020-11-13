package com.fw.shopping.order.service;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import com.fw.shopping.commons.SearchVO;
import com.fw.shopping.order.model.OrderDetailVO;
import com.fw.shopping.order.model.OrderVO;
import com.fw.shopping.order.repository.IOrderMapper;

@Service
public class OrderService implements IOrderService {

	@Inject
	IOrderMapper mapper;

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
