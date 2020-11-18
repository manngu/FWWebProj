<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head> <title>NOTICE 수정페이지</title></head>

<body>
<h1>NOTICE 수정 페이지</h1> <br>
<div class="container">

        <form action="<c:url value='/admin/notices/modify'/>" method="post">
          <input type="hidden" name="noticeNo" value="${noticeInfo.noticeNo}">
        
           
          <div class="form-group">
            <label>제목</label>
            <input type="text" class="form-control" name='noticeTitle' value="${noticeInfo.noticeTitle}">
          </div>

          <div class="form-group">
            <label>내용</label>
            <textarea class="form-control" rows="5" name='noticeContent'>${noticeInfo.noticeContent}</textarea>
          </div>

          
          <input class="btn" type="submit" value="수정"/>
          <a class="btn" href="<c:url value='/notice/list'/>">목록</a>&nbsp;&nbsp;
          
        </form>



      </div>

</body>
</html>