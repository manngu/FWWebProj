<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>qna 관리자 답변 페이지</title>
</head>
<body>
<h1>qna 답변 페이지</h1>

<h2>질문글</h2>
<table border=1>
<tr> <td>등록번호</td> <td>${q.qnaNo}</td> </tr>
<tr> <td>제목</td> <td>${q.qnaTitle}</td></tr>
<tr> <td>유저번호</td> <td>${q.userNo}</td></tr>
<tr> <td>상품번호</td> <td><a href="<c:url value='/admin/goods/${q.gdsNo}'/>">${q.gdsNo}</a> </td></tr>
<tr> <td>공개여부</td> <td>${q.qnaStatus==0?'공개':'비공개'}</td> </tr>
<tr> <td>등록일</td> <td>${q.qnaRegDate}</td></tr>
<tr> <td>내용</td><td colspan="5">${q.qnaContent}</td> </tr>

</table>

<br>
	
	

<form action="<c:url value='/admin/qnas/answer'/>" method="post">
<input type="hidden" name="qnaRef" value="${q.qnaNo}">
<input type="hidden" name="gdsNo" value="${q.gdsNo}">
<input type="hidden" name="qnaStatus" value="${q.qnaStatus}">
<input type="hidden" name="userNo" value="999999999"> <!-- 운영자 -->
<input type="hidden" name="qnaTitle" value="관리자 답변">

내용입력: <br>
<textarea name="qnaContent" rows=10 cols=100>
</textarea>


<input type="submit" value="등록">

</form>


</body>
</html>