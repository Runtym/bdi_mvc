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
					<th>메이커명</th>
					<th>가격</th>
					<th>수량</th>
					<th>총액</th>
					<th>메이커설명</th>
				</tr>
			</thead>
			<tbody>
			<c:forEach	items="${list}" var="m">
				<tr>
					<td>${m.mnum}</td>
					<td><a href="/maker/makerView?mNum=${m.mnum}">${m.mname}</a></td>
					<td>${m.mprice}</td>
					<td>${m.mcnt}</td>
					<td>${m.mprice*m.mcnt}</td>
					<td>${m.mdesc}</td>
				</tr>
			</c:forEach>
			</tbody>	
		</table>
	</div>
</body>
</html>