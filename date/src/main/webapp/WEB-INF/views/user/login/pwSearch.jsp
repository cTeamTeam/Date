<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<meta name="description" content="" />
<meta name="author" content="" />
<title>비밀번호 찾기 페이지</title>
<link href="/date/resources/css/styles.css" rel="stylesheet" />
<link href="/date/resources/css/banner.css" rel="stylesheet" />
<link href="/date/resources/css/footer.css" rel="stylesheet" />
<link href="/date/resources/css/pwFind.css" rel="stylesheet" />
<link href="/date/resources/css/dropdown.css" rel="stylesheet" />
<script type="text/javascript" src="/date/resources/js/scripts.js"></script>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
</head>
<body>
<!-- 네비게이션 바 -->
<%@include file="/WEB-INF/views/user/common/header.jsp" %>

<div class="findWrap">

	<h3 style="color:pink;font-weight:800;margin-top:60px;">비밀번호 찾기</h3>

	<form action="/date/pwForGot" method="post">
		<div class="pwFind">
		<hr class="findHr"></hr>
		<div>
			<p class="findTitle">찾으실 아이디를 입력해주세요</p>
			<div>
				<input class="findInput" type="text" name="id">
			</div>
	
			<br>
			<div>
				<input class="qaButton" type="submit" value="확인">
				<input class="qaButton" type="button" value="HOME" onclick="location.href='/date/'">
			</div>
			
		</div>
	</div>
	</form>
	<c:if test="${idExist==0 }">
		<script type="text/javascript">
			alert("아이디가 존재하지 않습니다!");
			history.back(-1);
		</script>
	</c:if>
	
</div>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
	<%@include file="/WEB-INF/views/user/common/footer.jsp" %>
</body>
</html>