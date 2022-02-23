<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>수정</title>
</head>
<body>
	<form:form commandName="managerNoticeVo" method="POST">
		<table border="1">
		<tr>
			<th><form:label path="title">제목</form:label></th>
			<td><form:input path="title" />
			</td>
		</tr>
		
		<tr>
			<th><form:label path="content">내용</form:label></th>
			<td><form:input path="content" />
			</td>
		</tr>
		
		</table>
		
		<div>
			<input type="submit" value="등록">
			<a href="<c:url value="/notice/list"/>">목록</a>
		</div>
	</form:form>
</body>
</html>