<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<meta name="description" content="" />
<meta name="author" content="" />
<title>매칭 리뷰</title>
<link href="/date/resources/css/styles.css" rel="stylesheet" />
<link href="/date/resources/css/banner.css" rel="stylesheet" />
<link href="/date/resources/css/footer.css" rel="stylesheet" />
<script type="text/javascript" src="/date/resources/js/scripts.js"></script>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script src="/date/resources/js/review.js"></script>
<script type="text/javascript">
	$(function() {
		if(!'${loginVo}') {
			alert('로그인 후 사용가능합니다.');
			location.href='/date/loginForm';
		}
	});
</script>
<title>글쓰기</title>
</head>
<body>
	<%@include file="/WEB-INF/views/user/common/header.jsp" %>
	
	<form id="frm">
		<input type="text" placeholder="제목" id="title" name="title" maxlength="50">
		<input type="text" placeholder="작성자" id="name" name="name" value="${loginVo }">
		<input type="text" placeholder="내용" id="content" name="content" maxlength="1000"> 
		<input type="file" name = "file">
		<button type="button" id = "reviewSubmit "onclick="reviewSubmit()">등록</button>
	</form>
	
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
	<%@include file="/WEB-INF/views/user/common/footer.jsp" %>
</body>
</html>