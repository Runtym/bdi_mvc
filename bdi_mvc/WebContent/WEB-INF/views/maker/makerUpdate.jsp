<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/common.jsp"%>
<c:if test="${!empty rMap}">
<script>
	alert('${rMap.msg}');
	if('${rMap.success}' == 'true'){
		location.href="/maker/makerList";
	}
</script>	
</c:if>
<body>
	<div class="container">
	<form action="/maker/makerUpdate" method="post">
		<table class="table table-bordered">
			<tr>
				<td>번호</td>
				<td>${maker.mnum}</td>
			</tr>
			<tr>
				<th>메이커명</th>
				<td><input type="text" name="mName" value="${maker.mname}"></td>
			</tr>
			<tr>
				<th>가격</th>
				<td><input type="number" name="mPrice" value="${maker.mprice}"></td>
			</tr>
			<tr>
				<th>수량</th>
				<td><input type="number" name="mCnt" value="${maker.mcnt}"></td>
			</tr>
			<tr>
				<th>상세 설명</th>
				<td><input type="text" name="mDesc" value="${maker.mdesc}"></td>
			</tr>
			<tr>
				<td colspan="2"><button>메이커수정</button></td>
			</tr>
		</table>
		<input type="hidden" type="number" name="mNum" value="${maker.mnum}">
	</form>
	</div>
</body>
</html>