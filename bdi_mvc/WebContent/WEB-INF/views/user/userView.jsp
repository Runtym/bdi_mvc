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
				<td>${user.name}</td>				
			</tr>
			<tr>
				<th>나이</th>
				<td>${user.age}</td>				
			</tr>
		</table>
		<div>
			<button onclick="goPage()">리스트 이동</button>
			<button onclick="goUpdate()">수정</button>
		</div>
	</div>
<script>
	function goPage(){
		location.href="/user/userList";
	}
	function goUpdate(){
		location.href="/user/userUpdate?num=${user.num}";
	}
</script>
</body>
</html>