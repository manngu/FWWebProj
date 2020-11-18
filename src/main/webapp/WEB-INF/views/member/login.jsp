<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
</head>
<body>
	<h1>로그인</h1>
	
	<form action='<c:url value="/member/login"/>' method="post">
		아이디<input type="email" name="userEmail"> <br>
		비밀번호 <input type="password" name="userPw"><br>
		<input type="submit" value="로그인"/>
	</form> <br>
	<button><a href='<c:url value="/member/signup"/>'>회원가입</a> </button>
	<button><a href='<c:url value="/"/>'>HOME</a></button>
</body>
</html>