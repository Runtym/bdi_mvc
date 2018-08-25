<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/common.jsp"%>
<body>
	<div class="container">
		<h4>메이커리스트</h4>
		<table class="table table-bordered table-hover">
			<thead>
				<tr>
					<th>번호</th>
					<th>사원명</th>
					<th>사원아이디</th>
					<th>사원설명</th>
					<th>사원나이</th>
					<th>부서번호</th>
				</tr>
			</thead>
			<tbody>
			<c:forEach	items="${list}" var="u">
				<tr>
					<td>${u.uiNo}</td>
					<td><a href="/maker/makerView?mNum=${u.uiNo}">${u.uiName}</a></td>
					<td>${u.uiId}</td>
					<td>${u.uiDesc}</td>
					<td>${u.uiAge}</td>
					<td>${u.diNo}</td>
				</tr>
			</c:forEach>
			</tbody>	
		</table>
		<div>
			<button onclick="goPage()">메이커등록</button>
			
		</div> 
	</div>
<script>
	function goPage(){
		location.href='/views/maker/makerInsert';
	}
</script>
</body>
</html>