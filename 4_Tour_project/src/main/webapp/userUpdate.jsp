<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<script src='https://kit.fontawesome.com/a076d05399.js' crossorigin='anonymous'></script>
	<link rel="stylesheet" href="css/stylesign.css">
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>예약 정보 수정화면</title>

</head>

<body>
<br><br><br><hr><p>
<h3>예약 정보 변경 - 투어 변경</h3>
<hr><br>

<form action="tour?command=reservationUpd" method="post">

    <label for="id">고객 아이디</label><br>
 	<input type="text" name="userId" value="${user.userId}" readonly><br>
 		
    <label for="pw">비밀번호</label><br>
    <input type="password" name="userPw" value="${user.userPw}" readonly><br>

    <label for="name">고객 명</label><br>
    <input type="text" name="userName" value="${user.userName}" readonly><br>
 	
    <label for="code">투어 코드</label><br>
 	<input type="text" name="travelId"  placeholder="Your hope tour code.."><br>

	<input type="submit" value="수정">
 			&nbsp;&nbsp;&nbsp;<input type="reset" value="취소">

</form>

<br><br><hr><br>
<a href="${pageContext.request.contextPath}/main.html" class='fas fa-home'>Home</a>

</body>
</html>