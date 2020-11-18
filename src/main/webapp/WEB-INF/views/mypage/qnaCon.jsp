<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- 포맷팅 관련 태그라이브러리(JSTL/fmt) --%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>나의 문의</title>
</head>
<body>
	<div class="container">
	
	
<c:forEach var="qna" items="${qnaList}">
	<table>
			<tr>
				<td>
					<label>제목</label>
	            	<textarea class="form-control" rows="2" name='qnaTitle' readonly>"${qna.qnaTitle}"</textarea>
				</td>
				<br>
				<td>
					<label>내용</label>
	            	<textarea class="form-control" rows="1" name='qnaContent' readonly>${qna.qnaContent}</textarea>
				</td>
				<br>
				<td>
					<label>작성일</label>
	            	<textarea class="form-control" rows="1" name='qnaRegDate' readonly>${qna.qnaRegDate}</textarea>
				</td>
				<br>
			</tr>
	</table>
	답변
	<table>
			<c:forEach var="QMR" items="${qMReList}">
				<c:if test="${QMR.qnaRef == qna.qnaNo}">
				<tr>
				<td>
					<label>제목</label>
	            	<textarea class="form-control" rows="2" name='qnaTitle' readonly>${QMR.qnaTitle}</textarea>
				</td>
				<td>
					<label>내용</label>
	            	<textarea class="form-control" rows="1" name='qnaContent' readonly>${QMR.qnaContent}</textarea>
				</td>
				<td>
					<label>작성일</label>
	            	<textarea class="form-control" rows="1" name='qnaRegDate' readonly>${QMR.qnaRegDate}</textarea>
				</td>
			</tr>
			</c:if>
			</c:forEach>	
			</table>
</c:forEach>
		</div>
		</body>
</html>