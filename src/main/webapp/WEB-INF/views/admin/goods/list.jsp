<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품관리 페이지</title>
</head>
<body>

<h1>상품관리 페이지</h1>

<a href="<c:url value='/admin'/>">관리자메인 페이지로</a> <br>
<a href="<c:url value='/admin/goods/post'/>">상품등록</a>

<table border="1">
<tr>
<td>상품번호</td>
<td>카테고리명</td>
<td>상품이름</td>
<td>상품판매량</td>
<td>등록일</td>
<td>판매만기일</td>
<td>공개/비공개</td>
</tr>

<c:forEach var="gds" items="${list}">
<tr>
<td>${gds.gdsNo}</td>
<td>${gds.cateName}</td>
<td><a href="<c:url value='/admin/goods/${gds.gdsNo}'/>">${gds.gdsName}</a></td>
<td>${gds.gdsSales}</td>
<td>${gds.gdsRegDate}</td>
<td>${gds.gdsDday}</td>
<td><a href="<c:url value='/admin/goods/delete/${gds.gdsNo}'/>"><button>${gds.gdsStatus eq 0 ? "공개" : "비공개"}</button></a></td>
</tr>
</c:forEach>
</table>




</body>
</html>