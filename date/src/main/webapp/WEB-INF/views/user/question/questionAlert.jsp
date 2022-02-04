<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
	var qa = ${qa};
	if (qa==1) {
		var msg = "Q&A 게시물을 삭제했습니다";
		alert(msg);
		location.href="/date/qaList";
	} else if (qa==2) {
		var msg = "게시물을 수정하였습니다";
		alert(msg);
		location.href="/date/qaList";	
	} else if (qa==3) {
		var msg="Q&A를 등록하였습니다";
		alert(msg);
		location.href="/date/qaList";		
	}
</script>
</head>
<body>
</body>
</html>