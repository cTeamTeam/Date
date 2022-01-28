<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>마이페이지 테스트</title>
</head>
<body>

<table border="1">
	<tr>
		<th> ID </th>
		<th> 이름 </th>
		<th> 닉네임</th>
		<th> 생일 </th>
		<th> 성별</th>
		<th> 이메일</th>
		<th> 전화번호</th>
		<th> 멤버쉽</th>
		<th> 잔여횟수</th>
	</tr>
	<c:forEach var="myPageList" items="${myPageList }">
	<tr>
		<td>${myPageList.id }</td>
		<td>${myPageList.name }</td>
		<td>${myPageList.nickName }</td>
		<td>${myPageList.birth }</td>
		<td>${myPageList.gender }</td>
		<td>${myPageList.email }</td>
		<td>${myPageList.phoneNum }</td> 
		<td>${myPageList.membership }</td>
		<td>${myPageList.date_count }</td>
	</tr>
	</c:forEach>
</table>
	
	<a href = "<c:url value="/withdraw"/>">회원탈퇴</a>


</body>
</html>