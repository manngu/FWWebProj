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
    <h1> 상품 상세보기  </h1>
    
<a href="<c:url value='/admin/goods'/>">목록으로</a>   

<table border="1">
<tr> <td>상품번호</td> <td> ${gds.gdsNo}</td>
<tr> <td>카테고리번호</td> <td>${gds.cateNo}</td>
<tr> <td>상품이름</td> <td>${gds.gdsName}</td>
<tr> <td>상품상세</td> <td><img src="${pageContext.request.contextPath}${gds.gdsDes}" style="width:150px"></td>
<tr> <td>상품썸네일</td> <td><img src="${pageContext.request.contextPath}${gds.gdsThumbImg}" style="width:150px"></td>
<tr> <td>상품등록일</td> <td>${gds.gdsRegDate}</td>
<tr> <td>상품마감일</td> <td>${gds.gdsDday}</td>
<tr> <td>상품기본가격</td> <td>${gds.gdsPrice}</td>
<tr> <td>상품판매량</td> <td>${gds.gdsSales}</td>
<tr> <td>상품제한수량</td> <td>${gds.gdsLimit}</td>
<tr> <td>상품할인률</td> <td>${gds.gdsDiscount}</td>
</tr>
</table> <br>

옵션
<table border="1">
<tr> <td></td> <td>옵션 명</td>  <td>옵션 수량</td> <td>부가 가격</td> </tr>

<c:forEach var="opt" items="${opt}" varStatus="st">
<tr>
<td>${st.count}</td>
<td>${opt.optionName}</td>
<td>${opt.optionCount}</td>
<td>${opt.optionAddPrice}</td>
</tr>
</c:forEach>
</table>

<br>


<a href="<c:url value='/admin/goods/modify/${gdsNo}'/>">수정</a>


</body>
</html>