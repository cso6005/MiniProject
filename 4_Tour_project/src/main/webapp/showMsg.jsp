<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src='https://kit.fontawesome.com/a076d05399.js'
	crossorigin='anonymous'></script>
<title>메시지 화면</title>
</head>

<body>
<br><br><br>
	<center>
		<h3>${requestScope.msg}</h3>
		<br>
		<br>
		<br> <a href="${pageContext.request.contextPath}/main.html"
			class='fas fa-home'>Home</a>
	</center>
</body>
</html>