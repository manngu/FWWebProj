<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- 포맷팅 관련 태그라이브러리(JSTL/fmt) --%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>나의 리뷰</title>
</head>
	<style>
	#container_box table td { width:100px; }
	</style>

	<table class="table table-bordered table-hover">
		<thead>
			<tr>
				<th>목록</th>
			</tr>
		</thead>
				
		<c:if test="${review.size() <= 0}">
			<tr>
				<td colspan="5" align="center">
					<strong>입력한 리뷰가 없습니다!!</strong>
				</td>
			</tr>
		</c:if>

		<!-- 게시물이 들어갈 공간 -->
		
		<c:if test="${review.size() > 0}">
		
		<tbody>
		<c:forEach var="b" items="${review}" >
			<tr>
				<td>
					<a href="<c:url value='/review/reviewCon/${b.reviewNo}' />">
				${b.reviewTitle}
					</a>
				</td>
			</tr>
		</c:forEach>
		</tbody>
		</c:if>
	</table>

</html>