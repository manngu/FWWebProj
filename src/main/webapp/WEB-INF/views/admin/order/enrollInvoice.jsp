<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>송장번호 등록 페이지</title>
</head>
<body>
<h1>송장번호 등록 페이지</h1>

<form action="<c:url value='/admin/orders/invoice'/>" method="post">

주문상세번호: <input type="number" name="orderDetailNo"> <br>
송장번호:	<input type="number" name="invoiceNo"> <br>


<input type="submit">
</form>


</body>
</html>