<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>review 페이지</title>
</head>

<body>
    <h1>REVIEW</h1>
    <h3>구매하신 상품</h3>
    
    <img src="http://placehold.it/100x100" /> <br>
		
	   상품명: 데일리어쩌구 <br>
	    구매옵션: 블랙 / S <br>
		    
    <form action="<c:url value='/review/insert'/>" method="get">
	    
	    <!-- 임의로 추가함 -->
	    <input type="hidden" name="gdsNo" value="1023">
	    <input type="hidden" name="userNo" value="${user.userNo}">
	    <input type="hidden" name="userName" value="${user.userName}">
	    <input type="hidden" name="orderId" value="2027">
	    
	    <h3>만족도 </h3> 
	    
	    <select name="reviewStars">
	    	<option value="5">★★★★★
	    	<option value="4">★★★★☆
	    	<option value="3">★★★☆☆
	    	<option value="2">★★☆☆☆
	    	<option value="1">★☆☆☆☆
    	</select>

	    <h3>리뷰작성란 </h3>
	    <textarea name="reviewContent" rows="4" cols="50" ></textarea> <br>
	    <h3>이미지추가 </h3>
	    <input type="file" name="reviewImg">
	    <input type="submit" value="리뷰 올리기">
	    
    </form>
</body>
</html>