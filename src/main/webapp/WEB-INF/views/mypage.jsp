<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- 포맷팅 관련 태그라이브러리(JSTL/fmt) --%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>My Page</title>
</head>
	<style>
	#container_box table td { width:100px; }
	</style>
<body>

<tr>
	<td>
		<a href="<c:url value='/mypage/reviewList' />">
				내가 쓴 리뷰보기
					</a>
	</td>
</tr>
<br>
<tr>
	<td>
		<a href="<c:url value='/mypage/qnaList' />">
				내가 쓴 문의보기
					</a>
	</td>
</tr>
<br>
<tr>
	<td>
		<a href="<c:url value='/mypage/orderList' />">
				나의 주문내역
					</a>
	</td>
</tr>

</body>
</html>