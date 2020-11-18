<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>주문정보입력</title>
</head>
<body>

<!-- 이제 여기서 날라가면  결제 api로 가는 건가요? -->
<h1>주문자 정보 입력</h1>

<form action="<c:url value='/order/orders'/>" method="post"> <!-- 주소는 결제 api를 이식하는 사람이 옮기기 쉽도록 
														컨트롤러를 많이 쓰지 않기 위해 이 경로로 했지만 바꾸는 게 좋을 듯 -->
	<input type="hidden" name="userNo" value="${order.userNo}">
	
	주문자: <input type="text" name="orderPerson" value="${order.orderPerson}" /> <br>
	배송지1: <input type="text" name="orderAddr1" value="${order.orderAddr1}"/> <br>
	배송지2: <input type="text" name="orderAddr2" value="${order.orderAddr2}"/> <br>
	전화번호: <input type="text" name="orderPhone" value="${order.orderPhone}"/> <br>
	총 금액: <input type="number" name="orderPrice" value="${order.orderPrice}" readonly/>

	<input type="submit" value="결제하기">

</form>



</body>
</html>