<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>마이페이지</title>
</head>
<body>
	<button> <a href='<c:url value="/member/show"/>'> 회원정보조회 </a></button> <br>
	<button> <a href='<c:url value="/mypage/reviewList"/>'> 내가 쓴 리뷰보기 </a></button> <br>
	<button> <a href='<c:url value="/mypage/qnaList"/>'> 내가 쓴 문의보기 </a></button> <br>
	<button> <a href='<c:url value="/mypage/orderList"/>'> 나의 주문 목록 </a></button> <br>
	<button><a href="<c:url value='/mypage/carts'/>">장바구니</a></button><br>
	<br><br>
	<button> <a href='<c:url value="/"/>'> HOME </a></button> <br>
	<button><a href='<c:url value="/member/logout"/>'> 로그아웃 </a></button> 
	
</body>
</html>