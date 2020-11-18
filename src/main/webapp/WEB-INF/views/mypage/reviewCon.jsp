<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>나의 리뷰</title>
</head>
<body>
	<div class="container">
	
	
<c:forEach var="review" items="${reviewList}">
	<table>
			<tr>
				<td>
					<label>리뷰사진</label>
	            	<textarea class="form-control" rows="1" name='reviewImg' readonly>${review.reviewImg}</textarea>
				</td>
				<br>
				<td>
					<label>내용</label>
	            	<textarea class="form-control" rows="1" name='reviewContent' readonly>${review.reviewContent}</textarea>
				</td>
				<br>
				<td>
					<label>별점</label>
	            	<textarea class="form-control" rows="1" name='reviewStars' readonly>${review.reviewStars}</textarea>
				</td>
				<br>
				<td>
					<label>작성일</label>
	            	<textarea class="form-control" rows="1" name='reviewRegDate' readonly>${review.reviewRegDate}</textarea>
				</td>
				<br>
			</tr>
	</table>
	댓글
	<table>
			<c:forEach var="RMR" items="${rMReList}">
				<c:if test="${RMR.reviewRef == review.reviewNo}">
			<tr>
				<td>
					<label>리뷰사진</label>
	            	<textarea class="form-control" rows="1" name='reviewImg' readonly>${RMR.reviewImg}</textarea>
				</td>
				<br>
				<td>
					<label>내용</label>
	            	<textarea class="form-control" rows="1" name='reviewContent' readonly>${RMR.reviewContent}</textarea>
				</td>
				<br>
				<td>
					<label>별점</label>
	            	<textarea class="form-control" rows="1" name='reviewStars' readonly>${RMR.reviewStars}</textarea>
				</td>
				<br>
				<td>
					<label>작성일</label>
	            	<textarea class="form-control" rows="1" name='reviewRegDate' readonly>${RMR.reviewRegDate}</textarea>
				</td>
				<br>
			</tr>
			</c:if>
			</c:forEach>	
			</table>
</c:forEach>
		</div>
		</body>
</html>