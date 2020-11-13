package com.fw.shopping.order.repository;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.fw.shopping.commons.SearchVO;
import com.fw.shopping.order.model.OrderDetailVO;
import com.fw.shopping.order.model.OrderVO;

public interface IOrderMapper {
	
	//admin주문리스트
	List<OrderDetailVO> getAdminOdrList(SearchVO search);

	
	//주문 개수
	int countOrders(SearchVO search);
	
	//취소/교환/환불 승인
	void admitProb(int orderDetailNo);
	
	//취소/교환/환불 거부
	void rejectProb(int orderDetailNo);
	
	//송장번호 등록
	void enrollInvoice(@Param("orderDetailNo") int orderDetailNo, @Param("invoiceNo")int invoiceNo);
	
	//배송완료 등록
	void deliverComplete(int orderDetailNo);
	
	
	
	

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
