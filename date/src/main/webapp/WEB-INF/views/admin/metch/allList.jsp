<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix ="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>매칭 현황</title>
</head>
<body>
목록
<form name="form1" method="post" action="search">
	<select name="searchOption">
		<option value="all"<c:out value="${map.searchOption == 'all'?'selected':''}"/>>sender+receiver</option>
		<option value="sender_Id"<c:out value="${map.searchOption == 'sender_Id'?'selected':''}"/>>sender</option>
		<option value="receiver_Id"<c:out value="${map.searchOption == 'receiver_Id'?'selected':''}"/>>receiver</option>
	</select>
	
	<input name="keyword" value="${map.keyword}">
	<input type="submit" value="조회">
</form>

<table border="1">
<tr>
	<th>idx</th>
	<th>sender</th>
	<th>receiver</th>
	<!-- 
	<th>status</th>
	 -->
	</tr>

<c:forEach var="metch" items="${metchAllList}" varStatus="loop">
<tr>
	<td><a href="<c:url value="/metch/read/${metch.idx}"/>">
	 ${metch.idx}</a>
	<td> ${metch.senderId}</td>
	<td> ${metch.receiverId}</td>
	<!-- 상태창 못불러옴. 이유를 모르겠음.
	<td> <%//${metch.metch_status} %></td>
	-->
</tr>
</c:forEach>
</table>


</body>
</html>