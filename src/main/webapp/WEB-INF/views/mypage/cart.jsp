<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>장바구니 페이지</title>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
</head>
<body>
<h1>장바구니</h1>



<form>
	<table>
	
	<tr>
		<td>선택</td>
		<td>번호</td>
		<td>상품이름</td>
		<td>옵션이름</td>
		<td>상품수량</td>
		<td>상품가격</td>
		<td>옵션추가가격</td>
		<td>총가격</td>
	</tr>
	
	<c:forEach var="c" items="${list}" varStatus="st">
		<tr>
			<td><input type="checkbox" name="check" value="${c.cartNo}"></td>
			<td>${st.count}</td>
			<td>${c.gdsName}</td>
			<td>${c.optionName}</td>
			<td align="center">${c.cartStock}</td>
			<td>${c.gdsPrice}</td><td>${c.optionAddPrice}</td>
			<td class="price">${c.cartStock*c.gdsPrice+c.optionAddPrice}</td>
		</tr>
	</c:forEach>
	</table> <br>
	--------------------------------------------------------<br>
	합산: 
	<input type="number" id="s" readonly>
	
	 <br>
	
	<input type="button" name="delete" id="delete" value="삭제">
	<input type="button" name="pay" id="pay" value="결제하기">

</form>



<script>

var sum = 0; //전역변수: 체크박스 체크 시 더해지고, 결제할 때 배열에 붙어서 갈 것임.



//체크된 목록 삭제
$(document).on("click","input[name=delete]",function(){
	
	var confirm_val = confirm("정말 삭제하시겠습니까?");
	

	if(confirm_val){
		var checkArr = new Array();
		for(var i=0; i<$('input:checkbox:checked').length;i++){
			var item = parseInt($("input:checkbox[name='check']:checked:eq("+i+")").val());
			console.log(item);
			checkArr.push(item);
			
			
		}
	
		console.log(checkArr);

		$.ajax({
			url : "/mypage/carts/delete",
			type : "post",
			data : {check : checkArr},
			success : function(result){
				if(result == 1) {												
					location.href = "/shopping/mypage/carts";
				} else {
					alert("삭제 실패");
				}
			}
		});
	}
});

//체크된 목록 결제 api로 넘기기(전에 처리해주기)
$(document).on("click","input[name=pay]",function(){
	
	var confirm_val = confirm("결제하시겠습니까?");
	
	if(confirm_val){

		var checkArr = new Array();
		for(var i=0; i<$('input:checkbox:checked').length;i++){
			var item = parseInt($("input:checkbox[name='check']:checked:eq("+i+")").val());
			checkArr.push(item);
		}
		
		checkArr.push(sum); //마지막값은 체크된 값의 합
		console.log(checkArr);
	
		$.ajax({
			url : "/shopping/mypage/carts/pay",
			type : "post",
			data : {check : checkArr},
			success : function(result){
				if(result == 1) {
					//console.log(checkArr);
					location.href = "/shopping/mypage/carts/orderinfo";
				} else {
					alert("삭제 실패");
				}
			}
		});
	}
});



//체크박스 체크시!
$(document).on("change","input[name=check]",function(){
		if($(this).is(":checked")){
			//alert("체크박스 체크!");
			console.log($(this).parent().parent().find(".price").text());
			sum = sum + parseInt($(this).parent().parent().find(".price").text());
			console.log(sum);
			$("#s").val(sum);
		}else{
			//alert("체크박스 해제!");
			sum = sum - parseInt($(this).parent().parent().find(".price").text());
			console.log(sum);
			$("#s").val(sum);
		}
});		


</script>







</body>
</html>