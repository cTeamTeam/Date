<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix ="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content = "text/html; UTF-8">
<title>회원 목록</title>
</head>
<body>
회원 목록
<table border="1">
<tr>
	<th>num</th>
	<th>id</th>
	<th>name</th>
	<th>nickName</th>
	<th>birth</th>
	<th>gender</th>
	<th>phoneNum</th>
	<th>e-mail</th>
</tr>

<c:forEach var="board" items="${list}" varStatus="loop">
<tr>
	<td> ${board.num }</td>
	<td> ${board.id }</td>
	<td> ${board.name }</td>
	<td> ${board.nickName}</td>
	<td> ${board.birth}</td>
	<td> ${board.gender}</td>
	<td> ${board.phoneNum}</td>
	<td> ${board.email}</td>
</tr>

</c:forEach>


</table>
</body>
</html>