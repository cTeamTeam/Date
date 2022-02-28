<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width", initial-scale="1">
<link rel="stylesheet" type="text/css" href="/date/resources/css/bootstrap.css" />
</head>
<body>
	<table>
		<tr>
			<td>제목</td>
			<td>${qaContent.title }</td>
		</tr>
		<tr>
			<td>작성자</td>
			<td>${qaContent.id }</td>
		</tr>
		<tr>
			<td>내용</td>
			<td>${qaContent.content }</td>
		</tr>
		<tr>
			<td>작성일</td>
			<td>${qaContent.wDate}</td>
		</tr>
		<tr>
			<td>조회수</td>
			<td>${qaContent.count }</td>
		</tr>
	</table>
	
	<div>
		<form method="post" name="aModifyForm" action="/date/answerModify?qaNum=${qaContent.num }">
			<textarea id="answer" name="answer" cols="30" rows="10">${qaAnswer.answer }</textarea>
			<button type="submit">수정하기</button>
		</form>
	
		
	</div>
</body>
</html>