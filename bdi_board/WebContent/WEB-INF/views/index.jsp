<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<body>
	안녕하세요, ${sessionScope.user.uiname}님.<br>
	<button data-page="/user/userLogout">로그아웃</button>