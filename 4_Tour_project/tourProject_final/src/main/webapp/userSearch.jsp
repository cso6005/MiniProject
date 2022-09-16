<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<script src='https://kit.fontawesome.com/a076d05399.js' crossorigin='anonymous'></script>
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
	<link rel="stylesheet" href="css/stylesearch.css">
	<title>예약 정보 검색창</title>
</head>
<body>

<br><br><br><hr><p>
<h3>예약 정보 검색</h3>
<h5><font color="#708090">고객님의 id 로 조회 가능합니다.</font></h5>
<hr><p><br><br>

 	<form class="example" action="tour?command=user" method="post" >
	<input type="text" name="userId" placeholder="user Id Search..">	
    <button type="submit"><i class="fa fa-search"></i></button>
	</form>

<br><br><br><br><hr><br>
<a href="${pageContext.request.contextPath}/main.html" class='fas fa-home'>Home</a>

</body>
</html>