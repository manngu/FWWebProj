<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>카테고리 관리 페이지</title>
</head>
<body>
<h1>카테고리 관리 페이지</h1>

<a href="<c:url value='/admin'/>">관리자메인 페이지로</a> <br><br>


<a href="<c:url value='/admin/categoriesPost'/>"><button>카테고리 추가</button></a>
<table border="1">

<tr>
<td>카테고리 번호</td>
<td>상위카테고리</td>
<td>카테고리 이름</td>
<td>수정</td>
<td>삭제</td>
</tr>

<c:forEach var="cate" items="${list}">
<tr>
<td>${cate.cateNo}</td>
<td>${cate.refName}</td>
<td>${cate.cateName}</td>
<td><a href="">수정</a></td>
<td><a href="<c:url value='/admin/categoriesDelete/${cate.cateNo}'/>"><button>삭제</button></a></td>
</tr>
</c:forEach>
</table>


</body>
</html>