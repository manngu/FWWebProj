<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원탈퇴</title>
</head>
<body>
	<h1>회원탈퇴</h1>
	<form action='<c:url value="/member/withdraw"/>' method="post">
		<input type="hidden" name="userNo" value="${user.userNo}"> 
		 비밀번호 <input type="password" name="userPw">
		 <input type="submit" value="탈퇴" onclick="return confirm('정말로 탈퇴하시겠습니까?')"/>
	 </form>
	 <br>
	 <button> <a href='<c:url value="/"/>'> HOME </a></button> <br>
</body>
</html>