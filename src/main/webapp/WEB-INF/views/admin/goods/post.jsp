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


    <h1>상품등록 페이지</h1>
    
    <a href="<c:url value='/admin/goods'/>">목록으로</a>   <br><br>
    
    <form action="<c:url value='/admin/goods/post'/>" method="post" enctype="multipart/form-data">
    상품타입:
    <input type="radio" name="gdsType" checked="checked" value="1"> 일반상품
    <input type="radio" name="gdsType" value="2"> 특가상품 <br>


카테고리:<br>
대분류 &nbsp; &nbsp; &nbsp; &nbsp;&nbsp;소분류 <br>

<select name="cateRef" id="cateRef">
	<option value="">==선택==</option>
	<c:forEach var="sup" items="${sup}">
	<option value="${sup.cateNo}">${sup.cateName}</option>
	</c:forEach>
</select>
  
    

 <select name="cateNo" id="cateNo">
	
 	<option>==선택==</option>
 	<c:forEach var="sub" items="${sub}">
   		<option value="${sub.cateNo}">${sub.cateName}</option>
   	</c:forEach>
</select>   <br> 
  
  상품명: <input type="text" name="gdsName"> <br>
  마감일: <input type="text" name="gdsDday" value="2100-12-31 12:00:00"> <br>
 제한수량: <input type="number" name="gdsLimit"> <br>
 가격: <input type="number" name="gdsPrice"> <br>
 할인율: <input type="number" name="gdsDiscount" step="0.1"><br>
 공개여부:
    <input type="radio" name="gdsStatus" value="0"> 공개
    <input type="radio" name="gdsStatus" value="1"> 비공개 <br>
 
 썸네일: <input type="file" name="thumb"> <br>

상세사진: <input type="file" name="des"> <br>




    
    <br><br>
    옵션 <br>
    <button name="add" type="button">추가</button>
   
	옵션은 최소 하나 이상 등록해야 합니다. 기본 상품을 하나의 옵션으로 취급해주세요.
    <table border="1" style="border-collapse:collapse;">
        <tr>
            <th>옵션명</th>
            <th>추가금액</th>
            <th>재고수량</th>
        </tr>
        <tr class="OptData">
            <td><input type="text" name="optionName[]"></td>
            <td><input type="number" name="optionAddPrice[]"></td>
            <td><input type="number" name="optionCount[]"></td>
        </tr>
    </table> <br><br>


	<input type="submit" name="submit" value="상품등록">
	</form>

</body>




<script>

//추가 버튼
  $(document).on("click","button[name=add]",function(){
        
        var addOpt =     '<tr class="OptData">'+
            '    <td><input type="text" name="optionName[]"></td>'+
            '    <td><input type="number" name="optionAddPrice[]"></td>'+
            '    <td><input type="number" name="optionCount[]"></td>'+
            '    <td><button class="btn btn-default" name="del">삭제</button></td>'+
            '</tr>';
            
        var trHtml = $( "tr[class=OptData]:last" ); //last를 사용하여 trStaff라는 명을 가진 마지막 태그 호출
        trHtml.after(addOpt); //마지막 trStaff명 뒤에 붙인다.
        
    });
    
    //삭제 버튼
    $(document).on("click","button[name=del]",function(){
        
        var trHtml = $(this).parent().parent();      
        trHtml.remove(); //tr 테그 삭제
        
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
    

    $("#cateRef").change(function(){
    	var c = $(this).val();
    	console.log(typeof c);
    	console.log(c);
    	
    	var target = $("#cateNo");
    	//target.empty();
    	
    	if(c == "") {
    		target.append("<option>==선택==</option>");
    	}
    	
    	$.ajax({
    		type: "post",
    		url: "/admin/goods/getsub",
    		data: {"c":c},
    		success:function(sub){
    			if(sub!=null){
    				alert("성공");
    			}else{
    				alert("실패!");
    			}
    		
/*     			if(sub.length==0){
    				target.append("<option>==선택==</option>");
    			}else{
    				$(sub).each(function(i){
    					target.append("<option value='"+sub[i].cateNo+"'>"+sub[i].cateName+"</option>");
    				});
    			}*/
    		}, error:function(xhr){
    			console.log(xhr.responseText);
    			alert("지금은 시스템 사정으로 요청하신 작업을 처리할 수 없습니다.");
    			return;
    		}
    		 
    	});
    	
    	
    });
/*     function fnChange(c){
    	console.log(c);
    	var $target = $("#cateNo");
    	$target.empty();
    	
    	if(c == ""){
    		$target.append("<option>==선택==</option>");
    	}
    	
    	$.ajax({
    		type: "post",
    		url: "/admin/goods/getsub",
    		async: false,
    		data: { chocie : c },
    		dataType: "json",
    		success:function(sub){
    			if(sub.length==0){
    				$target.append("<option>==선택==</option>");
    			}else{
    				$(sub).each(function(i){
    					$target.append("<option value="""+sub[i].cateNo+""">"+sub[i].cateName+"</option>");
    				});
    			}
    		}, error:function(xhr){
    			console.log(xhr.responseText);
    			alert("지금은 시스템 사정으로 요청하신 작업을 처리할 수 없습니다.");
    			return;
    		}
    	});
    } */
    		

    
    

    

    
    
</script>




</html>
