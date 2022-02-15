<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<meta name="UTF-8">
	<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
	<script src="${path}/resources/js/review.js"></script>
	<style type="text/css">
	    tr.row:hover {
	    	background-color: #FFCCFF;
	    	cursor:pointer;	
	    }
	    li {list-style : none; float : left; padding : 6px;} 
	</style>
<title>매칭 후기</title>
</head>
<body>
<h1>리뷰 게시판</h1>
	<form id="frm">
		<input type = "hidden" value="" name = "seq" id = "seq">
		<table>
			<thead>
				<tr>
					<th>번호</th>
					<th>제목</th>
					<th>작성자</th>
					<th>내용</th>
					<th>날짜</th>
					<th>조회수</th>
				</tr>	
			</thead>
			<tbody>
				<c:forEach items="${list}" var="list">
					<tr class="row" onclick="goView(${list.seq})">
						<td>${list.seq}</td>
						<td>${list.title}</td>
						<td>${list.name}</td>
						<td>${list.content}</td>
						<td>${list.regDate}</td>
						<td>${list.readCount}</td>
					</tr>
				</c:forEach>
				</tbody>
				</table>
				<div>
					  <ul>
					    <c:if test="${pageMaker.prev}">
					    	<li><a href="list${pageMaker.makeQuery(pageMaker.startPage - 1)}">이전</a></li>
					    </c:if> 
					
					    <c:forEach begin="${pageMaker.startPage}" end="${pageMaker.endPage}" var="idx">
					    	<li><a href="list${pageMaker.makeQuery(idx)}">${idx}</a></li>
					    </c:forEach>
					
					    <c:if test="${pageMaker.next && pageMaker.endPage > 0}">
					    	<li><a href="list${pageMaker.makeQuery(pageMaker.endPage + 1)}">다음</a></li>
					    </c:if> 
					  </ul>
				</div>	  
			
		<button type="button" onclick="location.href='/user/review/reviewForm'">글쓰기</button>
	</form>	
</body>
</html>