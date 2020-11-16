<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>	
		${info.gdsName } 상세보기
	</h2>
	
	${info.gdsThumbImg } <br>
	이름 : ${info.gdsName} <br>
	가격 : ${info.gdsPrice} <br>
	수량 : <button type="button" class="minus">-</button> 
		 <input type="number" class="numBox" min="1" max="5" value="1" readonly="readonly"/>
		 <button type="button" class="plus">+</button>
		 <br>
	옵션 : 아직 미정!! <br>
	${info.gdsDes} <br><br>
	
	<button onclick="location.href='/shopping/cart/${info.gdsNo}'">장바구니</button>
	<button onclick="location.href='/shopping/buy/${info.gdsNo}'">구매하기</button>
	
	<br><br>
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
							<input type="reset" onclick="location.href='/shopping/goods/${L.gdsNo}'" value="취소">
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
							<input onclick="location.href='/shopping/goods/${L.gdsNo}/replyWrite?&reviewRef=${L.reviewNo}&gdsNo=${L.gdsNo}&userNo=${user.userNo}&orderId=2003'" type="button" value="댓글 쓰기"/>
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
									<input type="reset" onclick="location.href='/shopping/goods/${R.gdsNo}'" value="취소">
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
			<c:if test="${ReviewVo.reviewRef == L.reviewNo}">
				<form action="<c:url value='/review/insert'/>" method="get">
					<input type="hidden" name="gdsNo" id="gds_no" value="${ReviewVo.gdsNo}" >
					<input type="hidden" name="reviewNo" id="re_review-no" value="${ReviewVo.reviewNo}">
					<input type="hidden" name="orderId" id="order-id" value="${ReviewVo.orderId}">
					<input type="hidden" name="reviewRef" id="review-ref" value="${ReviewVo.reviewRef}">
					<input type="hidden" name="userNo" id="user_no" value="${ReviewVo.userNo}">
					
					<tr>
						<td align="right">▶</td>
						<td><input type="text" name="reviewContent"></td>
						<td><input name="userName" value="${user.userName}" readonly="readonly"></td>
						<td></td>
						<td></td>
						<td><input type="submit" value="확인"> 
						<input type="reset" onclick="location.href='/shopping/goods/${ReviewVo.gdsNo}'" value="취소"></td>
					</tr>
				</form>
			</c:if>
			<!-- 리뷰 댓글 추가 끝-->
		</c:forEach>
		
		
	</table>
	<!-- 리뷰  끝 -->



	
	<br><br><br>
	<!-- QNA -->
	<table border="1">
		<tr>
			<td colspan="4">QNA</td>
			<td align="right">
				<c:if test="${addQuestion != 1}">
					<input onclick="location.href='/shopping/qna/question?gdsNo=${gdsNo}&userNo=${user.userNo}'" 
								type="button" value="문의 하기">	
				</c:if>
			</td>

		</tr>
		<tr align="center">
			<td>제목</td>
			<td>내용</td>
			<td>작성자</td>
			<td>상태</td>
			<td>작성일</td>
		</tr>
	 	
		<c:forEach var="Q" items="${QList}">
			<!-- qna 수정 -->
			<c:if test="${QmodifyNo == Q.qnaNo}">
				<form action="<c:url value='/qna/modify'/>" method="post">
				
					<input type="hidden" name="gdsNo" id="gds_no" value="${Q.gdsNo}" >
					<input type="hidden" name="qnaNo" id="qna-no" value="${Q.qnaNo}" >
					
					<tr>
						<td><input type="text" name="qnaTitle"value="${Q.qnaTitle}"></td>
						<td><input type="text" name="qnaContent" value="${Q.qnaContent}"></td>
						<td>${Qmap.get(Q.qnaNo)}</td>
						<td>
							<c:if test="${Q.qnaStatus == 0}">
								<input type="radio" name="qnaStatus" value="0" checked>공개
								<input type="radio" name="qnaStatus" value="1">비공개
							</c:if>
							<c:if test="${Q.qnaStatus == 1}">
								<input type="radio" name="qnaStatus" value="0">공개
								<input type="radio" name="qnaStatus" value="1" checked>비공개
							</c:if>
						</td>
						<td><fmt:formatDate value="${Q.qnaRegDate}"
								pattern="yyyy년 MM월 dd일 a hh:mm" /></td>
						<td>
							<input type="submit" value="확인">
							<input type="reset" onclick="location.href='/shopping/goods/${Q.gdsNo}'" value="취소">
						</td>
					</tr>			
				</form>
			</c:if>
			<!-- qna 수정 끝 -->
			
			<!-- qna 목록 -->
			<c:if test="${QmodifyNo != Q.qnaNo}">
				<form action="<c:url value='/qna/delete'/>" method="post">
				
					<input type="hidden" name="gdsNo" id="gds_no" value="${Q.gdsNo}" >
					<input type="hidden" name="qnaNo" id="qna-no" value="${Q.qnaNo}" >
					
					<tr>
						<td>${Q.qnaTitle}</td>
						<td>${Q.qnaContent}</td>
						<td>${Qmap.get(Q.qnaNo)}</td>
						<td>
							<c:if test="${Q.qnaStatus == 1}">비밀글</c:if>
							<c:if test="${Q.qnaStatus == 0}">공개글</c:if>
						</td>
						<td><fmt:formatDate value="${Q.qnaRegDate}"
								pattern="yyyy년 MM월 dd일 a hh:mm" /></td>
						<td>
							<input onclick="location.href='/shopping/qna/replyWrite?qnaRef=${Q.qnaNo}&gdsNo=${Q.gdsNo}&userNo=${user.userNo}'" 
							type="button" value="댓글 쓰기">
							<input onclick="location.href='/shopping/qna/modify?qnaNo=${Q.qnaNo}&gdsNo=${Q.gdsNo}'" type="button" value="수정">
							<input type="submit" onclick="return confirm('정말로 삭제하시겠습니까?')" value="삭제">
						</td>
					</tr>			
				</form>
			</c:if>
			<!-- qna 목록 끝 -->	
				
			<!-- qna 댓글 목록 -->
			<c:forEach var="QR" items="${QReList}">
				<c:if test="${QR.qnaRef == Q.qnaNo}">
					
					<!-- qna 댓글 수정 -->
					<c:if test="${QmodifyNo == QR.qnaNo}">
						<form action="<c:url value='/qna/modify'/>" method="post">
						
							<input type="hidden" name="gdsNo" id="gds_no" value="${QR.gdsNo}" >
							<input type="hidden" name="qnaNo" id="qna-no" value="${QR.qnaNo}" >
							<input type="hidden" name="qnaStatus" id="qna-status" value="${QR.qnaStatus}">
							<input type="hidden" name="qnaTitle" id="qna-title" value="${QR.qnaTitle}">
							<input type="hidden" name="userNo" id="user-no" value="${QR.userNo}" >
							
							<tr>
								<td align="right">▶</td>
								<td><input type="text" name="qnaContent" value="${QR.qnaContent}"></td>
								<td>${Qremap.get(QR.qnaNo)}</td>
								<td></td>
								<td><fmt:formatDate value="${QR.qnaRegDate}"
										pattern="yyyy년 MM월 dd일 a hh:mm" /></td>
								<td>
									<input type="submit" value="확인">
									<input type="reset" onclick="location.href='/shopping/goods/${QR.gdsNo}'" value="취소">
								</td>
							</tr>
						</form>
					</c:if>
					<!-- qna 댓글 수정 끝-->
					
					<!-- qna 댓글 목록 -->
					<c:if test="${QmodifyNo != QR.qnaNo}">
						<form action="<c:url value='/qna/delete'/>" method="post">
							
							<input type="hidden" name="gdsNo" id="gds_no" value="${QR.gdsNo}" >
							<input type="hidden" name="qnaNo" id="qna-no" value="${QR.qnaNo}" >
							
							<tr>
								<td align="right">▶</td>
								<td>${QR.qnaContent}</td>
								<td>${Qremap.get(QR.qnaNo)}</td>
								<td>
									<c:if test="${Q.qnaStatus == 1}">비밀글</c:if>
									<c:if test="${Q.qnaStatus == 0}">공개글</c:if>
								</td>
								<td><fmt:formatDate value="${QR.qnaRegDate}"
										pattern="yyyy년 MM월 dd일 a hh:mm" /></td>
								<td>
									<input onclick="location.href='/shopping/qna/modify?qnaNo=${QR.qnaNo }&gdsNo=${QR.gdsNo}'" type="button" value="수정">
									<input type="submit" onclick="return confirm('정말로 삭제하시겠습니까?')" value="삭제">
								</td>
							</tr>
						</form>
					</c:if>
					<!-- qna 댓글 목록 끝-->
				</c:if>
				
			</c:forEach>			
			<!-- qna 댓글 목록 끝-->
			
			<!-- qna 댓글 쓰기 -->
			<c:if test="${vo.qnaRef == Q.qnaNo}">
				<form action="<c:url value='/qna/insert'/>" method="get">
					<input type="hidden" name="gdsNo" id="gds_no" value="${vo.gdsNo}" >
					<input type="hidden" name="qnaNo" id="re_qna-no" value="${vo.qnaNo}">
					<input type="hidden" name="qnaRef" id="qna-ref" value="${vo.qnaRef}">
					<input type="hidden" name="qnaStatus" id="qna-status" value="${Q.qnaStatus}">
					<input type="hidden" name="qnaTitle" id="qna-title" value="${Q.qnaTitle}">
					<input type="hidden" name="userNo" id="re_user_qna-no" value="${vo.userNo}">
					
					<tr>
						<td align="right">▶</td>
						<td><textarea name="qnaContent" rows="4" cols="50" ></textarea></td>
						<td><input name="userName" value="${user.userName}" readonly="readonly"></td>
						<td></td>
						<td></td>
						<td>
							<input type="submit" value="확인"> 
							<input type="reset" onclick="location.href='/shopping/goods/${vo.gdsNo}'" value="취소">
						</td>
					</tr>
				</form>
			</c:if>

		</c:forEach>
		
		<!-- qna 문의하기 추가 -->
		<c:if test="${addQuestion == 1}">
			<form action="<c:url value='/qna/insert'/>" method="get">
		
					<input type="hidden" name="gdsNo" id="gds-no" value="${question.gdsNo}" >
					<input type="hidden" name="userNo" id="user-no" value="${question.userNo}" >
					<tr>
						<td><input type="text" name="qnaTitle"></td>
						<td><input type="text" name="qnaContent"></td>
						<td>${user.userName}</td>
						<td>
							<input type="radio" name="qnaStatus" value="0" checked>공개
							<input type="radio" name="qnaStatus" value="1">비공개
						</td>
						<td></td>
						<td>
							<input type="submit" value="확인">
							<input type="reset" onclick="location.href='/shopping/goods/${question.gdsNo}'" value="취소">
						</td>
					</tr>			
			</form>
		</c:if>
		<!-- qna 댓글 추가 끝 -->
		
	</table>
	<!-- qna  끝 -->



	
</body>
</html>

<script type="text/javascript" src="https://code.jquery.com/jquery-3.1.1.min.js" > </script>

 <script>
  $(".plus").click(function(){
   var num = $(".numBox").val();
   var plusNum = Number(num) + 1;
   
   if(plusNum >= 10) {
    $(".numBox").val(num);
   } else {
    $(".numBox").val(plusNum);          
   }
  });
  
  $(".minus").click(function(){
   var num = $(".numBox").val();
   var minusNum = Number(num) - 1;
   
   if(minusNum <= 0) {
    $(".numBox").val(num);
   } else {
    $(".numBox").val(minusNum);          
   }
  });
  
  
 </script>
 
</p>