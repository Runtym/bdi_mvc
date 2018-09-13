<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<style>
	.page{
		text-align:center;
	}
</style>    
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
					<td><a href="/board/boardView?binum=${bi.binum}">${bi.bititle}</a></td>
					<td>${bi.bicredat}</td>
					<td>${bi.bicnt}</td>
					<td>${bi.uiname}</td>
				</tr>
			</c:forEach>
			</tbody>
		</table>
		<div class="page">
		<c:if test="${pi.sBlock !=1 }">
			<a href="/board/boardList?pi.page=${pi.eBlock-pi.blockCnt}"> << </a>
		</c:if>
		<c:forEach begin="${pi.sBlock}" end="${pi.eBlock}" var="i">
			<c:if test="${i eq pi.page}">
				<b>[ ${i} ]</b>
			</c:if>
			<c:if test="${i ne pi.page}">
				<a href="/board/boardList?pi.page=${i}">[ ${i} ]</a>
			</c:if>
		</c:forEach>
		<c:if test="${pi.eBlock <pi.totalPage }">
			<a href="/board/boardList?pi.page=${pi.eBlock+1}"> >> </a>
		</c:if>
		</div>
		<div class="btns">
			<button data-page="/views/board/boardInsert">글쓰기</button>
		</div>
	</div>
	