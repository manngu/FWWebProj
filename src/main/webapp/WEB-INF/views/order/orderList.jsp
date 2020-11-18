<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<html>
<head>
	<title>주문확인서</title>
</head>
<body>
<div id="root">
	<section id="container">
		<div id="container_box">
		
			<section id="content">
				
				<ul class="orderList">
					<c:forEach items="${orderList}" var="orderList">
					<li>
					<div>
						<p><span>주문번호</span><a href="/shop/orderView?n=${orderList.orderId}">${orderList.orderId}</a></p>
						<p><span>수령인</span>${orderList.orderRec}</p>
						<p><span>주소</span>(${orderList.userAddr1}) ${orderList.userAddr2} </p>
						<p><span>가격</span><fmt:formatNumber pattern="###,###,###" value="${orderList.amount}" /> 원</p>
						<p><span>상태</span>${orderList.delivery}</p>
					</div>
					</li>
					</c:forEach>
				</ul>
			</section>
		</div>
	</section>


</div>
</body>
</html>