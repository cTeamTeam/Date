<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<script type="text/javascript">
		var msg = ${msg};
		if (msg==1) {
			alert("로그인 후 이용 가능합니다.");
			location.href="/date/loginForm";	
		} else if (msg==2) {
			alert("데이트 신청이 완료되었습니다!");
			location.href="/date/";
		}
	</script>
</body>
</html>