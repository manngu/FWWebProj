<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>



<div class="container">


        <form role="form" method="post">
        
          
          <div class="form-group">
            <label>제목</label>
            <input type="text" class="form-control" name='noticeTitle'>
          </div>

          <div class="form-group">
            <label>내용</label>
            <textarea class="form-control" rows="5" name='noticeContent' placeholder="게시글 내용을 입력하세요."></textarea>
          </div>

         <input type="submit" value="등록" class="btn form-control">
          &nbsp;&nbsp;
          <a class="btn form-control"	href="<c:url value='/notice/list'/>"
		style="cursor: pointer; margin-top: 0; height: 40px; color: white; background-color: orange; border: 0px solid #388E3C; opacity: 0.8">취소</a>
        </form>



      </div>
  
