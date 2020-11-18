package com.fw.shopping.order.service;

import java.util.List;

import com.fw.shopping.order.model.OrderDetailVO;
import com.fw.shopping.order.model.OrderJoinVO;
import com.fw.shopping.order.model.OrderVO;

public interface IOrderService {


	//주문정보 추가
	void addOrder(OrderVO order);
	
	//주문상세정보 생성
	void addOdrDetail(OrderDetailVO ordDetail);

	//주문번호로 주문정보 가져오기
	List<OrderJoinVO> getOrderList(String orderId);
	
	//userNo으로 주문정보 가져오기
	List<OrderJoinVO> getMyOrderList(Integer userNo);
	
	//주문 정보 내 상세주문 정보 조회
	List<OrderJoinVO> getOrderInfo(String orderId);

	//주문 상세 번호 별 정보 조회
	List<OrderJoinVO> getOdDetailNoList(Integer orderDetailNo);
	
	//주문이 완료되면, 상품의 수량을 변경해 
	int modifyGdsCount(OrderJoinVO od);
	
	//송장번호 등록
	int enrollInvoiceNo(String orderDetailNo, Long invoiceNo);
	
	//배송완료
	int deliveryComplete();
		
	
	//취소/교환/환불처리
	void orderStatus(OrderJoinVO order); //거부:0, 교환허가:12, 환불허가:13
}
	