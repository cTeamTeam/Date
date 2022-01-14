<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:if test="${nickNameCheck eq 1}">
		${msg}
		<button onclick="javascript:self.close()">닫기</button>
	</c:if>
	<c:if test="${nickNameCheck eq 0}">
		${msg}
		<button onclick="javascript:self.close()">닉네임 사용하기</button>
	</c:if>
</body>
</html>