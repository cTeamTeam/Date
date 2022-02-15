<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script src="${path}/resources/js/review.js"></script>
<title>글쓰기</title>
</head>
<body>
	<form id="frm">
		<input type="text" placeholder="제목" id="title" name="title" maxlength="50">
		<input type="text" placeholder="작성자" id="name" name="name">
		<input type="text" placeholder="내용" id="content" name="content" maxlength="1000"> 
		<input type="file" name = "file">
		<button type="button" id = "reviewSubmit "onclick="reviewSubmit()">등록</button>
	</form>
</body>
</html>