<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- 포맷팅 관련 태그라이브러리(JSTL/fmt) --%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>



<br><br> 
 
    <!-- Begin Page Content -->
<h2>notice 게시판</h2>	

	<style>
	#container_box table td { width:100px; }
	</style>

	<table class="table table-bordered table-hover">
		<thead>
			<tr>
				<th>제목</th>
			</tr>
		</thead>
				
		<c:if test="${notice.size() <= 0}">
			<tr>
				<td colspan="5" align="center">
					<strong>검색 결과가 없습니다!!</strong>
				</td>
			</tr>
		</c:if>

		<!-- 게시물이 들어갈 공간 -->
		
		<c:if test="${notice.size() > 0}">
		
		<tbody>
		<c:forEach var="b" items="${notice}" >
			<tr>
				<td>
					<a href="<c:url value='/notice/content/${b.noticeNo}?page=${pc.paging.page}&countPerPage=${pc.paging.countPerPage}' />">
				${b.noticeTitle}
					</a>
				</td>
			</tr>
		</c:forEach>
		</tbody>
		</c:if>
	</table>

					
					<!-- 페이징 처리 부분  -->
					<ul class="pagination justify-content-center">
                       	<!-- 이전 버튼 -->
                       	<c:if test="${pc.prev}">
	                       	<li class="page-item">
								<a class="page-link" href="<c:url value='/notice/list${pc.makeURI(pc.beginPage - 1)}' />" 
								style="background-color: #ff52a0; margin-top: 0; height: 40px; color: white; border: 0px solid #f78f24; opacity: 0.8">이전</a>
							</li>
						</c:if>
						
						<!-- 페이지 버튼 -->
						<c:forEach var="pageNum" begin="${pc.beginPage}" end="${pc.endPage}">
							<li class="page-item">
							   <a href="<c:url value='/notice/list${pc.makeURI(pageNum)}'/>" class="page-link ${(pc.paging.page == pageNum) ? 'page-active' : ''}" style="margin-top: 0; height: 40px; color: pink; border: 1px solid pink;">${pageNum}</a>
							</li>
					    </c:forEach>
					    
					    <!-- 다음 버튼 -->
					    <c:if test="${pc.next}">
						    <li class="page-item">
						      <a class="page-link" href="<c:url value='/notice/list${pc.makeURI(pc.endPage + 1)}' />" 
						      style="background-color: #ff52a0; margin-top: 0; height: 40px; color: white; border: 0px solid #f78f24; opacity: 0.8">다음</a>
						    </li>
					    </c:if>
				    </ul>
					<!-- 페이징 처리 끝 -->
					</div>
				</div>
			</div>
					<!-- 검색 버튼 -->
					<div class="row">
						<div class="col-sm-2"></div>
	                    <div class="form-group col-sm-2">
	                        <select id="condition" class="form-control" name="condition">                            	
	                            <option value="title" ${param.condition == 'noticeTitle' ? 'selected' : ''}>제목</option>
	                            <option value="content" ${param.condition == 'noticeContent' ? 'selected' : ''}>내용</option>
	                            <option value="titleContent" ${param.condition == 'noticeTitleContent' ? 'selected' : ''}>제목+내용</option>
	                        </select>
	                    </div>
	                    <div class="form-group col-sm-4">
	                        <div class="input-group">
	                            <input type="text" class="form-control" name="keyword" value="${param.keyword}" id="keywordInput" placeholder="검색어">
	                            <span class="input-group-btn">
	                                <input type="button" value="검색" class="btn btn-flat" id="searchBtn">                                       
	                            </span>
	                        </div>
	                    </div>
	                    <div class="col-sm-2">
							<a href="<c:url value='/notice/write'/>" class="btn float-right">글쓰기</a>
						</div>
						<div class="col-sm-2"></div>
					</div>
					
		
	</div>

<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js">


	//글쓰기 완료 시 띄울 알림창 처리
	const result = "${msg}";
	
	if(result === "regSuccess") {
		alert("게시글 등록이 완료되었습니다.");
	} else if(result === "delSuccess") {
		alert("게시글 삭제가 완료되었습니다.");
	}
	
	
	//start jQuery
	$(function() {
		
		//목록 개수가 변동하는 이벤트 처리
		$("#count-per-page .btn").click(function() {
			//console.log("목록 버튼이 클릭됨!");
			//console.log($(this).val());
			let count = $(this).val();
			const keyword = "${param.keyword}";
			const condition = "${param.condition}";
			location.href="/notice/list?page=1&countPerPage=" + count 
							+ "&keyword=" + keyword
							+ "&condition=" + condition;
		});
		
		//검색 버튼 이벤트 처리
		$("#searchBtn").click(function() {
			console.log("검색 버튼이 클릭됨!");
			const keyword = $("#keywordInput").val();
			console.log("검색어: " + keyword);
			
			const condition = $("#condition option:selected").val();
			console.log("검색 조건: " + condition);
			
			location.href="/notice/list?keyword="+keyword
					+"&condition=" + condition;
			
		});
		
		
		//엔터키 입력 이벤트
		$("#keywordInput").keydown(function (key) {
			 
	        if(key.keyCode == 13){//키가 13이면 실행 (엔터는 13)
	        	$("#searchBtn").click();
	        }
	 
	    });
		
		
	});//end jQuery

</script>










