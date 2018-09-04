<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/common.jsp"%>
<body>
	<form action="/upload" method="post" enctype="multipart/form-data">
		파일 : <input type="file" name="upFile"><br>
		업로더 : <input type="text" name="upName"><br>
		<button>파일전송</button>
	</form>
</body>
</html>