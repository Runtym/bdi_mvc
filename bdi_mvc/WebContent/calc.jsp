<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/common.jsp"%>
<body>
번호1 : <input type="number" id="num1"><br>
연산자 : <select id="op">
		<option value="+">+</option>
		<option value="-">-</option>
		<option value="*">*</option>
		<option value="/">/</option>
</select><br>
번호2 : <input type="number" id="num2"><br>
결과 : <input type="number" id="result" disabled>
<button onclick="calc()">계산</button>
<script>
	function calc(){
		var num1 = document.querySelector('#num1').value;
		var num2 = document.querySelector('#num2').value;
		var op = document.querySelector('#op').value;
		
		var param = "num1=" + encodeURIComponent(num1) + "&op=" + encodeURIComponent(op) + "&num2=" + encodeURIComponent(num2);
		
		var xhr = new XMLHttpRequest();
		xhr.open('get','/result.jsp?' + param);
		xhr.onreadystatechange = function(){
			if(xhr.readyState==xhr.DONE){
				document.querySelector('#result').value = xhr.responseText;
			}
		}
		xhr.send();
	}
</script>
</body>
</html>