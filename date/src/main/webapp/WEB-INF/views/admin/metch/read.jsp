<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width", initial-scale="1">
<link rel="stylesheet" type="text/css" href="/date/resources/css/bootstrap.css" />
<title>${metchVo.idx} 내용</title>
</head>
<body>
	<table border="1">
		<tr>
			<th>idx</th>
			<td>${metchVo.idx}</td>
		</tr>
		<tr>
			<th>sender</th>
			<td>${metchVo.senderId}</td>
		</tr>
		<tr>
			<th>receiver</th>
			<td>${metchVo.receiverId}</td>
		</tr>

	</table>
	<div>
		<a href="<c:url value="/metch/delete/${metchVo.idx}"/>"> 삭제</a>
		<a href="<c:url value="/metch/allList"/>"> 목록</a>
	</div>
</body>
</html>