<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<html>
<head>
<meta charset="UTF-8">
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script src="${path}/resources/js/review.js"></script>
<title>게시글</title>
</head>
<body>
	<form id = "frm">
		<input type="hidden" id="seq" name="seq"/>
		<div>제목 : ${view.title} 조회수 : ${view.readCount}</div>
		<div>작성자 : ${view.name}</div>
		<div>내용 : ${view.content}</div>
		<button type = "button" onclick='location.href="/user/review/list"'>목록</button>
		<button type = "button" onclick='goUpdateView(${view.seq})'>수정</button>
		<button type = "button" onclick='reviewDelete(${view.seq})'>삭제</button>	
	</form>

	<c:forEach var="file" items="${file}">
		<a href="#" onclick="fileDown('${file.FILENUM}'); return false;">${file.ORG_FILE_NAME}</a>(${file.FILE_SIZE}kb)<br>
	</c:forEach>
	
</body>
</html>