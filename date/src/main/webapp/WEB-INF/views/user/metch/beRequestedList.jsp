<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri ="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<table border="1">
	<tr>
		<th> 번호 </th>
		<th> 신청한 사람 </th>
		<th> 상태</th>

	</tr>
		
	<c:forEach var="metchVo" items="${metchVo }" varStatus="loop">
	<tr>
		<td>${metchVo.idx }</td>
		<td><a href="<c:url value="readProfile/${metchVo.senderId }" />">${metchVo.senderId }</a></td>
		
	<c:choose>
	
	<c:when test = "${metchVo.metchStatus == -1}">
		<td>거절</td>
	</c:when>
	
	<c:when test = "${metchVo.metchStatus == 0}">
		<td>대기</td>
	</c:when>
	
	<c:when test = "${metchVo.metchStatus ==1}">
		<td>수락</td>
	</c:when>
	</c:choose>
	</tr>
	
	<tr>
	<td>
	<form:form commandName="metchVo" action="/date/accept?idx=${metchVo.idx }" >
	<label for="metchStatus"></label>
	<input type="radio" value="1" id="metchStatus" name="metchStatus">수락
	<input type="radio" value="-1" id="metchStatus" name = "metchStatus">거절
	<input type="hidden" value=${metchVo.idx } id="idx" name="idx">
	<input type="submit" value="등록">
	</form:form>
	</td>
	</tr>
	</c:forEach>
</table>


</body>
</html>