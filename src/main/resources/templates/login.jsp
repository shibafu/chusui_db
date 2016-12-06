<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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