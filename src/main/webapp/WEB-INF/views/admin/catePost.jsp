<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>카테고리 등록 페이지</title>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
</head>
<body>
<h1>카테고리 등록 페이지</h1>

<div class="cateType">
<input type="radio" name="Sup" checked="checked" value="1"> 상위 카테고리 추가
<input type="radio" name="Sup" value="2"> 하위 카테고리 추가 --제이쿼리로 이거 선택 시, 밑의 셀렉트가 나오도록 할 것.
</div>


상위 카테고리: 
<select name="cateRef">
	<c:forEach var="cat" items="${list}">
	<option value="${cat.cateNo}">${cat.cateName}</option>
	</c:forEach>
</select>

<br>
    
카테고리 이름: <input type="text" name='cateName'/> <br>

  <input type="submit"> <br>

<form action="<c:url value='/admin/categories'/>" method="post">

</form>

<script>
$("input:radio[name=Sup]").click(function(){
	if($("input:radio[name=]"))
});



</script>





</body>
</html>