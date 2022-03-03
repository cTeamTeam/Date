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
	<script src="/date/resources/js/review.js"></script>
<title>매칭 후기</title>
</head>
<body>
<!-- 네비게이션 바 -->
<%@include file="/WEB-INF/views/user/common/header.jsp" %>
    
    <h3 style="color:pink;font-weight:800;margin-top:60px;">매칭 후기</h3>
    <div class="qaList">
	<div class="search">
		<select name="searchType">
		<option value="n"<c:out value="${scri.searchType == null ? 'selected' : ''}"/>>-----</option>
		<option value="t"<c:out value="${scri.searchType eq 't' ? 'selected' : ''}"/>>제목</option>
		<option value="c"<c:out value="${scri.searchType eq 'c' ? 'selected' : ''}"/>>내용</option>
		<option value="w"<c:out value="${scri.searchType eq 'w' ? 'selected' : ''}"/>>작성자</option>
		<option value="tc"<c:out value="${scri.searchType eq 'tc' ? 'selected' : ''}"/>>제목+내용</option>
		</select>
			<input type="text" class="qaSearchInput" name="keyword" id="keywordInput" value="${scri.keyword}"/>
			<button id="searchBtn" class="qaButton" type="button">검색</button>
			<script>
				$(function(){
					$('#searchBtn').click(function() {
						self.location = "list" + '${pageMaker.makeQuery(1)}' + "&searchType=" + $("select option:selected").val() + "&keyword=" + encodeURIComponent($('#keywordInput').val());
					});
				});   
			</script>
  	</div>
	<form id="frm">
		<input type = "hidden" value="" name = "seq" id = "seq">
		<table style="margin:auto;margin-top:20px;">
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>작성자</th>
				<th>날짜</th>
				<th>조회수</th>
			</tr>
			<c:forEach items="${list}" var="list">	
			<tr>
				<td class="qaId">${list.seq}</td>
				<td class="qaTitle"><button class="reviewContentBtn" onclick="goView(${list.seq})">${list.title}</button></td>
				<td class="qaId">${list.name}</td>
				<td class="qaId">${list.regDate}</td>
				<td class="qaId">${list.readCount}</td>
			</tr>
			</c:forEach>
		</table>
		<div class="writeWrap">
			<c:if test="${ loginVo == null }">
				<button type="button" class="qaButton" onclick="notLogin()">글쓰기</button>
			</c:if>
			<c:if test="${ loginVo != null }">
				<button type="button" class="qaButton" onclick="location.href='/date/user/review/reviewForm'">글쓰기</button>
			</c:if>
		</div>
		<div class="pageWrap">
			<ul class="pageWrap">
			<c:if test="${pageMaker.prev}">
				<li class="reviewli"><a href="list${pageMaker.makeSearch(pageMaker.startPage - 1)}">이전</a></li>
				</c:if> 
					 <c:forEach begin="${pageMaker.startPage}" end="${pageMaker.endPage}" var="idx">
					 	<li class="reviewli"><a href="list${pageMaker.makeSearch(idx)}">${idx}</a></li>
					 </c:forEach>
				<c:if test="${pageMaker.next && pageMaker.endPage > 1}">
					<li class="reviewli"><a href="list${pageMaker.makeSearch(pageMaker.endPage + 1)}">다음</a></li>
				</c:if> 
			</ul>
		</div>
	</form>
	</div>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>

<%@include file="/WEB-INF/views/user/common/footer.jsp" %>
</body>
</html>