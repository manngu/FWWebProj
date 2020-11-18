<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품관리 페이지</title>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.1.1.min.js" > </script>
</head>
<body>

<h1>상품관리 페이지</h1>

<a href="<c:url value='/admin'/>">관리자메인 페이지로</a> <br>
<a href="<c:url value='/admin/goods/post'/>">상품등록</a> <br><br>


<a href="<c:url value='/admin/goods'/>"><button>리셋</button></a> <br><br>

<form action="<c:url value='/admin/goods'/>" method="get">
<input type="hidden" name="condition" value="cateSort">
<select name="keyword" onchange="fncateSort(this.form)">
	<option value="">==카테고리선택==</option> 
	<c:forEach var="cat" items="${catList}">
		<option value="${cat.cateNo}">${cat.cateName}</option>	
	</c:forEach>
</select>
</form>
<br>


<table border="1">
<tr>
<td>상품번호</td>
<td>카테고리명</td>
<td>상품이름</td>
<td>상품판매량</td>
<td>등록일</td>
<td>판매만기일</td>
<td>공개/비공개</td>
</tr>

<c:forEach var="gds" items="${list}">
<tr>
<td>${gds.gdsNo}</td>
<td>${gds.cateName}</td>
<td><a href="<c:url value='/admin/goods/${gds.gdsNo}'/>">${gds.gdsName}</a></td>
<td>${gds.gdsSales}</td>
<td>${gds.gdsRegDate}</td>
<td>${gds.gdsDday}</td>
<td><a href="<c:url value='/admin/goods/delete/${gds.gdsNo}'/>"><button>${gds.gdsStatus eq 0 ? "공개" : "비공개"}</button></a></td>
</tr>
</c:forEach>
</table>

			<!-- 페이징 처리 부분  -->

					<!-- 이전버튼 -->
					<c:if test="${pc.prev}">
						<a href="<c:url value='/admin/goods${pc.makeURI(pc.beginPage-1)}'/>">이전</a> 
					</c:if>


					<!-- 페이지 버튼 -->
					<c:forEach var="pageNum" begin="${pc.beginPage}" end="${pc.endPage}">
						<a href="<c:url value='/admin/goods${pc.makeURI(pageNum)}'/>"
							style="${(pc.paging.page == pageNum) ? 'font-weight:bold' : '' }">${pageNum}</a>
					</c:forEach>

					<!-- 다음 버튼 -->
					<c:if test="${pc.next}">
						<a href="<c:url value='/admin/goods${pc.makeURI(pc.endPage+1)}'/>">다음</a>
					</c:if>

			<!-- 페이징 처리 끝 -->




<script>
function fncateSort(obj)
{
	obj.submit();
}
</script>




</body>
</html>