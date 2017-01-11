<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>

<html>

<head>
<title>Good Thymes Virtual Grocery</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link rel="stylesheet" type="text/css" media="all"
	href="../../css/gtvg.css" th:href="@{/css/gtvg.css}" />
</head>

<body>
	<div th:with="welcome='Welcom to our Thymeleaf!'">
		<p th:text="'ようこそ! ' + ${loginName} + ' さん'"></p>
	</div>
	<br/>
    <p th:text="${today}"></p>
</body>

</html>