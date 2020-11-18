<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>KG이니시스</title>
<script type="text/javascript" src="https://code.jquery.com/jquery-1.12.4.min.js" ></script>
<script type="text/javascript" src="https://cdn.iamport.kr/js/iamport.payment-1.1.5.js"></script>
</head>
<body>
	
	
	
	
    <script>
    var userNo = "<c:out value='${order.userNo}' />";
    var orderId = "<c:out value='${order.orderId}' />";
    var orderPerson = "<c:out value='${order.orderPerson}' />";
    var orderAddr1 = "<c:out value='${order.orderAddr1}' />";
    var orderAddr2 = "<c:out value='${order.orderAddr2}' />";
    var orderPhone = "<c:out value='${order.orderPhone}' />";
    var orderPrice = "<c:out value='${order.orderPrice}' />";
    
    
    $(function(){
        var IMP = window.IMP; // 생략가능
        IMP.init('imp80920733'); // 'iamport' 대신 부여받은 "가맹점 식별코드"를 사용
        var msg;
        
        IMP.request_pay({
        	pg : 'inicis', // version 1.1.0부터 지원.
    	    pay_method : 'card',
    	    merchant_uid : orderId,
    	    name : '쇼핑몰 결제 테스트',
            amount : orderPrice,
            buyer_no : userNo,
            buyer_name : orderPerson,
            buyer_tel : orderPhone,
            buyer_addr : orderAddr1

        }, function(rsp) {
            if ( rsp.success ) {
                var msg = '결제가 완료되었습니다.';
                msg += '고유ID : ' + rsp.imp_uid;
                msg += '상점 거래ID : ' + rsp.merchant_uid;
                msg += '결제 금액 : ' + rsp.paid_amount;
                msg += '카드 승인번호 : ' + rsp.apply_num;
                
                location.href="/shopping/order/orderComplete";
            } else {
                var msg = '결제에 실패하였습니다.';
                msg += '에러내용 : ' + rsp.error_msg;
                
                location.href="/shopping/mypage/carts";
            }
            alert(msg);
        });
        
    });
    </script> 
 
</body>
</html>