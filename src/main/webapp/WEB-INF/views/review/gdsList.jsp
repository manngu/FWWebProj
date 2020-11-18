<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<style type="text/css">

table, tr, td {
    border: 1px solid black;
}
table {
    border-collapse: collapse;
}

</style>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	상품 정보 : <br>
	~~~~~~~~~~~~~~~~~~~~~
	<br>
	~~~~~~~~~~~~~~~~~~~~~
	<br>
	~~~~~~~~~~~~~~~~~~~~~
	<br>
	~~~~~~~~~~~~~~~~~~~~~
	<br>
	~~~~~~~~~~~~~~~~~~~~~
	<br>
	상품 상세 정보 : <br>
	~~~~~~~~~~~~~~~~~~~~~
	<br>
	~~~~~~~~~~~~~~~~~~~~~
	<br>
	~~~~~~~~~~~~~~~~~~~~~
	<br>
	~~~~~~~~~~~~~~~~~~~~~
	<br>
	~~~~~~~~~~~~~~~~~~~~~
	
	<br><br>
	<!-- 리뷰 -->
	리뷰  <br>
	<table border="1">
		<tr>
			<td>이미지</td>
			<td>내용</td>
			<td>작성자</td>
			<td>작성일</td>
			<td>별점</td>
		</tr>
	 	
		<c:forEach var="L" items="${List}">
			<!-- 리뷰 수정 -->
			<c:if test="${modifyNo == L.reviewNo}">
				<form action="<c:url value='/review/modify'/>" method="post">
				
					<input type="hidden" name="gdsNo" id="gds_no" value="${L.gdsNo}" >
					<input type="hidden" name="reviewNo" id="review-no" value="${L.reviewNo}" >
					
					<tr>
						<td><input type="text" name="reviewImg"value="${L.reviewImg}"></td>
						<td><input type="text" name="reviewContent" value="${L.reviewContent}"></td>
						<td>${map.get(L.reviewNo)}</td>
						<td><fmt:formatDate value="${L.reviewRegDate}"
								pattern="yyyy년 MM월 dd일 a hh:mm" /></td>
						<td>
							<select name="reviewStars"> 
								<option value="5">★★★★★
						    	<option value="4">★★★★☆
						    	<option value="3">★★★☆☆
						    	<option value="2">★★☆☆☆
						    	<option value="1">★☆☆☆☆
							</select>
						</td>
						<td>
							<input type="submit" value="확인">
							<input type="reset" onclick="location.href='/shopping/review/${L.gdsNo}'" value="취소">
						</td>
					</tr>			
				</form>
			</c:if>
			<!-- 리뷰 수정 끝 -->
			
			<!-- 리뷰 목록 -->
			<c:if test="${modifyNo != L.reviewNo}">
				<form action="<c:url value='/review/delete'/>" method="post">
				
					<input type="hidden" name="gdsNo" id="gds_no" value="${L.gdsNo}" >
					<input type="hidden" name="reviewNo" id="review-no" value="${L.reviewNo}" >
					
					<tr>
						<td>${L.reviewImg}</td>
						<td>${L.reviewContent}</td>
						<td>${map.get(L.reviewNo)}</td>
						<td><fmt:formatDate value="${L.reviewRegDate}"
								pattern="yyyy년 MM월 dd일 a hh:mm" /></td>
						<td>
							<c:if test="${L.reviewStars == 5}">★★★★★</c:if>
							<c:if test="${L.reviewStars == 4}">★★★★☆</c:if>
							<c:if test="${L.reviewStars == 3}">★★★☆☆</c:if>
							<c:if test="${L.reviewStars == 2}">★★☆☆☆</c:if>
							<c:if test="${L.reviewStars == 1}">★☆☆☆☆</c:if>
						</td>
						<td>
							<input onclick="location.href='/shopping/review/replyWrite?reviewRef=${L.reviewNo}&gdsNo=${L.gdsNo}&userNo=6&orderId=2001'" 
							type="button" value="댓글 쓰기">
							<input onclick="location.href='/shopping/review/modify?reviewNo=${L.reviewNo}&gdsNo=${L.gdsNo}'" type="button" value="수정">
							<input type="submit" onclick="return confirm('정말로 삭제하시겠습니까?')" value="삭제">
						</td>
					</tr>			
				</form>
			</c:if>
			<!-- 리뷰 목록 끝 -->	
				
			<!-- 리뷰 댓글 목록 -->
			<c:forEach var="R" items="${ReList}">
				<c:if test="${R.reviewRef == L.reviewNo}">
				
					<!-- 리뷰 댓글 수정 -->
					<c:if test="${modifyNo == R.reviewNo}">
						<form action="<c:url value='/review/modify'/>" method="post">
						
							<input type="hidden" name="gdsNo" id="gds_no" value="${R.gdsNo}" >
							<input type="hidden" name="reviewNo" id="re_review_no" value="${R.reviewNo}">
							<input type="hidden" name="userNo" id="user_no" value="${R.userNo}">
							<input type="hidden" name="reviewRef" id="re_review_ref" value="${R.reviewRef}">
							
							<tr>
								<td align="right">▶</td>
								<td><input type="text" name="reviewContent" value="${R.reviewContent}"></td>
								<td>${remap.get(R.reviewNo)}</td>
								<td><fmt:formatDate value="${R.reviewRegDate}"
										pattern="yyyy년 MM월 dd일 a hh:mm" /></td>
								<td></td>
								<td>
									<input type="submit" value="확인">
									<input type="reset" onclick="location.href='/shopping/review/${R.gdsNo}'" value="취소">
								</td>
							</tr>
						</form>
					</c:if>
					<!-- 리뷰 댓글 수정 끝-->
					
					<!-- 리뷰 댓글 목록 -->
					<c:if test="${modifyNo != R.reviewNo}">
						<form action="<c:url value='/review/delete'/>" method="post">
							
							<input type="hidden" name="gdsNo" id="gds_no" value="${R.gdsNo}" >
							<input type="hidden" name="reviewNo" id="re-review-no"value="${R.reviewNo}">
							<tr>
								<td align="right">▶</td>
								<td>${R.reviewContent}</td>
								<td>${remap.get(R.reviewNo)}</td>
								<td><fmt:formatDate value="${R.reviewRegDate}"
										pattern="yyyy년 MM월 dd일 a hh:mm" /></td>
								<td></td>
								<td>
									<input onclick="location.href='/shopping/review/modify?reviewNo=${R.reviewNo }&gdsNo=${R.gdsNo}'" type="button" value="수정">
									<input type="submit" onclick="return confirm('정말로 삭제하시겠습니까?')" value="삭제">
								</td>
							</tr>
						</form>
					</c:if>
					<!-- 리뷰 댓글 목록 끝-->
				</c:if>
				
			</c:forEach>			
			<!-- 리뷰 댓글 목록 끝-->
			
			<!-- 리뷰 댓글 추가 -->
			<c:if test="${vo.reviewRef == L.reviewNo}">
				<form action="<c:url value='/review/insert'/>" method="get">
					<input type="hidden" name="gdsNo" id="gds_no" value="${vo.gdsNo}" >
					<input type="hidden" name="reviewNo" id="re_review-no" value="${vo.reviewNo}">
					<input type="hidden" name="orderId" id="order-id" value="${vo.orderId}">
					<input type="hidden" name="reviewRef" id="review-ref" value="${vo.reviewRef}">
					<input type="hidden" name="userNo" id="user_no" value="${vo.userNo}">
					
					<tr>
						<td align="right">▶</td>
						<td><input type="text" name="reviewContent"></td>
						<td><input name="userName" value="${user.userName}" readonly="readonly"></td>
						<td></td>
						<td></td>
						<td><input type="submit" value="확인"> 
						<input type="reset" onclick="location.href='/shopping/review/${vo.gdsNo}'" value="취소"></td>
					</tr>
				</form>
			</c:if>
			<!-- 리뷰 댓글 추가 끝-->
		</c:forEach>
		
		
	</table>
	<!-- 리뷰  끝 -->
	<br>

</body>
</html>



<script type="text/javascript" src="https://code.jquery.com/jquery-3.1.1.min.js" > </script>

<script>



</script>
