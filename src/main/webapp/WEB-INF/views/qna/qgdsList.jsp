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
	<!-- QNA -->
	<table>
		<tr>
			<td colspan="4">QNA</td>
			<td align="right">
				<c:if test="${addQuestion != 1}">
					<input onclick="location.href='/shopping/qna/question?gdsNo=${gdsNo}&userNo=6'" 
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
			<!-- 리뷰 수정 -->
			<c:if test="${QmodifyNo == Q.qnaNo}">
				<form action="<c:url value='/qna/modify'/>" method="post">
				
					<input type="hidden" name="gdsNo" id="gds_no" value="${Q.gdsNo}" >
					<input type="hidden" name="qnaNo" id="qna-no" value="${Q.qnaNo}" >
					
					<tr>
						<td><input type="text" name="qnaTitle"value="${Q.qnaTitle}"></td>
						<td><input type="text" name="qnaContent" value="${Q.qnaContent}"></td>
						<td>${Q.userNo}</td>
						<td>
							<input type="checkbox" name="qnaStatus" value="0">공개
							<input type="checkbox" name="qnaStatus" value="1">비공개
						</td>
						<td><fmt:formatDate value="${Q.qnaRegDate}"
								pattern="yyyy년 MM월 dd일 a hh:mm" /></td>
						<td>
							<input type="submit" value="확인">
							<input type="reset" onclick="location.href='/shopping/qna/${Q.gdsNo}'" value="취소">
						</td>
					</tr>			
				</form>
			</c:if>
			<!-- 리뷰 수정 끝 -->
			
			<!-- 리뷰 목록 -->
			<c:if test="${QmodifyNo != Q.qnaNo}">
				<form action="<c:url value='/qna/delete'/>" method="post">
				
					<input type="hidden" name="gdsNo" id="gds_no" value="${Q.gdsNo}" >
					<input type="hidden" name="qnaNo" id="qna-no" value="${Q.qnaNo}" >
					
					<tr>
						<td>${Q.qnaTitle}</td>
						<td>${Q.qnaContent}</td>
						<td>${Q.userNo}</td>
						<td>
							<c:if test="${Q.qnaStatus == 1}">비밀글</c:if>
							<c:if test="${Q.qnaStatus == 0}">공개글</c:if>
						</td>
						<td><fmt:formatDate value="${Q.qnaRegDate}"
								pattern="yyyy년 MM월 dd일 a hh:mm" /></td>
						<td>
							<input onclick="location.href='/shopping/qna/replyWrite?qnaRef=${Q.qnaNo}&gdsNo=${Q.gdsNo}&userNo=6'" 
							type="button" value="댓글 쓰기">
							<input onclick="location.href='/shopping/qna/modify?qnaNo=${Q.qnaNo}&gdsNo=${Q.gdsNo}'" type="button" value="수정">
							<input type="submit" onclick="return confirm('정말로 삭제하시겠습니까?')" value="삭제">
						</td>
					</tr>			
				</form>
			</c:if>
			<!-- 리뷰 목록 끝 -->	
				
			<!-- 리뷰 댓글 목록 -->
			<c:forEach var="QR" items="${QReList}">
				<c:if test="${QR.qnaRef == Q.qnaNo}">
					
					<!-- 리뷰 댓글 수정 -->
					<c:if test="${QmodifyNo == QR.qnaNo}">
						<form action="<c:url value='/qna/modify'/>" method="post">
						
							<input type="hidden" name="gdsNo" id="gds_no" value="${QR.gdsNo}" >
							<input type="hidden" name="qnaNo" id="qna-no" value="${QR.qnaNo}" >
							<input type="hidden" name="qnaStatus" id="qna-status" value="${QR.qnaStatus}">
							<input type="hidden" name="qnaTitle" id="qna-title" value="${QR.qnaTitle}">
							
							<tr>
								<td align="right">▶</td>
								<td><input type="text" name="qnaContent" value="${QR.qnaContent}"></td>
								<td>${QR.userNo}</td>
								<td></td>
								<td><fmt:formatDate value="${QR.qnaRegDate}"
										pattern="yyyy년 MM월 dd일 a hh:mm" /></td>
								<td>
									<input type="submit" value="확인">
									<input type="reset" onclick="location.href='/shopping/qna/${QR.gdsNo}'" value="취소">
								</td>
							</tr>
						</form>
					</c:if>
					<!-- 리뷰 댓글 수정 끝-->
					
					<!-- 리뷰 댓글 목록 -->
					<c:if test="${QmodifyNo != QR.qnaNo}">
						<form action="<c:url value='/qna/delete'/>" method="post">
							
							<input type="hidden" name="gdsNo" id="gds_no" value="${QR.gdsNo}" >
							<input type="hidden" name="qnaNo" id="qna-no" value="${QR.qnaNo}" >
							
							<tr>
								<td align="right">▶</td>
								<td>${QR.qnaContent}</td>
								<td>${QR.userNo}</td>
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
					<!-- 리뷰 댓글 목록 끝-->
				</c:if>
				
			</c:forEach>			
			<!-- 리뷰 댓글 목록 끝-->
			
			<!-- qna 댓글 쓰기 -->
			<c:if test="${vo.qnaRef == Q.qnaNo}">
				<form action="<c:url value='/qna/insert'/>" method="get">
					<input type="hidden" name="gdsNo" id="gds_no" value="${vo.gdsNo}" >
					<input type="hidden" name="qnaNo" id="re_qna-no" value="${vo.qnaNo}">
					<input type="hidden" name="qnaRef" id="qna-ref" value="${vo.qnaRef}">
					<input type="hidden" name="qnaStatus" id="qna-status" value="${Q.qnaStatus}">
					<input type="hidden" name="qnaTitle" id="qna-title" value="${Q.qnaTitle}">
					<tr>
						<td align="right">▶</td>
						<td><textarea name="qnaContent" rows="4" cols="50" ></textarea></td>
						<td><input name="userNo" value="${vo.userNo}" readonly="readonly"></td>
						<td></td>
						<td></td>
						<td>
							<input type="submit" value="확인"> 
							<input type="reset" onclick="location.href='/shopping/qna/${vo.gdsNo}'" value="취소">
						</td>
					</tr>
				</form>
			</c:if>

		</c:forEach>
		
		<c:if test="${addQuestion == 1}">
			<form action="<c:url value='/qna/insert'/>" method="get">
		
					<input type="hidden" name="gdsNo" id="gds-no" value="${question.gdsNo}" >
					<input type="hidden" name="userNo" id="user-no" value="${question.userNo}" >
					<tr>
						<td><input type="text" name="qnaTitle"></td>
						<td><input type="text" name="qnaContent"></td>
						<td>${question.userNo}</td>
						<td>
							<input type="checkbox" name="qnaStatus" value="0">공개
							<input type="checkbox" name="qnaStatus" value="1">비공개
						</td>
						<td></td>
						<td>
							<input type="submit" value="확인">
							<input type="reset" onclick="location.href='/shopping/qna/${question.gdsNo}'" value="취소">
						</td>
					</tr>			
			</form>
		</c:if>
		
		
	</table>
	<!-- 리뷰  끝 -->
	<br>

</body>
</html>



<script type="text/javascript" src="https://code.jquery.com/jquery-3.1.1.min.js" > </script>

<script>



</script>
