<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<style>
header.masthead {
	
	display: none;
}	
</style>
<br/><br/>
<div class="container">

        <form role="form" method="post">
          <input type="hidden" name="faqNo" value="${faqInfo.faqNo}">
        
           
          <div class="form-group">
            <label>제목</label>
            <input type="text" class="form-control" name='faqTitle' value="${faqInfo.faqTitle}">
          </div>

          <div class="form-group">
            <label>내용</label>
            <textarea class="form-control" rows="5" name='faqContent'>${faqInfo.faqContent}</textarea>
          </div>

          
          <input class="btn" type="submit" value="수정"/>
          <a class="btn" href="<c:url value='/faq/list'/>">목록</a>&nbsp;&nbsp;
          
        </form>



      </div>


