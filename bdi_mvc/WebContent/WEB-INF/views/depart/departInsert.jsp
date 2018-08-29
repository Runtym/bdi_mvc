<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/common.jsp"%>
<c:if test="${!empty rMap}">
	<script>
		alert('${rMap.msg}');
		if(${rMap.cnt}==1){
			location.href="/depart/departList";
		}
	</script>
</c:if>
<body>
	<div class="container">
		<form action="/depart/departInsert" method="post">
			<table class="table table-bordered">
				<tr>
					<th>부서이름</th>
					<td><input type="text" name="diName"></td>
				</tr>
				<tr>
					<th>부서설명</th>
					<td><input type="text" name="diDesc"></td>
				</tr>
				<tr>
					<td colspan="2"><button>부서등록</button></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>