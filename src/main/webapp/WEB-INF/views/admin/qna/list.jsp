<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>qna 목록</title>
</head>
<body>
<h1>질문이 달린 상품 목록</h1>

<a href="<c:url value='/admin'/>">관리자메인 페이지로</a> <br>

<table border="1">
<tr>
<td>등록번호</td><td>상품번호</td><td>제목</td><td>회원번호</td><td>등록일</td>
</tr>

<c:forEach var="qna" items="${list}">
<tr>
<td>${qna.qnaNo}</td>
<td>${qna.gdsNo}</td>
<td><a href="<c:url value='/admin/qnas/${qna.qnaNo}'/>">${qna.qnaTitle}</a></td>
<td>${qna.userNo}</td>
<td>${qna.qnaRegDate}</td>
</tr>
</c:forEach>


</table>


 			
</body>
</html>