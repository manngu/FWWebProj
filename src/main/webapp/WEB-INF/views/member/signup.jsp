<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
</head>
<body>
	<h1>회원가입</h1>
	
	<form action='<c:url value="/member/join"/>' method="post">
		 * 아이디 (이메일) <input type="email" name="userEmail"> <button>인증</button> <br>
		 * 비밀번호 <input type="password" name="userPw"> <br>
		 * 비밀번호 확인 <input type="password" name="userPw2"> <br>
		 * 이름 <input type="text" name="userName"> <br>
		 * 전화번호 <input type="tel" name="userPhone"> <br>
		 * 주소 <input type="text" name="userAddr1"> <br>
		 상세주소<input type="text" name="userAddr2"> <br>
		 <input type="submit" value="회원가입"/>
	 </form>
	 <button> <a href='<c:url value="/"/>'>HOME</a> </button>
</body>
</html>