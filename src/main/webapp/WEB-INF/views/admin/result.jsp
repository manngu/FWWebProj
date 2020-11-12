<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>결과페이지</h1>

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
</body>
</html>