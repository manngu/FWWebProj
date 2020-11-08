package com.fw.shopping.order.service;

import java.util.List;

import com.fw.shopping.order.model.OrderDetailVO;
import com.fw.shopping.order.model.OrderVO;

public interface IOrderService {

	//결제 api로 넘기기 위한 객체 생성
	void addOdrDetail(OrderDetailVO od);

	void addOrder(OrderVO order);

	//주문정보 확인하기
	//OrderVO에 주문자pk가 있어야 자기 주문 내역을 확인 가능
	List<OrderVO> getOrderList(int userNo);

	List<OrderDetailVO> getOdrDetailList(String orderId);

	//주문이 완료되면, 상품의 수량을 변경해 
	int modifyGdsCount(OrderDetailVO od);
}
