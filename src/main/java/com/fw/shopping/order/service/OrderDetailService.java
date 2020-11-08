package com.fw.shopping.order.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.fw.shopping.admin.model.SearchVO;
import com.fw.shopping.order.model.OrderDetailVO;
import com.fw.shopping.order.model.OrderVO;

@Service
public class OrderDetailService implements IOrderDetailService {

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
	public int checkRequest(OrderDetailVO od, int check) {
		// TODO Auto-generated method stub
		return 0;
	}

}
