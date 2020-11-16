<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 등록 페이지</title>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
</head>
<body>


 
    옵션 <br>
    <button id="add">추가</button>
   
	옵션은 최소 하나 이상 등록해야 합니다. 기본 상품을 하나의 옵션으로 취급해주세요.
    <table border="1" style="border-collapse:collapse;">
        <tr>
            <th>옵션명</th>
            <th>추가금액</th>
            <th>재고수량</th>
        </tr>
        <tr name="OptData">
            <td><input type="text" name="optionName"></td>
            <td><input type="number" name="optionAddPrice"></td>
            <td><input type="number" name="optionCount"></td>
        </tr>
    </table> <br><br>



	<input type="submit" value="상품등록">

</body>




<script>

<script>
//추가 버튼
$(function(){
	$("#add").click(function(){
	    var addText = '<tr name="OptData">'
        	+'<td><strong>정산담당자</strong></td>'
        	+'<td><input type="text" name="optionName"></td>'
        	+'<td><input type="number" name="optionAddPrice"></td>'+
        	+'<td><input type="number" name="optionCount"></td>'+
        	+'<td><button id="del">삭제</button></td>'
        	+'</tr>';
       
    var trHtml = $( "tr[name=optData]:last" ); //last를 사용하여 optData라는 명을 가진 마지막 태그 호출
    trHtml.after(addText); //마지막 OptData 뒤에 붙인다. 
	});
	
	$("#del").click(function(){
		 var trHtml = $(this).parent().parent();
		    trHtml.remove(); //tr 테그 삭제
	});

	
});

</script>





</html>