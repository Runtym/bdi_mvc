<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<body>
	<div class="container">
		<table class="table table-bordered table-hover">
			<thead>
				<tr>
					<th>번호</th>
					<th>제목</th>
					<th>게시일</th>
					<th>조회수</th>
					<th>게시자</th>
				</tr>
			</thead>
			<tbody>
			<c:if test="${empty biList}">
				<tr>
					<td colspan="5">게시물이 없습니다.</td>
				</tr>
			</c:if>
			<c:forEach items="${biList}" var="bi">
				<tr>
					<td>${bi.binum}</td>
					<td>${bi.bititle}</td>
					<td>${bi.bicredat}</td>
					<td>${bi.bicnt}</td>
					<td>${bi.uinum}</td>
				</tr>
			</c:forEach>
			</tbody>
		</table>
		<div class="btns">
			<button data-page="/views/board/boardInsert">글쓰기</button>
		</div>
	</div>
	