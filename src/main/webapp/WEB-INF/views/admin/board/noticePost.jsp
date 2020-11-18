<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>NOTICE 등록화면</title>
</head>
<body>

<h1>NOTICE 등록화면</h1>

<form action="<c:url value='/admin/notices/post'/>" method="post">
제목: <input type="text" name="noticeTitle"><br>
내용: <br><textarea rows="5" cols="100" name="noticeContent"></textarea> <br>

<input type="submit" value="등록">
</form>


</body>
</html>