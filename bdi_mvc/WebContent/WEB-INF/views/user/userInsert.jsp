<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/common.jsp"%>
<body>
<div class="container">
	<table class="table table-bordered">
		<tr>
			<th>이름</th>
			<td><input type="text" id="name"></td>
		</tr>
		<tr>
			<th>나이</th>
			<td><input type="number" id="age"></td>
		</tr>
		<tr>
			<th colspan="2"><button onclick="insertDel()">등록</button><button onclick="goPage()">취소</button></th>
		</tr>
	</table>
</div>
<script>
	function insertDel(){
		var name = document.querySelector("#name").value;
		var age = document.querySelector("#age").value;
		location.href='/user/userInsert?name='+name + '&age='+ age;
	}
	function goPage(){
		location.href='/user/userList';
	}
	var cnt = '${cnt}';
	if(cnt==1){
		alert('등록이 잘 되었습니다.');
		goPage();
	}else if(cnt===0){
		alert('등록에 실패하였습니다.');
	}
</script>
</body>
</html>