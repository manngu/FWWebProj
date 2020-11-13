<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>취소/교환/환불페이지</title>
</head>
<body>

<h1>취소/교환/환불 처리 페이지</h1>

<a href="<c:url value='/admin/orders'/>">주문관리 메인 페이지로</a> <br>

<form action="<c:url value='/admin/orders/problems'/>" method="get">
<select id="sort" name="sort" onchange="formChange(this.form)">
	<option value="cancel" ${sort==cancel?'selected':''}>취소요청</option>
	<option value="change" ${sort==change?'selected':''}>교환요청</option>
	<option value="refund" ${sort==refund?'selected':''}>환불요청</option>
</select>
</form>


<table border="1" style="border-collapse:collapse;">
<tr>
<td>주문번호</td> <td>주문상세번호</td> <td>상품번호</td> <td>옵션번호</td> <td>주문수량</td> <td>주문상태</td> <td>배송상태</td> <td>승인</td> <td>거부</td></tr> 


<c:forEach var="od" items="${list}">
<tr>
<td>${od.orderId}</td>
<td>${od.orderDetailNo}</td>
<td>${od.gdsNo}</td>
<td>${od.optionNo}</td>
<td>${od.orderStock}</td>
<td>${od.orderStatus}</td>
<td>${od.deliveryStatus}</td>
<td><a href="<c:url value='/admin/orders/problems/admit/${od.orderDetailNo}'/>">승인</a></td>
<td><a href="<c:url value='/admin/orders/problems/reject/${od.orderDetailNo}'/>">거부</a></td>
</tr>

</c:forEach>


</table>

			<!-- 페이징 처리 부분  -->

					<!-- 이전버튼 -->
					<c:if test="${pc.prev}">
						<a href="<c:url value='/admin/orders/problems${pc.makeURI(pc.beginPage-1)}'/>">이전</a> 
					</c:if>


					<!-- 페이지 버튼 -->
					<c:forEach var="pageNum" begin="${pc.beginPage}" end="${pc.endPage}">
						<a href="<c:url value='/admin/orders/problems${pc.makeURI(pageNum)}'/>"
							style="${(pc.paging.page == pageNum) ? 'font-weight:bold' : '' }">${pageNum}</a>
					</c:forEach>

					<!-- 다음 버튼 -->
					<c:if test="${pc.next}">
						<a href="<c:url value='/admin/orders/problems${pc.makeURI(pc.endPage+1)}'/>">다음</a>
					</c:if>

			<!-- 페이징 처리 끝 -->




<script type="text/javascript" src="https://code.jquery.com/jquery-3.1.1.min.js" > </script>
<script>
function formChange(obj)
{
	obj.submit();
}




</script>






</body>
</html>