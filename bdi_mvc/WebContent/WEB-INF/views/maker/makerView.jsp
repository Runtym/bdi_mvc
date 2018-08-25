<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/common.jsp"%>
<body>
	<div class="container">
		<table class="table table-bordered">
			<tr>
				<th>메이커명</th>
				<td>${maker.mname}</td>
			</tr>
			<tr>
				<th>가격</th>
				<td>${maker.mprice}</td>
			</tr>
			<tr>
				<th>수량</th>
				<td>${maker.mcnt}</td>
			</tr>
			<tr>
				<th>총액</th>
				<td>${maker.mtotal}</td>
			</tr>
			<tr>
				<th>상세 설명</th>
				<td>${maker.mdesc}</td>
			</tr>
			<tr>
				<td colspan="2" style="text-align:center"> 
					<button data-page='/maker/makerList' >리스트가기</button>
					<button data-page='/maker/makerUpdate?mNum=${maker.mnum}'>메이커수정</button>
				</td>
			</tr>
		</table>
	</div>

</body>
</html>