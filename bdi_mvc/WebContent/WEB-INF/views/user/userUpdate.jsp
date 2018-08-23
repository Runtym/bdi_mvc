<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/common.jsp"%>
<body>
<div class="container">
	<table class="table table-bordered">
		<tr>
			<th>번호</th>
			<td>${user.num}</td>
		</tr>
		<tr>
			<th>이름</th>
			<td><input type="text" id="name" value="${user.name}"></td>
		</tr>
		<tr>
			<th>나이</th>
			<td><input type="number" id="age" value="${user.age}"></td>
		</tr>
		<tr>
			<th colspan="2"><button onclick="updateDel()">수정</button><button onclick="goPage()">취소</button></th>
		</tr>
	</table>
</div>
<script>
	function updateDel(){
		var name = document.querySelector("#name").value;
		var age = document.querySelector("#age").value;
		location.href='/user/userUpdate?num=${user.num}&name='+name + '&age='+ age;
	}
	function goPage(){
		location.href='/user/userList';
	}
	var cnt = '${cnt}';
	if(cnt==1){
		alert('수정이 잘 되었습니다.');
		goPage();
	}else if(cnt===0){
		alert('수정에 실패하였습니다.');
	}
</script>
</body>
</html>