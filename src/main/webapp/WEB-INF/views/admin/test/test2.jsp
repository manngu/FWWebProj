<!doctype html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <title>last demo</title>
  <script src="https://code.jquery.com/jquery-1.10.2.js"></script>
</head>
<body>
    <button name="addStaff">정산담당자 추가</button>
    <br>
    <br>
    <table border="1" style="width:950px">
        <tbody>
            <tr name="trStaff">
                <td style="width:150px"><strong>정산담당자</strong></td>
                <td style="width:800px">
                    <input type="text" name="staff_name" placeholder="성명">
                    <input type="text" name="staff_contact" placeholder="연락처1">
                    <input type="text" name="staff_contact2" placeholder="연락처2">
                    <input type="text" name="staff_email" placeholder="이메일">
                    <select name="staff_use_yn">
                        <option value="Y">사용</option>
                        <option value="N">미사용</option>
                    </select>
                </td>
            </tr>
            <tr>
                <td><strong>메모</strong></td>
                <td>
                    <textarea style="width:800px" name="memo" rows="3" placeholder="메모를 남겨주세요."></textarea>
                </td>
            </tr>
        </tbody>
    </table>
 
<script>
    //추가 버튼
    $(document).on("click","button[name=addStaff]",function(){
        
        var addStaffText =     '<tr name="trStaff">'+
            '    <td class="active col-md-1"><strong>정산담당자</strong></td>'+
            '    <td class="col-md-11">'+
            '        <input type="text" class="form-control" name="staff_name" placeholder="성명">'+
            '        <input type="text" class="form-control" name="staff_contact" placeholder="연락처1">'+
            '        <input type="text" class="form-control" name="staff_contact2" placeholder="연락처2">'+
            '        <input type="text" class="form-control" name="staff_email" placeholder="이메일">'+
            '        <select class="form-control statusYn" name="staff_use_yn">'+
            '            <option value="Y">사용</option>'+
            '            <option value="N">미사용</option>'+
            '        </select>'+
            '        <button class="btn btn-default" name="delStaff">삭제</button>'+
            '    </td>'+
            '</tr>';
            
        var trHtml = $( "tr[name=trStaff]:last" ); //last를 사용하여 trStaff라는 명을 가진 마지막 태그 호출
        
        trHtml.after(addStaffText); //마지막 trStaff명 뒤에 붙인다.
        
    });
    
    //삭제 버튼
    $(document).on("click","button[name=delStaff]",function(){
        
        var trHtml = $(this).parent().parent();
        
        trHtml.remove(); //tr 테그 삭제
        
    });
</script>
 
</body>
</html>
