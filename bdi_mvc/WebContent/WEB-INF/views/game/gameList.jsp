<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/common.jsp"%>
<body>
<div class="container">
	<table class="table table-bordered table-hover">
		<thead>
			<tr>
				<th>번호</th>
				<th>게임명</th>
				<th>가격</th>
				<th>배급사</th>
				<th>게임순위</th>
				<th>게임이미지</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${gameList}" var="game">
			<tr>
				<td>${game.gcNum}</td>
				<td><a href="/game/gameView?gcNum=${game.gcNum}">${game.gcName}</a></td>
				<td>${game.gcPrice}</td>
				<td>${game.gcVendor}</td>
				<td>${game.gcOrder}</td>
				<td>
					<c:if test="${!empty game.gcImg}">
						<img src="${game.gcImg}" width="50" height="50">
					</c:if>	
				</td>
			</tr>
		</c:forEach>		
		</tbody>
	</table>
	<div>
		<button data-page="/views/game/gameInsert">게임등록</button>
	</div>
</div>
</body>
</html>