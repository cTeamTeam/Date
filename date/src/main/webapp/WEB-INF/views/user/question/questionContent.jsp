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
<title>Q&A 내용</title>
<link href="/date/resources/css/styles.css" rel="stylesheet" />
<link href="/date/resources/css/banner.css" rel="stylesheet" />
<link href="/date/resources/css/footer.css" rel="stylesheet" />
<link href="/date/resources/css/qaContent.css" rel="stylesheet" />
<script type="text/javascript" src="/date/resources/js/scripts.js"></script>
<style>
a:link{color:pink;}
a:visited{color:pink;}
a{text-decoration:none;}
body { text-align: center; }
.dropbtn {
    background-color: gray;
    color: white;
    padding: 16px;
    font-size: 16px;
    border: none;
    cursor: pointer;
}
.dropdown {
    position: relative;
    display: inline-block;
}
.dropdown-content {
    display: none;
    position: absolute;
    background-color: #f9f9f9;
    min-width: 160px;
    box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
    z-index: 1;
}
.dropdown-content a {
    color: black;
    padding: 12px 16px;
    text-decoration: none;
    display: block;
}
.dropdown-content a:hover {
    background-color: pink
}
.dropdown:hover .dropdown-content {
    display: block;
}
.dropdown:hover .dropbtn {
    background-color: pink;
}

</style>
</head>
<body>
<!-- 네비게이션 바 -->
<%@include file="/WEB-INF/views/user/common/header.jsp" %>

	<h3 style="color:pink;font-weight:800;margin-top:60px;">Q&A 게시글</h3>
	
	<div class="qaContentWrap">
	<table>
		<tr>
			<th class="qaWriteHead" colspan="2">Q&A</th>
		</tr>
	
		<tr style="height:40px;">
			<td class="qaId">제목</td>
			<td><span class="qaContent">${qaContent.title }</span></td>
		</tr>
		<tr style="height:40px;">
			<td class="qaId">작성자</td>
			<td><span class="qaContent">${qaContent.id }</span></td>
		</tr>
		<tr style="height:400px;">
			<td class="qaId" style="vertical-align:top; padding-top:10px;">내용</td>
			<td style="vertical-align:top; margin-top:20px;"><span class="qaContent">${qaContent.content }</span></td>
		</tr>
		<tr style="height:40px;">
			<td class="qaId">작성일</td>
			<td><span class="qaContent">${qaContent.wDate}</span></td>
		</tr>
		<tr style="height:40px;">
			<td class="qaId">조회수</td>
			<td><span class="qaContent">${qaContent.count }</span></td>
		</tr>
	</table>
	
	<div class="qaButtonWrap">
		<a href="/date/qaList"><button class="qaButton" type="button">목록</button></a>
		<c:if test="${qaContent.id == loginVo }">
			<a href="/date/qaDelete?qaNum=${qaContent.num}"><button class="qaButton" type="button">삭제</button></a>
			<a href="/date/qaModify?qaNum=${qaContent.num }"><button class="qaButton" type="button">수정</button></a>
		</c:if>
	</div>
	
	<div class="answerTitleWrap">
		<h4 style="color:pink;font-weight:800">Q&A 답변</h4>
	</div>
	
	<div class="qaAnswerWrap">
		<c:if test="${qaAnswer==null }">
			<div style="border-top:1px solid lightgrey">
				<span style="font-weight:800;color:#BDBDBD;text-align:center;padding-top:20px;">답변 대기중입니다.</span>
			</div>
		</c:if>
		<c:if test="${qaAnswer!=null }">
			<table class="answerTable">
				<tr style="max-height:100%">
					<td class="qaId">답변</td>
					<td><span class="qaContent" style="width:150px">${qaAnswer.answer }</span></td>
				</tr>
				<tr style="height:40px;">
					<td class="qaId">답변일</td>
					<td><span class="qaContent">${qaAnswer.answerDate }</span></td>
				</tr>
			</table>
		</c:if>
	
	</div>
	
	</div>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
	<%@include file="/WEB-INF/views/user/common/footer.jsp" %>
</body>
</html>