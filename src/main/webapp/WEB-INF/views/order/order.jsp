<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>order</title>
</head>
<body>
<div class="orderInfo">
 <form role="form" method="post" autocomplete="off">
    
    
  <div class="inputArea">
   <label for="orderPerson">주문자</label>
   <input type="text" name="orderPerson" id="orderPerson" required="required" />
  </div>
  
  <div class="inputArea">
   <label for="orderPhone">수령인 연락처</label>
   <input type="text" name="orderPhone" id="orderPhone" required="required" />
  </div>
  
  <div class="inputArea">
   <label for="userAddr1">우편번호</label>
   <input type="text" name="userAddr1" id="userAddr1" required="required" />
  </div>
  
  <div class="inputArea">
   <label for="userAddr2">1차 주소</label>
   <input type="text" name="userAddr2" id="userAddr2" required="required" />
  </div>
 
 <div class="inputArea">
   <button type="submit" class="order_btn">주문</button>
   <a href="cartList.jsp"><input type="button" value="취소"> </a>
   
 		
  </div>
  
  <section id="content">
 
 <ul class="orderList">
  <c:forEach items="${orderList}" var="orderList">
  <li>
  <div>
   <p><span>주문번호</span><a href="/orderView?n=${orderList.orderId}">${orderList.orderId}</a></p>
   <p><span>수령인</span>${orderList.oderPerson}</p>
   <p><span>주소</span>(${orderList.userAddr1}) ${orderList.userAddr2} </p>
   <p><span>가격</span>
   <fmt:formatNumber pattern="###,###,###" value="${orderList.orderPrice}" /> 원</p>
  </div>
  </li>
  </c:forEach>
 </ul>

</section>
  
 </form> 
</div>
</body>
</html>