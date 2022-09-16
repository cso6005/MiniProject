<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 

<% 	
	String url = application.getContextPath() + "/";
	System.out.println(url);
%>
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html> 
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" href="css/styletable.css">
	<script src='https://kit.fontawesome.com/a076d05399.js' crossorigin='anonymous'></script>

	<title>투어 상세 정보 화면</title>
</head>

<body> 
<br><br><br><hr><p>
<center>
<h3>투어 상세 정보</h3>
<hr><p> 
 
<table  id="customers">
	<tr>
		<th>code</th><th>투어 명</th><th>도시</th><th>기간</th><th>가격</th><th>평점</th>
	</tr>
 	<tr>
 		<td>${travel.travelId}</td>
 		<td>${travel.travelName}</td>
 		<td>${travel.city}</td>
 		<td>${travel.period}</td> 		
 		<td>${travel.price}</td>
 		<td>${travel.starRate}</td>
 	</tr>
</table>

<br><br><br>

<form action="tour?command=reservationReq&travelId=${travel.travelId}" method="post" >
	<input type="submit" value="예약">
	</form>

<br><hr><br>
<a href="${pageContext.request.contextPath}/main.html" class='fas fa-home'>Home</a>

</center>
</body>
</html>







