<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/common.jsp"%>
<body>
	<form action="/file/file" method="post" enctype="multipart/form-data">
		이미지 : <input type="file" name="gcImg"><br>
		이미지 : <input type="file" name="gcImg"><br>
		이미지 : <input type="file" name="gcImg"><br>
		이미지 : <input type="file" name="gcImg"><br>
		<button>파일 업로드</button>
	</form>
</body>
</html>