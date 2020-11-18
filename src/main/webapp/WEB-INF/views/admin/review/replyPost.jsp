<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>리뷰 답변 페이지</title>
</head>
<body>
<h1>리뷰 답변 페이지</h1>

<table border=1>
<tr> <td>등록번호</td> <td>${rev.reviewNo}</td> </tr>
<tr> <td>상품번호</td> <td><a href="<c:url value='/admin/goods/${rev.gdsNo}'/>">${rev.gdsNo}</a> </td></tr>
<tr> <td>유저번호</td> <td>${rev.userNo}</td></tr>
<tr> <td>등록일</td> <td>${rev.reviewRegDate}</td></tr>
<tr> <td>평점</td> <td>${rev.reviewStars}</td></tr>
<tr> <td>내용</td> <td>${rev.reviewContent}<br><img src="${pageContext.request.contextPath}${rev.reviewImg}" style="width:150px"></td></tr>
</table>









<form action="<c:url value='/admin/reviews/reply'/>" method="post">
<input type="hidden" name="gdsNo" value="${rev.gdsNo}">
<input type="hidden" name="userNo" value="1"> <!-- 관리자 -->
<input type="hidden" name="reviewRef" value="${rev.reviewNo}">
<input type="hidden" name="orderId" value="${rev.orderId}"> <!-- not null 조건때문에 어쩔수 없이 -->
내용입력: <br>
<textarea name="reviewContent" rows=10 cols=100>
</textarea>
<input type="submit" value="등록">

</form>






</body>
</html>