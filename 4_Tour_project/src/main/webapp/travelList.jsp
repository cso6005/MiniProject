<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 

 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html> 
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" href="css/styletable.css">
	<script src='https://kit.fontawesome.com/a076d05399.js' crossorigin='anonymous'></script>
	<title>투어 목록 화면</title>
</head>

<body>
<br><br><br><hr><p>
<center>
<h3>투어 목록</h3>
<h5><font color="#708090">원하시는 투어의 코드를 클릭 시, 빠른 예약이 가능합니다.</font></h5>
<hr><p><br><br>

<table id="customers">

	<tr>
		<th>code</th><th>투어 명</th><th>도시</th><th>기간</th><th>가격</th><th>평점</th>
	</tr>

	<c:forEach items="${travelAll}" var="dataAll"> 
 		<tr>
 			<td><a href='${pageContext.request.contextPath}/tour?command=reservationReq&travelId=${dataAll.travelId}'>${dataAll.travelId}</a></td>
	 		<td>${dataAll.travelName}</td>
	 		<td>${dataAll.city}</td>
	 		<td>${dataAll.period}</td>
	 		<td>${dataAll.price}</td>
	 		<td>${dataAll.starRate}</td>
 		</tr>
 	</c:forEach> 
</table>

<br><hr><br>
<a href="${pageContext.request.contextPath}/main.html" class='fas fa-home'>Home</a>

</center>
</body>
</html>