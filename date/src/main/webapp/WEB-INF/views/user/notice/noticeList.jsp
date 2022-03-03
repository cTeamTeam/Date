<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<meta name="UTF-8">
	<link href="/date/resources/css/styles.css" rel="stylesheet" />
	<link href="/date/resources/css/banner.css" rel="stylesheet" />
	<link href="/date/resources/css/footer.css" rel="stylesheet" />
	<link href="/date/resources/css/reviewList.css" rel="stylesheet" />
	<link href="/date/resources/css/dropdown.css" rel="stylesheet" />
	<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
	<script src="/date/resources/js/notice.js"></script>
<title>공지사항</title>
<style>
	li {list-style : none; float : left;} 
</style>
</head>
<body>

<!-- 네비게이션 바 -->
<%@include file="/WEB-INF/views/user/common/header.jsp" %>
<h3 style="color:pink;font-weight:800;margin-top:60px;">공지 사항</h3>

	<div class="qaList">
		<form id="root">
				<input type = "hidden" value="" name = "bno" id = "bno">
					<table style="margin:auto; margin-top:20px;">
					<thead>
						<tr>
							<th>번호</th>
							<th>제목</th>
							<th>작성자</th>
							<th>내용</th>
							<th>날짜</th>
						</tr>
					</thead>
				
					<c:forEach items="${noticeList}" var = "noticeList">
						<tr>
							<td class="qaId">${noticeList.bno}</td>
							<td class="qaTitle">
								<button class="reviewContentBtn" onclick="noticeView(${noticeList.bno})">${noticeList.title}</button>
							</td>
							<td class="qaId">${noticeList.name}</td>
							<td class="qaId">${noticeList.content}</td>
							<td class="qaId"><fmt:formatDate value="${noticeList.regdate}" pattern="yyyy-MM-dd"/></td>
						</tr>
					</c:forEach>
			</table>
				<div>
					  <ul>
					    <c:if test="${pageMaker.prev}">
					    	<li><a href="noticeList${pageMaker.makeSearch(pageMaker.startPage - 1)}">이전</a></li>
					    </c:if> 
					
					    <c:forEach begin="${pageMaker.startPage}" end="${pageMaker.endPage}" var="idx">
					    	<li><a href="noticeList${pageMaker.makeSearch(idx)}">${idx}</a></li>
					    </c:forEach>
					
					    <c:if test="${pageMaker.next && pageMaker.endPage > 1}">
					    	<li><a href="noticeList${pageMaker.makeSearch(pageMaker.endPage + 1)}">다음</a></li>
					    </c:if> 
					  </ul>
				</div>
				<c:if test="${ admin == Y }">
						<button class="qaButton" type="button" onclick="location.href='/date/user/notice/noticeForm'">글쓰기</button>
				</c:if>
		</form>
		</div>
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>

		<%@include file="/WEB-INF/views/user/common/footer.jsp" %>
	</body>
</html>