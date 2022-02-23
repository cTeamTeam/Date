<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>로그인 오류</title>
<script>
	if (${msg}==1) {
		alert('아이디가 존재하지 않습니다.');
		history.go(-1);
	} else {
		alert('비밀번호가 일치하지 않습니다.');
		history.go(-1);	
	}
</script>
</head>
<body>
</body>
</html>