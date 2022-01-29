<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
</head>
<body>
	<div>
		<form action="changePw" method="post">
			새 비밀번호 : <input type="password" name="newPw" id="newPw" /><br>
			<p><label for="passwordCheck" id="pw_error" class="error" style="color:red;font-size:10px;"></label></p>
			새 비밀번호 확인 : <input type="password" name="newPwCheck" id="pwCheck" /><br>
			<p><label for="passwordCheck" id="check_error" class="error" style="color:red;font-size:10px;"></label></p>
			<button type="submit">전송</button>
			<button type="reset">리셋</button>
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
</body>
</html>