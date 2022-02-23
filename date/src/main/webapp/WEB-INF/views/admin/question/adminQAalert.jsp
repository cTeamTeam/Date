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
	var qa = ${qa};
	if (qa==1) {
		var msg = "Q&A 게시물을 삭제했습니다";
		alert(msg);
		location.href="/date/adminQA";
	} else if (qa==2) {
		var msg = "답변을 등록하였습니다.";
		alert(msg);
		location.href="/date/adminQA";
	} else if (qa==3) {
		var msg = "답변을 삭제하였습니다.";
		alert(msg);
		location.href="/date/adminQA";
	} else if (qa==4) {
		var msg = "답변 수정을 완료하였습니다.";
		alert(msg);
		location.href="/date/adminQA";
	}
</script>
</body>
</html>