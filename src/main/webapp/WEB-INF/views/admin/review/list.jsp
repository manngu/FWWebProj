<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>리뷰 페이지</title>
</head>
<body>
<h1>리뷰가 달린 상품 목록</h1>

<a href="<c:url value='/admin'/>">관리자메인 페이지로</a> <br>

<table border=1>
<tr> <td>리뷰번호</td><td>상품번호</td><td>유저번호</td> </tr>
<c:forEach var="rev" items="${list}">
<tr> <td>${rev.reviewNo}</td><td>${rev.gdsNo}</td><td>${rev.userNo}</td> </tr>
</c:forEach>
</table>






</body>
</html>