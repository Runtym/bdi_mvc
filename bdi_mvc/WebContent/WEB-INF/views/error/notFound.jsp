<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/common.jsp"%>
<body>
<c:if test="${empty msg}">
요청하신 주소는 올바르지 않은 주소 입니다.<br>
다시 확인하시기 바랍니다.
</c:if>
${msg}
<br>
<button onclick="history.back()">돌아가기</button>
</body>
</html>