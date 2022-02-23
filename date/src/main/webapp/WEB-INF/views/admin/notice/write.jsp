<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>새 공지 작성</title>
</head>
<body>
	<form action="<c:url value="/notice/write"/>" method="POST">
		<table border="1">
		<tr>
			<th>제목</th>
			<td><input name="title"></td>
		</tr>
		<tr>
			<th>내용</th>
			<td><input name="content"></td>
		</tr>
		
		</table>
		
		<div>
			<input type="submit" value="등록">
			<a href="<c:url value="/notice/list"/>">목록</a>
		</div>
	</form>
</body>
</html>