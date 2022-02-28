<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix ="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>매칭 성공 현황</title>
<meta name="viewport" content="width=device-width", initial-scale="1">
<link rel="stylesheet" type="text/css" href="/date/resources/css/bootstrap.css" />
</head>
<body>
목록

<table border="1">
<tr>
	<th>idx</th>
	<th>sender</th>
	<th>receiver</th>
	<!-- 
	<th>status</th>
	 -->
	</tr>

<c:forEach var="metchSelect" items="${metchSelect}" varStatus="loop">
<tr>
	<td><a href="<c:url value="/metch/read/${metchSelect.idx}"/>">
	 ${metchSelect.idx}</a>
	<td> ${metchSelect.senderId}</td>
	<td> ${metchSelect.receiverId}</td>
	<!-- 상태창 못불러옴. 이유를 모르겠음.
	<td> <%//${metch.metch_status} %></td>
	-->
</tr>
</c:forEach>
</table>


</body>
</html>