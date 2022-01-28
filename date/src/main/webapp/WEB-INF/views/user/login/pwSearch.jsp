<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>비밀번호 찾기 페이지</title>
</head>
<body>
	<form action="/date/pwForGot" method="post">
		<p>아이디 : <input type="text" name = "id" size="13"></p>
		<p>연락처 : <input type="text" name = "phoneNum" size="13"></p>
		<input type="submit" value="확인">
		<input type="button" value="메인페이지이동" onclick="location.href='/date/'">
	</form>
	
	<c:if test="${ pwSearchOk.password == null}">
		<script type="text/javascript">
			alert('일치하는 비밀번호가 없습니다.');
		</script>
	</c:if>
	<c:if test="${ pwSearchOk.password != null }">
		<p>찾으시는 비밀번호는</p>
		<p>${pwSearchOk.password}</p>
		<p>입니다</p>
	</c:if>
	
</body>
</html>