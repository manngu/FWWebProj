<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<title>F/W Web</title>
</head>
<body>
	<div align="center">
		<h2>
			F/W Web Pj
		</h2>
	</div>
	<a href="<c:url value='goods/topList?gdsType=1'/>"/>상의<br>
	<a href="#"/>하의(ex)<br>
	<a href="#"/>ACC(ex)<br>
	<a href="#"/>특가(ex)<br>
	<br><br>
	<c:if test="${user.userNo == null}">
		<button><a href="<c:url value='member/index'/>">로그인</a></button>
	</c:if>
	<c:if test="${user.userNo != null}">
		<button> <a href='<c:url value="/admin"/>'>관리자 페이지</a></button>
		<button> <a href='<c:url value="/mypage"/>'> 마이페이지 </a></button><br>
		<button><a href='<c:url value="/member/logout"/>'> 로그아웃 </a></button> 
		<br>
	</c:if>
</body>
</html>
