<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix ="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>결제 현황</title>
<meta name="viewport" content="width=device-width", initial-scale="1">
<link rel="stylesheet" type="text/css" href="/date/resources/css/bootstrap.css" />
</head>
<body>
목록
<form name="form4" method="post" action="search">
	<select name="searchOption">
		<option value="id"<c:out value="${map.searchOption == 'id'?'selected':''}"/>>id</option>
		<option value="pay_date"<c:out value="${map.searchOption == 'pay_date'?'selected':''}"/>>date</option>
	</select>
	
	<input name="keyword" value="${map.keyword}">
	<input type="submit" value="조회">
</form>

${map.payCountArticle}개의 게시물이 있습니다.
<table border="1">
<tr>
	<th>num</th>
	<th>id</th>
	<th>price</th>
	<th>date</th>
	<th>state</th>
	</tr>


<c:forEach var="paystate" items="${map.paySearchList}" varStatus="loop">
<tr>
	<td> ${paystate.num}</td>
	<td> ${paystate.id}</td>
	<td> ${paystate.payPrice}</td>
	<td> ${paystate.payDate}</td>
	<td> ${paystate.payState}</td>
</tr>
</c:forEach>
</table>

<a href="<c:url value="/pay/list"/>">전체 리스트</a>
</body>
</html>