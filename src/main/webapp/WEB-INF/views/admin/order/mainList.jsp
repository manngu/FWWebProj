<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>주문관리 페이지</title>
</head>
<body>

<h1>주문관리 페이지</h1>

<a href="<c:url value='/admin'/>">관리자메인 페이지로</a> <br>
<a href="<c:url value='/admin/orders/problems'/>">1. 취소/교환/환불처리</a> <br>
<a href="<c:url value='/admin/orders/invoice'/>">2. 송장번호 등록</a> <br>
<a href="<c:url value='/admin/orders/deliveries'/>">3. 배송완료 등록</a> <br>

<table border="1" style="border-collapse:collapse;">
<tr>
<td>주문번호</td> <td>주문상세번호</td> <td>상품번호</td> <td>옵션번호</td> <td>주문수량</td> <td>주문상태</td> <td>송장번호</td> <td>배송상태</td> </tr> 

<c:forEach var="od" items="${list}">

<tr>
<td>${od.orderId}</td>
<td>${od.orderDetailNo}</td>
<td>${od.gdsNo}</td>
<td>${od.optionNo}</td>
<td>${od.orderStock}</td>
<td>${od.orderStatus}</td>
<td>${od.invoiceNo}</td>
<td>${od.deliveryStatus}</td>
</tr>

</c:forEach>
</table>

			<!-- 페이징 처리 부분  -->

					<!-- 이전버튼 -->
					<c:if test="${pc.prev}">
						<a href="<c:url value='/admin/orders${pc.makeURI(pc.beginPage-1)}'/>">이전</a> 
					</c:if>


					<!-- 페이지 버튼 -->
					<c:forEach var="pageNum" begin="${pc.beginPage}" end="${pc.endPage}">
						<a href="<c:url value='/admin/orders${pc.makeURI(pageNum)}'/>"
							style="${(pc.paging.page == pageNum) ? 'font-weight:bold' : '' }">${pageNum}</a>
					</c:forEach>

					<!-- 다음 버튼 -->
					<c:if test="${pc.next}">
						<a href="<c:url value='/admin/orders${pc.makeURI(pc.endPage+1)}'/>">다음</a>
					</c:if>

			<!-- 페이징 처리 끝 -->





</body>
</html>