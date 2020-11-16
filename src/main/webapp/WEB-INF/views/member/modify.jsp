<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원정보수정</title>
</head>
<body>
	<h1>회원정보수정</h1>
	
	<form action='<c:url value="/member/modify"/>' method="post" >
	<input type="hidden" name="userNo" value="${user.userNo}"> <!-- 보이진않지만 같이 넘겨주는 값 -->
		 아이디 (이메일) <input type="email" name="userEmail" value=" ${user.userEmail}" readonly="readonly"><br>
		 비밀번호 <input type="text" name="userPw" value="${user.userPw}"> <br>
		 이름 <input type="text" name="userName" value="${user.userName}" readonly="readonly"> <br>
		 전화번호 <input type="tel" name="userPhone" value="${user.userPhone}"> <br>
		 주소 <input type="text" name="userAddr1" value="${user.userAddr1}"> <br>
		 상세주소<input type="text" name="userAddr2" value="${user.userAddr2}"> <br>
		 <input type="submit" value="회원정보수정"/>
	 </form>
	 	<button><a href='<c:url value="/member/show"/>'>취소</a></button>
</body>
</html>