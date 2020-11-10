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
      <div class="card-header text-white" style="background-color: #ff52a0;">${article.boardNo}번 게시물 내용</div>
      <div class="card-body">

       
        

          <div class="form-group">
            <label>제목</label>
            <input type="text" class="form-control" name='faqTitle' value="${faq.faqTitle}" readonly>
          </div>

          <div class="form-group">
            <label>내용</label>
            <textarea class="form-control" rows="5" name='faqcontent' readonly>${faq.faqContent}</textarea>
          </div>

         
        <form id="formObj" role="form" action="<c:url value='/faq/delete'/>" method="post">  
          
          <input type="hidden" name="faqNo" value="${faq.faqNo}">
          <input type="hidden" name="page" value="${p.page}">
          <input type="hidden" name="countPerPage" value="${p.countPerPage}">
          
          <input type="button" value="목록" class="btn" id="list-btn"
		style="background-color: #ff52a0; margin-top: 0; height: 40px; color: white; border: 0px solid #388E3C; opacity: 0.8">&nbsp;&nbsp;
          
          
          <c:if test="${login.name == faq.writer}">
	          <input id="modBtn" type="button" value="수정" class="btn btn-warning" style="color:white;">&nbsp;&nbsp;
	          
	          <input type="submit" value="삭제" class="btn btn-danger" onclick="return confirm('정말로 삭제하시겠습니까?')">&nbsp;&nbsp;
          </c:if>
        </form>

      </div>
    </div>
  </div>
</div>
</div>

<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js">
//수정 완료 알림창 처리
const msg = "${msg}";
if(msg === "modSuccess") {
	alert("게시물 수정 완료!");
}

//제이쿼리의 시작
$(function() {
	
	
	//변수는 let, 상수는 const로 선언(ES2015 문법)
	const formElement = $("#formObj");
	
	//목록버튼 클릭이벤트 처리
	$("#list-btn").click(function () {
		console.log("목록 버튼이 클릭됨!");
		location.href= '/board/list?page=${p.page}' 
						+ '&countPerPage=${p.countPerPage}'
						+ '&keyword=${p.keyword}'
						+ '&condition=${p.condition}';
	});
	
	//수정버튼 클릭이벤트 처리
	//var modifyBtn = document.getElementById("modBtn"); //vanila js
	var modifyBtn = $("#modBtn"); //jQuery
	
	modifyBtn.click(function() {
		console.log("수정 버튼이 클릭됨!");
		formElement.attr("action", "/board/modify");
		formElement.attr("method", "get");
		formElement.submit();
	});
	
});//제이쿼리의 끝

</script>











