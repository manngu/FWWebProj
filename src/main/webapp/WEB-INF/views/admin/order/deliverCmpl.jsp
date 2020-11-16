<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>배송 완료 입력 페이지</title>
</head>
<body>

<h1>배송 완료 입력 페이지</h1>

<a href="<c:url value='/admin/orders'/>">주문관리 메인 페이지로</a> <br>

<table border="1">
<tr>
<td>주문상세번호</td> <td>송장번호</td> <td>배송상태</td> <td>배송완료</td>
</tr>

<c:forEach var="od" items="${list}">

<tr>
<td>${od.orderDetailNo} </td> <td>${od.invoiceNo}</td>
<td>${od.deliveryStatus}</td>
<td> <a href="<c:url value='/admin/orders/deliveries/${od.orderDetailNo}'/>"><button>확인</button></a></td>
</tr>

</c:forEach>
</table>


</body>
</html>