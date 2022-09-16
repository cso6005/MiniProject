<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" href="css/stylesign.css">
	<script src='https://kit.fontawesome.com/a076d05399.js' crossorigin='anonymous'></script>
<title>투어 예약 화면</title>
</head>

<body>
<br><br><br><hr><p>
<h3>투어 여행 예약</h3>
<hr><br>

  <form action="tour" method="post">
  <input type="hidden" name="command" value="reservation">
  
    <label for="id">예약 아이디</label><br>
    <input type="text" name="userId" placeholder="Your id.." ><br>

    <label for="pw">예약 비밀번호</label><br>
    <input type="password" name="userPw" placeholder="Your password.."><br>

    <label for="name">고객 명</label><br>
    <input type="text" name="userName" placeholder="Your name.."><br>

    <label for="code">투어 코드</label><br>
    <input type="text" name="travelId" placeholder="Your hope tour code.." value="${requestScope.travelId}" readonly><br>

    <input type="submit" value="가입">&nbsp;&nbsp;&nbsp;<input type="reset" value="취소">
  </form>
  
<br><br><hr><br>
<a href="${pageContext.request.contextPath}/main.html" class='fas fa-home'>Home</a>

</body>
</html>