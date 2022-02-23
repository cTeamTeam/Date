<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
		<a href="/date/adminQADelete?qaNum=${qaContent.num}">글 삭제</a>
	</div>
	<div>
		<c:if test="${qaAnswer==null }">
			<form method="post" name="answerForm" action="/date/adminAnswer?qaNum=${qaContent.num }">
				<textarea id="answer" name="answer" cols="30" rows="10"></textarea>
				<button type="submit">답변 작성</button>
			</form>
		</c:if>
		<c:if test="${qaAnswer!=null }">
			${qaAnswer.answer }<br>
			${qaAnswer.answerDate }<br>
			<a href="/date/answerDelete?qaNum=${qaAnswer.qaNum}">답변 삭제</a>
			<a href="/date/answerModify?qaNum=${qaAnswer.qaNum}">수정</a>
		</c:if>
	</div>
	
</body>
</html>