<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width", initial-scale="1">
<link rel="stylesheet" type="text/css" href="/date/resources/css/bootstrap.css" />
<title>삭제</title>
</head>
<body>
	<form name="deleteForm" action="<c:url value="/metch/delete"/>" method="POST">
		<input size="1" name="idx" value="${idx}"/>번 글을 삭제 하시겠습니까? <br>
		<input type="submit" value="삭제">
		<a href="<c:url value="/metch/read/${idx }"/>">취소</a>
	</form>
</body>
</html>