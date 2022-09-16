<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html> 
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<script src='https://kit.fontawesome.com/a076d05399.js' crossorigin='anonymous'></script>
	<link rel="stylesheet" href="css/styletable.css">
	<title>유저 예약 정보 화면</title>
</head>

<body> 
<br><br><br><hr><p>
<center>
<h3>유저 예약 정보</h3>
<h5><font color="#708090">해당 예약 투어 코드를 클릭하면 투어 상세 정보 페이지로 넘어갑니다.</font></h5>
<h5><font color="#708090">투어 코드는 &nbsp;
<a href="tour?command=travelAll" class="fa fa-search"> 투어 여행 검색</a>
에서 확인가능합니다.</font></h5>
<hr><p><br><br>
 
<table  id="customers">
	<tr>
		<th>예약 아이디</th><th>고객 명</th><th>예약 투어 명</th><th>예약 투어 코드</th>
	</tr>
 	<tr>
 		<td>${user.userId}</td>
 		<td>${user.userName}</td>
 		<td>${user.travelId.travelName}</td>
 		<td><a href='${pageContext.request.contextPath}/tour?command=travelId&travelId=${user.travelId.travelId}'>${user.travelId.travelId}</a></td>
 	</tr>
</table>


<br><br>
<form action="tour?command=reservationUpdReq&userId=${user.userId}" method="post">
	<input type="submit" value="수정">
	</form> &nbsp;&nbsp;&nbsp;

	<form action="tour?command=reservationDel&userId=${user.userId}" method="post" >
	<input type="submit" value="예약취소">
	</form>

<br><br><hr><br>
<a href="${pageContext.request.contextPath}/main.html" class='fas fa-home'>Home</a>

</center>
</body>
</html>







