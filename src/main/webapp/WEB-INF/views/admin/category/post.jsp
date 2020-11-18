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


<form action="<c:url value='/admin/categories/post'/>" method="post">

<div class="cateType">
<input type="radio" name="type" value="1"> 상위 카테고리 추가
<input type="radio" name="type" value="2"> 하위 카테고리 추가
</div>
<br>

<div class="sup" style="display:none">
	카테고리 이름: <input type="text" name="cateName"/><br> <br>
  	<input type="submit"> <br>
</div>

<div class="sub" style="display:none">
	상위 카테고리: 
	<select name="cateRef" id="cateRef">
		<c:forEach var="cat" items="${list}">
		<option value="${cat.cateNo}">${cat.cateName}</option>
		</c:forEach>
	</select> <br>
   	카테고리 이름: <input type="text" name="cateName"/> <br> <br>
  	<input type="submit"> <br>
</div>

</form>






<script>
$("input:radio[name=type]").click(function(){
	if($("input:radio[name=type]:checked").val()=="1"){ //상위 카테고리 추가
		$(".sub").find("select, input").prop("disabled",true);
		$(".sup").find("input").prop("disabled",false);
		$(".sub").hide();
		$(".sup").show();
	
	}else if($("input:radio[name=type]:checked").val()=="2"){ //하위 카테고리 추가
		$(".sup").find("input").prop("disabled",true);
		$(".sub").find("input,select").prop("disabled",false);
		$(".sup").hide();
		$(".sub").show();
		
	}
});

</script>





</body>
</html>