<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>상의 리스트</h3>	
	
	<a href="/">아우터</a> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	<a href="#">맨투맨(ex)</a> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	<a href="#">후드(ex)</a><br><br><br><br>
	
	<c:forEach var="L" items="${list}">
		<table>
			<tr>
				<td>
					<a href="<c:url value='/goods/${L.gdsNo }'/>"/>${L.gdsName}
				</td>
			</tr>
		</table>
	
	</c:forEach>
	
</body>
</html>