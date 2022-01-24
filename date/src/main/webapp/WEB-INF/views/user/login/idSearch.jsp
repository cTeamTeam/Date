<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
	<h2>가입하신 성함 및 연락처를 입력해 주세요.</h2>
<body>
	<form action="/idForGot" method="post">
		<p>성함 : <input type="text" name = "name" size="13"></p>
		<p>연락처 : <input type="text" name = "phoneNum" size="13"></p>
		<input type="submit" value="확인">
		<input type="button" value="메인페이지이동" onclick="location.href='/'">
	</form>
	
	
	<c:if test="${ idSearchOk.id == null}">
		<script type="text/javascript">
			alert('일치하는 아이디가 없습니다.');
		</script>
	</c:if>
	<c:if test="${ idSearchOk.id != null }">
		<p>가입하신 아이디는</p>
		<p>${idSearchOk.id}</p>
		<p>입니다</p>
	</c:if>
</body>
</html>