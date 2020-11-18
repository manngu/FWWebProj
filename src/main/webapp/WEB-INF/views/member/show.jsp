<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원정보조회</title>
</head>
<body>
	<h1>회원정보조회</h1>
		 아이디 (이메일): ${user.userEmail} <br>
		 비밀번호:  ${user.userPw} <br>
		 이름:  ${user.userName}  <br>
		 전화번호:  ${user.userPhone} <br>
		 주소:  ${user.userAddr1} <br>
		 상세주소:  ${user.userAddr2} <br>
	  <button><a href='<c:url value="/"/>'>HOME</a></button>
	  <button><a href='<c:url value="/member/modify"/>'>회원정보수정</a></button>
	  <button><a href='<c:url value="/member/withdraw"/>'>회원정보탈퇴</a></button>
	  
</body>
</html>