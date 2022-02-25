<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<meta name="UTF-8">
	<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
	<script src="${path}/resources/js/notice.js"></script>
	<style type="text/css">
	    tr.row:hover {
	    	background-color: #FFCCFF;
	    	cursor:pointer;	
	    }
	    li {list-style : none; float : left; padding : 6px;} 
	</style>
<title>공지사항</title>
</head>
<body>
<h1> 공지사항</h1>
		<form id="root">
				<input type = "hidden" value="" name = "bno" id = "bno">
					<table>
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
						<tr class="row" onclick="noticeView(${noticeList.bno})">
							<td>${noticeList.bno}</td>
							<td>${noticeList.title}</td>
							<td>${noticeList.name}</td>
							<td>${noticeList.content}</td>
							<td><fmt:formatDate value="${noticeList.regdate}" pattern="yyyy-MM-dd"/></td>
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
						<button type="button" onclick="location.href='/user/notice/noticeForm'">글쓰기</button>
				</c:if>
		</form>
	</body>
</html>























