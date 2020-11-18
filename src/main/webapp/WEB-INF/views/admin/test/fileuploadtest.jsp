<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>업로드 테스트</h1>

    <form action="<c:url value='/admin/upload'/>" method="post" enctype="multipart/form-data">

  
  상품명: <input type="text" name="gdsName"> <br>

 썸네일: <input type="file" name="file1"> <br>
<!--  상세사진: <input type="text" name="gdsDes"> <br>-->

	<input type="submit" value="상품등록">
	</form>


</body>
</html>