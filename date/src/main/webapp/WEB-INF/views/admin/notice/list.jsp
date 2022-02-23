<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix ="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지 사항</title>
</head>
<body>
목록
<form name="form1" method="post" action="search">
	<select name="searchOption">
		<option value="all"<c:out value="${map.searchOption == 'all'?'selected':''}"/>>제목+내용</option>
		<option value="title"<c:out value="${map.searchOption == 'title'?'selected':''}"/>>제목</option>
		<option value="content"<c:out value="${map.searchOption == 'content'?'selected':''}"/>>내용</option>
	</select>
	
	<input name="keyword" value="${map.keyword}">
	<input type="submit" value="조회">
</form>

<table border="1">
<tr>
	<th>num</th>
	<th>title</th>
	<th>content</th>
	<th>date</th>
	<th>count</th>
	</tr>

<c:forEach var="notice" items="${noticelist}" varStatus="loop">
<tr>
	<td> ${notice.num}</td>
	<td><a href="<c:url value="/notice/read/${notice.num}"/>">
			${notice.title}</a>
	<td> ${notice.content}</td>
	<td> ${notice.date}</td>
	<td> ${notice.count}</td>
</tr>
</c:forEach>
</table>
<a href="<c:url value="/notice/write"/>">새글</a>
</body>
</html>