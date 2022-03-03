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
<title>아이디 찾기</title>
<link href="/date/resources/css/styles.css" rel="stylesheet" />
<link href="/date/resources/css/banner.css" rel="stylesheet" />
<link href="/date/resources/css/footer.css" rel="stylesheet" />
<link href="/date/resources/css/idSearch.css" rel="stylesheet" />
<link href="/date/resources/css/dropdown.css" rel="stylesheet" />
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script type="text/javascript" src="/date/resources/js/scripts.js"></script>
</head>
<body>
<!-- 네비게이션 바 -->
<%@include file="/WEB-INF/views/user/common/header.jsp" %>

<h3 style="color:pink;font-weight:800;margin-top:60px;">아이디 찾기</h3>

	<div class="idSearchWrap">
	<form action="/date/idForGot" method="post" name="idSearchForm">
		<p>이메일 <input class="idSearchInput" type="text" name = "email" size="13" id="email"
		placeholder="가입하신 이메일을 입력해주세요"></p>
		<div class="buttonWrap">
			<input class="qaButton" type="button" value="확인" onclick="searchCheck()">
			<input class="qaButton" type="button" value="HOME" onclick="location.href='/date/'">
		</div>
	</form>
	
		<div style="margin-top:40px;">
			<label class="findForm" id="findId"></label>
		</div>
	</div>
	<script type="text/javascript" src="/date/resources/js/findId.js"></script>
		
	
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
	<%@include file="/WEB-INF/views/user/common/footer.jsp" %>
</body>
</html>