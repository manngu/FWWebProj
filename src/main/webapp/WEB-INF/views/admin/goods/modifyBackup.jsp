<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 수정 페이지</title>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
</head>
<body>
<h1>상품 수정 페이지</h1>

    <form action="<c:url value='/admin/goods/modify'/>" method="post" enctype="multipart/form-data">
    
    <input type="hidden" name="gdsNo" value="${gds.gdsNo}">
    
    상품타입:
    <input type="radio" name="gdsType" value="1"
    	${gds.gdsType==1?'checked':''}> 일반상품
    <input type="radio" name="gdsType" value="2"
    	${gds.gdsType==2?'checked':''}> 특가상품 <br>


카테고리:<br>
대분류 &nbsp; &nbsp; &nbsp; &nbsp;&nbsp;소분류 <br>

<select name="cateRef" id="cateRef">
	<option value="">==선택==</option>
	<c:forEach var="sup" items="${sup}">
	<option value="${sup.cateNo}" ${gds.cateNo==sup.cateNo?'selected':''}>
		${sup.cateName}</option>
	</c:forEach>
</select>
  
    

 <select name="cateNo" id="cateNo">
	
 	<option>==선택==</option>
 	<c:forEach var="sub" items="${sub}">
   		<option value="${sub.cateNo}" ${gds.cateNo==sub.cateNo?'selected':''}>${sub.cateName}</option>
   	</c:forEach>
</select>   <br> 
  
  상품명: <input type="text" name="gdsName" value="${gds.gdsName}"> <br>
  마감일: <input type="text" name="gdsDday" value="${gds.gdsDday}"> <br>
 제한수량: <input type="number" name="gdsLimit" value="${gds.gdsLimit}"> <br>
 가격: <input type="number" name="gdsPrice" value="${gds.gdsPrice}"> <br>
 할인율: <input type="number" name="gdsDiscount" step="0.1" value="${gds.gdsDiscount}"><br>
 공개여부:
    <input type="radio" name="gdsStatus" value="0"> 공개
    <input type="radio" name="gdsStatus" value="1"> 비공개 <br>
 
 썸네일: <br>
  <img src="${pageContext.request.contextPath}${gds.gdsThumbImg}" style="width:150px"> <br>
 
 <button id="modThumb" type="button">수정?</button>
 <div id="divThumb" style="display:none">
 <input type="file" name="thumb" id="thumb" value="${gds.gdsThumbImg}" disabled="disabled"> <br>
 <input type="hidden" id="gdsThumbImg" name="gdsThumbImg" value="${gds.gdsThumbImg}">
 </div>
 <br><br>
상세사진:<br>
 <img src="${pageContext.request.contextPath}${gds.gdsDes}" style="width:150px"> <br>


<button id="modDes" type="button">수정?</button>
<div id="divDes" style="display:none">
<input type="file" name="des" id="des" value="${gds.gdsDes}" disabled="disabled"> <br>
 <input type="hidden" id="gdsDes" name="gdsDes" value="${gds.gdsThumbImg}">
</div>



    
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
        
        <c:forEach var="opt" items="${opt}">
        	<tr class="OptData">
            <td><input type="text" name="optionName[]" value="${opt.optionName}"></td>
            <td><input type="number" name="optionAddPrice[]" value="${opt.optionAddPrice}"></td>
            <td><input type="number" name="optionCount[]" value="${opt.optionCount}"></td>
            </tr>
        </c:forEach>
        
    </table> <br><br>


	<input type="submit" name="submit" value="상품등록">
	</form>

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
  
  var check = 0;
  var check2 = 0;
  //파일 수정 시 이벤트
  $("#modThumb").click(function(){
	  if(check==0){ //수정할거임
		  $("#divThumb").show();
		  $("#thumb").attr("disabled",false);
		  $("#gdsThumbImg").attr("disabled",true);
		  check++;
	  }else if(check==1){
		  $("#divThumb").hide();
		  $("#thumb").attr("disabled",true);
		  $("#gdsThumbImg").attr("disabled",false);
		  check--;		  
	  }
  });
  
  
  $("#modDes").click(function(){
	  if(check2==0){//수정할거임
		$("#divDes").show();
		$("#des").attr("disabled",false);
	  	$("#gdsDes").attr("disabled",true);
	  	check2++;
	  }else if(check2==1){
		$("#divDes").hide();
		$("#des").attr("disabled",true);
	  	$("#gdsDes").attr("disabled",false);
	  	check2--;
	  }
  });
	  
	  

</script>
</body>
</html>