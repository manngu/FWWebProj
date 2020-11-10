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

<div class="row">
  <div class="col-lg-12">
    <div class="card">
      <div class="card-header text-white" style="background-color: #ff52a0;">${faq.faqNo}번 게시물 수정</div>
      <div class="card-body">

        <form role="form" method="post">
          <input type="hidden" name="faqNo" value="${faq.faqNo}">
        
           
          <div class="form-group">
            <label>제목</label>
            <input type="text" class="form-control" name='faqTitle' value="${faq.faqTitle}">
          </div>

          <div class="form-group">
            <label>내용</label>
            <textarea class="form-control" rows="5" name='faqContent'>${faq.faqContent}</textarea>
          </div>

          
          <input class="btn" type="submit" value="수정" style="background-color: orange; margin-top: 0; height: 40px; color: white; border: 0px solid #388E3C; opacity: 0.8"/>
          <a class="btn" href="<c:url value='/faq/list?page=${p.page}&countPerPage=${p.countPerPage}'/>"
		style="background-color: #ff52a0; margin-top: 0; height: 40px; color: white; border: 0px solid #388E3C; opacity: 0.8">목록</a>&nbsp;&nbsp;
          
        </form>



      </div>
    </div>
  </div>
</div>
</div>
