<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- 포맷팅 관련 태그라이브러리(JSTL/fmt) --%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>나의 주문목록</title>
</head>
	<style>
	#container_box table td { width:100px; }
	</style>

	<table class="table table-bordered table-hover">
		<thead>
			<tr>
				<td>주문번호</td>
				<td>주문일자</td>
				<td>상품명</td>
				<td>옵션</td>
				<td>수량</td>
				<td>금액</td>
				<td>주문처리상태</td>
				<td>취소/교환/환불</td>
			</tr>
		</thead>
				
		<c:if test="${order.size() <= 0}">
			<tr>
				<td colspan="5" align="center">
					<strong>주문 내역이 없습니다!!</strong>
				</td>
			</tr>
		</c:if>

		<!-- 게시물이 들어갈 공간 -->
		
		<c:if test="${order.size() > 0}">
		
		<tbody>
		<c:forEach var="b" items="${order}" >
			<tr>
				<td>${b.orderId}</td>
				<td>${b.orderRegDate}</td>
				<td>
					<a href="<c:url value='#'/>"> ${b.gdsName}</a>
				</td>
				<td>${b.optionName}</td>
				<td>${b.orderStock}</td>	
				<td>${b.orderPrice}</td>			
				<td>
					<c:if test="${b.deliveryStatus == 1}">
					입금대기
					</c:if>				
					<c:if test="${b.deliveryStatus == 2}">
					상품준비중
					</c:if>				
					<c:if test="${b.deliveryStatus == 3}">
					배송준비중
					</c:if>				
					<c:if test="${b.deliveryStatus == 4}">
					배송중
					</c:if>				
					<c:if test="${b.deliveryStatus == 5}">
					배송완료
					</c:if>				
				</td>
				<td>
					<form id="formObj" role="form" action="<c:url value='/mypage/orderStatus'/>" method="post">
						<input type="hidden" name="orderDetailNo" value="${b.orderDetailNo}">
						<c:if test="${b.deliveryStatus == 1 || b.deliveryStatus == 2 || b.deliveryStatus == 3}">
							<input type="number" name="orderStatus" value=1>
							<input class="cancelBtn" type="submit" value="취소">&nbsp;
						</c:if>
						<c:if test="${b.deliveryStatus == 4 || b.deliveryStatus == 5}">
							<button id="exchBtn" type="button">교환</button>&nbsp;
							<button id="refundBtn" type="button">환불</button>&nbsp;					
						</c:if>
					</form>
				</td>
			</tr>

		</c:forEach>
		</tbody>
		</c:if>
	</table>



<script type="text/javascript" src="https://code.jquery.com/jquery-3.1.1.min.js" > </script>
<script>

//제이쿼리의 시작
$(function() {
	
	
	//변수는 let, 상수는 const로 선언(ES2015 문법)
	const formElement = $("#formObj");
	
	//교환버튼 클릭이벤트 처리
	//var modifyBtn = document.getElementById("modBtn"); //vanila js
	var exchBtn = $("#exchBtn"); //jQuery
	
	exchBtn.click(function() {
		console.log("교환 버튼이 클릭됨!");
		formElement.attr("action", "/shopping/mypage/orderStatus");
		formElement.attr("method", "post");
		formElement.submit(2);
	});
	
	//환불버튼 클릭이벤트 처리
	//var modifyBtn = document.getElementById("modBtn"); //vanila js
	var refundBtn = $("#refundBtn"); //jQuery
	
	refundBtn.click(function() {
		console.log("환불 버튼이 클릭됨!");
		formElement.attr("action", "/shopping/mypage/orderStatus");
		formElement.attr("method", "post");
		formElement.submit(3);
	});
	
});//제이쿼리의 끝

</script>
</html>