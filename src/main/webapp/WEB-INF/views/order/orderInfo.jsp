<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- 포맷팅 관련 태그라이브러리(JSTL/fmt) --%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>주문정보</title>
</head>
<body>
	    <input type="hidden" name="cartNo" value="23">
	    <input type="hidden" name="userNo" value="9">

장바구니
<section id="content">
 
 <ul>
  <c:forEach items="${cartList}" var="cartList">
   </div>
   <div class="gdsInfo">
    <p>
     <span>상품번호 : </span>${cartList.gdsNo}<br />
     <span>옵션번호 : </span>${cartList.optionNo}<br />
     <span>구매수량 : </span>${cartList.cartStock}<br />
    </p>    
   </div>
   
  </c:forEach>
 </ul>
</section>
<br>

<form role="form" action="<c:url value='/order/myorder/${user.userNo }'/>" method="post">  
      <input type="submit" value="전송" >
</form>
</body>
</html>