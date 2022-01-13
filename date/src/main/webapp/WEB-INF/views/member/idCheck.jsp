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
	<c:if test="${idCheck eq 1}">
		${checkMessage}
		<button onclick="javascript:self.close()">닫기</button>
	</c:if>
	<c:if test="${idCheck eq 0}">
		${checkMessage}
		<button onclick="javascript:self.close()">아이디 사용</button>
	</c:if>
</body>
</html>