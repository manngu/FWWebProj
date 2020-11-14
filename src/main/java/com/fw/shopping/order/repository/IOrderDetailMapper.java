package com.fw.shopping.order.repository;

import java.util.List;

import com.fw.shopping.admin.model.SearchVO;
import com.fw.shopping.order.model.OrderDetailVO;
import com.fw.shopping.order.model.OrderJoinVO;
import com.fw.shopping.order.model.OrderVO;

public interface IOrderDetailMapper {

	//결제 api로 넘기기 위한 객체 생성
	void addOdrDetail(OrderDetailVO od);

	void addOrder(OrderVO order);

	//주문정보 확인하기
	//OrderVO에 주문자pk가 있어야 자기 주문 내역을 확인 가능
	List<OrderVO> getOrderList(int userId);

	List<OrderDetailVO> getOdrDetailList(String orderId);

	List<OrderJoinVO> getUODList(Integer userNo);

	//주문이 완료되면, 상품의 수량을 변경해 
	int modifyGdsCount(OrderDetailVO od);
	
	//송장번호 등록
	int enrollInvoiceNo(String orderId, String gdsName, String Invoice);
	
	//배송완료
	int deliveryComplete();
	
	//주문 리스트 조회
	List<OrderVO> getOrderList(SearchVO search);
	
	//주문 정보 조회
	OrderVO getOrderInfo(String orderId);
	
	//취소/교환/환불처리
	void orderStatus(OrderDetailVO order); //거부:0, 교환허가:12, 환불허가:13
}
