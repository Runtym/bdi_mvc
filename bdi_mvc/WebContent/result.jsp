<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%
int num1 = Integer.parseInt(request.getParameter("num1"));
int num2 = Integer.parseInt(request.getParameter("num2"));
String op = request.getParameter("op");
System.out.println(op);

if(op.equals("+")){
	out.print(num1+num2);
}else if(op.equals("-")){
	out.print(num1-num2);
}else if(op.equals("*")){
	out.print(num1*num2);
}else if(op.equals("/")){
	out.print(num1/num2);
}
%>