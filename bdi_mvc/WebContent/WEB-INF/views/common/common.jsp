<%@page import="java.util.HashMap"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!doctype html>
<html>
<head>
	<meta charset="utf-8">
	<title>빅데이터MVC</title>
<link rel="stylesheet" href="/bs3/css/bootstrap.css"/>
<link rel="stylesheet" href="/bs3/css/bootstrap-theme.css"/>
<script src="/bs3/js/jquery-3.3.1.js"></script>
<script src="/bs3/js/bootstrap.js"></script>
</head>
<script>
	window.onload = function(){
		var btns = document.querySelectorAll('button[data-page]');
		for(var i=0;i<btns.length;i++){
			btns[i].setAttribute('type','button');
			btns[i].onclick = function(){
				location.href= this.getAttribute('data-page')
			}
		}
	}	
</script>