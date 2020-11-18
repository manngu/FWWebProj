<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>FAQ 등록 페이지</title>
</head>
<body>
<h1>FAQ 등록 페이지</h1>

<form action="<c:url value='/admin/faqs/post'/>" method="post">
제목: <input type="text" name="faqTitle"><br>
내용: <br><textarea rows="5" cols="100" name="faqContent"></textarea> <br>

<input type="submit" value="등록">
</form>



</body>
</html>