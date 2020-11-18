<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>카테고리 관리 페이지</title>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
</head>
<body>
<h1>카테고리 관리 페이지</h1>

<a href="<c:url value='/admin'/>">관리자메인 페이지로</a> <br><br>


<a href="<c:url value='/admin/categories/post'/>"><button>카테고리 추가</button></a>
<table border="1">

<tr>
<td>카테고리 번호</td>
<td>상위카테고리</td>
<td>카테고리 이름</td>
<td>수정</td>
<td>삭제</td>
</tr>

<c:forEach var="cate" items="${list}">
<tr>
<td class="cateNo">${cate.cateNo}</td>
<td class="refName">${cate.refName}</td>
<td class="cateName">${cate.cateName}</td>
<td><button class="modify">수정</button></td>
<td><a href="<c:url value='/admin/categories/delete/${cate.cateNo}'/>"><button>삭제</button></a></td>
</tr>
</c:forEach>
</table>

<div class="modiForm" style="display:none">

	<form action="<c:url value='/admin/categories/modify'/>" method="post">
		<input name="cateNo" class="cateNo" type="hidden">
		<p class="num"></p>
		상위 카테고리 :
		<select name="cateRef" id="cateRef">
			<option></option>
			<c:forEach var="cat" items="${supList}">
			<option value="${cat.cateNo}">${cat.cateName}</option>
			</c:forEach>
		</select> <br>
		카테고리 이름:<input name="cateName" id="cateName" value=""> 
		<input type="submit" value="수정완료">
	</form>
</div>



</body>


<script>
$(".modify").click(function(){
	$(".modiForm").show();
	var cateNo = $(this).parent().parent().find(".cateNo").text()
	var textNo = "["+cateNo+"번 수정]";
	console.log(textNo);
	$(".num").text(textNo);
	$(".modiForm").find(".cateNo").val(cateNo);
	$("#cateName").val($(this).parent().parent().find(".cateName").text());	
});

</script>
</html>