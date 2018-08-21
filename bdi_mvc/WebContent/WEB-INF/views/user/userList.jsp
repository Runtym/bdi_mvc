<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/common.jsp"%>
<style>
	tr>th{
		text-align:center;
	}
	tr>td{
		text-align:center;
		cursor:pointer;
	}
</style>
<body>
	유저리스트<br>
	<div class="container">
		<table class="table table-bordered table-hover">
			<thead>
				<tr>
					<th><input type="checkbox" id="allChk"></th>
					<th>번호</th> 
					<th>이름</th> 
					<th>나이</th>
				</tr>
			</thead>
			<tbody>
<%
List<Map<String,String>> list = (List<Map<String,String>>)request.getAttribute("list");
for(Map<String,String>map : list){
%>
				<tr onclick="goPage(event,<%=map.get("num")%>)">
					<td><input type="checkbox" name="delChk" value="<%=map.get("num")%>"></td>
					<td><%=map.get("num")%></td>
					<td><%=map.get("name")%></td>
					<td><%=map.get("age")%></td>
				</tr>
<%
}
%>
			</tbody>
		</table>
		<button onclick="deleteDel()">삭제하기</button>
		<button onclick="move()">데이터등록</button>
	</div>
<script>
	function move(){
		location.href="/views/user/userInsert";
	}
	function goPage(e,num){
		if(e.target.type==='checkbox'){
			return;
		}
		if(e.target.firstChild.type==='checkbox'){
			return;
		}
		location.href = "/user/userView?num=" + num;
	}
	function deleteDel(){
		var chks = document.querySelectorAll('input[name=delChk]:checked');
		if(chks.length==0){
			alert('삭제할 데이터를 선택해주세요.');
			return;
		}
		var param = '?';
		for(var i=0;i<chks.length;i++){
			param += 'num=' + chks[i].value + '&';
		}
		location.href= '/user/userDelete' + param;
	}
</script>
</body>
</html>