<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<meta name="description" content="" />
<meta name="author" content="" />
<title>비밀번호 변경 페이지</title>
<link href="/date/resources/css/styles.css" rel="stylesheet" />
<link href="/date/resources/css/banner.css" rel="stylesheet" />
<link href="/date/resources/css/footer.css" rel="stylesheet" />
<link href="/date/resources/css/pwFind.css" rel="stylesheet" />
<script type="text/javascript" src="/date/resources/js/scripts.js"></script>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
</head>
<body>
<!-- 네비게이션 바 -->
<%@include file="/WEB-INF/views/user/common/header.jsp" %>

<div class="findWrap">
	<h3 style="color:pink;font-weight:800;margin-top:60px;">비밀번호 찾기</h3>

	<div style="margin-top:30px;">
		<form action="changePw" method="post">
			<span class="findTitle">새 비밀번호 :</span> <input class="findInput2" type="password" name="newPw" id="newPw" /><br>
			<p><label for="passwordCheck" id="pw_error" class="error" style="color:red;font-size:10px;"></label></p>
			<span class="findTitle">새 비밀번호 확인 :</span> <input class="findInput2" type="password" name="newPwCheck" id="pwCheck" /><br>
			<p><label for="passwordCheck" id="check_error" class="error" style="color:red;font-size:10px;"></label></p>
			<button class="qaButton" type="submit">변경</button>
			<button class="qaButton" type="reset">리셋</button>
		</form>
	</div>
	
	<c:if test="${pwCheck==false }">
		<script type="text/javascript">
			alert("비밀번호가 일치하지 않습니다!");
			history.back(-1);
		</script>
	</c:if>
	<c:if test="${pwCheck==true }">
		<script type="text/javascript">
			alert("비밀번호가 변경되었습니다!")
			location.href="/date/loginForm";
		</script>
	</c:if>
	
	<script type="text/javascript">
		
		
		$("#newPw").blur(function() {
			var newPw = $("#newPw").val();
			var num = newPw.search(/[0-9]/g);
			var eng = newPw.search(/[a-z]/ig);
			var spe = newPw.search(/[`~!@@#$%^&*|₩₩₩'₩";:₩/?]/gi);
			
			if (newPw.length<8 || newPw.length>15) {
				$("#pw_error").text("8자이상 15자이하 비밀번호만 입력하세요.");
				$("#pw_error").css('color', 'red');
				return;
			} else {
				if (num < 0 || eng < 0 || spe < 0) {
					$("#pw_error").text("영문,숫자, 특수문자를 혼합하여 입력해주세요.");
					$("#pw_error").css('color', 'red');
					return;
				} else {
					$("#pw_error").text("적합한 비밀번호 입니다!");
					$("#pw_error").css('color', 'green');
				}
			}
		});
		
		$("#pwCheck").blur(function() {
			var newPw = $("#newPw").val();
			var pwCheck = $("#pwCheck").val();
			
			if (newPw!=pwCheck) {
				$("#check_error").text("비밀번호가 일치하지 않습니다.");
				$("#check_error").css('color', 'red');
				return;
			} else {
				$("#check_error").text("비밀번호가 일치합니다.");
				$("#check_error").css('color', 'green');
			}
		});
	</script>
</div>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
	<%@include file="/WEB-INF/views/user/common/footer.jsp" %>
</body>
</html>