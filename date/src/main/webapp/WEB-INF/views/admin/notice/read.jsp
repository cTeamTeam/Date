<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${managerNoticeVo.title} 내용</title>
<meta name="viewport" content="width=device-width", initial-scale="1">
<link rel="stylesheet" type="text/css" href="/date/resources/css/bootstrap.css" />
</head>
<body>
	<table border="1">
		<tr>
			<th>제목</th>
			<td>${managerNoticeVo.title}</td>
		</tr>
		<tr>
			<th>내용</th>
			<td>${managerNoticeVo.content}</td>
		</tr>
		<tr>
			<th>작성일</th>
			<td>${managerNoticeVo.date}</td>
		</tr>
		<tr>
			<th>조회수</th>
			<td>${managerNoticeVo.count}</td>
		</tr>
	</table>
	<div>
		<a href="<c:url value="/notice/edit/${managerNoticeVo.num}"/>"> 수정</a>
		<a href="<c:url value="/notice/delete/${managerNoticeVo.num}"/>"> 삭제</a>
		<a href="<c:url value="/notice/list"/>"> 목록</a>
	</div>
</body>
</html>