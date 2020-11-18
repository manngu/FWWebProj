<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.1.1.min.js" > </script>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>java script</title>
</head>
<body>
	
</body>
</html>

<script>
	
	// 회원탈퇴 alert
	const delete_result = "${delete_result}";
	console.log('delete_result: ' + delete_result);
	if(delete_result === "success") {
	   alert("회원탈퇴 성공!");
	   location.href='/shopping'
	} else if(delete_result === "failed") {
	   alert("비밀번호가 틀렸습니다. 다시 확인해주세요!");
	   location.href='/shopping/withdraw'
	} 
	
	// 로그인 alert
	const login_result = "${login_result}";
	if(login_result === "null") {
	   alert("아이디가 틀렸습니다. 다시 확인해주세요.");
	   location.href='/shopping/login'
	} else if(login_result === "success") {
	   alert("로그인에 성공하셨습니다.");
	   location.href='/shopping'
	} else if(login_result == "incorrectPw"){
		alert("비밀번호가 틀렸습니다. 다시 확인해주세요.");
		location.href='/shopping/login'
	}
	
	// 회원가입 alert
	const join_result = "${join_result}"
	if(join_result ==="blank"){
		alert("* 은 필수항목입니다.")
		location.href='/shopping/signup'
	} else if(join_result === "nomatched"){
		alert("비밀번호와 비밀번호 확인이 일치하지 않아요ㅠ")
		location.href='/shopping/signup';
	} else if(join_result === "success") {
		alert("회원가입 성공!");
		location.href='/shopping/login';
	}
	
</script>