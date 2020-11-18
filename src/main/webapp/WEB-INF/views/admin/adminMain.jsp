<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자 페이지</title>
</head>
<body>

<h1>관리자 페이지</h1> <BR>

	<a href="<c:url value='/'/>">메인페이지로</a> <br> <br>
	<a href="<c:url value='/admin/categories'/>">1. 카테고리 관리</a> <br>
	<a href="<c:url value='/admin/goods'/>">2. 상품관리</a> <br>
	<a href="<c:url value='/admin/orders'/>">3. 주문관리</a> <br>
	<a href="<c:url value='/admin/reviews'/>">4. 리뷰관리</a> <br>
	<a href="<c:url value='/admin/qnas'/>">5. qna관리</a> <br>
	
	
	
		<!-- faq/notice 등록,-->
	
	<a href="<c:url value=''/>">6. faq등록</a> <br>
	<a href="<c:url value=''/>">7. notice등록</a> <br>
	
	

	

</body>
</html>