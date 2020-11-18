<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 상세 페이지</title>
</head>
<body>
    <h1> 상품
    <c:if test="${check=='detail'}">상세보기</c:if>
    <c:if test="${check=='수정'}">수정</c:if>
    </h1>
    
<a href="<c:url value='/admin/goods'/>">목록으로</a>   

<form action="<c:url value='/admin/goods/modify/${gds.gdsNo}'/>" method="post">
<table border="1">
<tr> <td>상품번호</td> <td> ${gds.gdsNo}</td>
<tr> <td>카테고리번호</td> <td><input name="cateNo" value="${gds.cateNo}" ${check=="수정"?'':'readonly'}></td>
<tr> <td>상품이름</td> <td><input name="gdsName" value="${gds.gdsName}" ${check=="수정"?'':'readonly'}></td>
<tr> <td>상품상세</td> <td><img src="${pageContext.request.contextPath}${gds.gdsDes}" style="width:150px"></td>
<tr> <td>상품썸네일</td> <td><img src="${pageContext.request.contextPath}${gds.gdsThumbImg}" style="width:150px"></td>
<tr> <td>상품등록일</td> <td>${gds.gdsRegDate}</td>
<tr> <td>상품마감일</td> <td><input name="gdsDday" value="${gds.gdsDday}" ${check=="수정"?'':'readonly'}></td>
<tr> <td>상품기본가격</td> <td><input name="gdsPrice" value="${gds.gdsPrice}" ${check=="수정"?'':'readonly'}></td>
<tr> <td>상품판매량</td> <td>${gds.gdsSales}</td>
<tr> <td>상품제한수량</td> <td><input name="gdsLimit" value="${gds.gdsLimit}" ${check=="수정"?'':'readonly'}></td>
<tr> <td>상품할인률</td> <td><input name="gdsDiscount" value="${gds.gdsDiscount}" ${check=="수정"?'':'readonly'}></td>
</tr>
</table>
<c:if test="${check=='수정'}">
 <input type="submit">
</c:if>
</form>


<br>
옵션
<table border="1">
<tr> <td></td> <td>옵션 명</td>  <td>옵션 수량</td> <td>부가 가격</td> <td>수정</td> </tr>

<c:forEach var="opt" items="${opt}" varStatus="st">


<form action="<c:url value='/admin/goods/options/${opt.optionNo}'/>" method="post">
<input type="hidden" name="optionNo" value="${opt.optionNo}">
<input type="hidden" name="gdsNo" value="${opt.gdsNo}">
<tr>
<td>${st.count}</td>
<td><input name="optionName" value="${opt.optionName}" ${check=="수정"?'':'readonly'}></td>
<td><input name="optionCount" value="${opt.optionCount}" ${check=="수정"?'':'readonly'}></td>
<td><input name="optionAddPrice" value="${opt.optionAddPrice}" ${check=="수정"?'':'readonly'}></td>
<td><input type="submit"></td>
</tr>
</form>

</c:forEach>
</table>


<br>

<c:if test="${check!='수정'}">
<a href="<c:url value='/admin/goods/modify/${gdsNo}'/>">수정</a>
</c:if>

</body>
</html>