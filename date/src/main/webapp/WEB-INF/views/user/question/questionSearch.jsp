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
<title>Q&A 검색</title>
<link href="/date/resources/css/styles.css" rel="stylesheet" />
<link href="/date/resources/css/banner.css" rel="stylesheet" />
<link href="/date/resources/css/footer.css" rel="stylesheet" />
<link href="/date/resources/css/question.css" rel="stylesheet" />
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
<script type="text/javascript">
	function searchCheck() {
		if (document.searchForm.keyword.value=="") {
			alert("검색어를 입력하세요");
			document.searchForm.keyword.focus();
			return;
		} else {
			searchForm.submit();
		}
	}
</script>
</head>
<body>
<!-- 네비게이션 바 -->
<%@include file="/WEB-INF/views/user/common/header.jsp" %>
    
    <h3 style="color:pink;font-weight:800;margin-top:60px;">Q&A 게시판</h3>
    
    <div class="qaList">
    <div class="qaSearch">
    	<form name="searchForm" method="get" action="/date/qaSearch?keyword=${document.searchForm.keyword.value}">
 			 <select name="searchType">
 			 	<option value="title">제목</option>
 			 	<option value="content">내용</option>
 			 	<option value="writer">작성자</option>
 			 </select>검색 : <input class="qaSearchInput" type="text" name="keyword" id="keyword">
 			 <span>
 			 	<button type="button" class="qaButton" onclick="searchCheck()">검색</button>
 			 </span>   	
    	</form>
    </div>
    
    <table style="margin-top:60px; margin:auto;">
    	<c:if test="${empty searchList }">
    		<tr>
    			<th colspan="5">Q&A 목록</th>
    		</tr>
    		<tr>
    			<td colspan="5" class="qaNot">검색 목록이 없습니다</td> 
    		</tr>
    	</c:if>
 		<c:if test="${!empty searchList }">
 			<tr>
    		<th>번호</th>
    		<th>제목</th>
    		<th>작성자</th>
    		<th>조회수</th>
    		<th>답변 상태</th>
    	</tr>
    	<c:forEach var="list" items="${searchList }">
    		<tr>
    			<td class="qaId">${list.rnum }</td>
    			<td class="qaTitle"><a href="/date/qaContent?qaNum=${list.num}">${list.title }</a></td>  
    			<td class="qaId">${list.id }</td>			
    			<td class="qaId">${list.count }</td>
    			<td class="qaId">${list.state }</td>
    		</tr>
    	</c:forEach>
 		</c:if>
    </table>
    
    <div style="margin-top:10px;margin-left:730px;">	
    	<a href="/date/qaWrite"><button class="qaButton" type="button">글쓰기</button></a>
    </div>
    
    <c:set var="list" value="${searchList}"/>
	<c:if test="${!empty list}">
	<div>
		<div>
		
		<c:if test="${page.startPage > page.pageBlock}">
			<a href="/date/qaSearch?searchType=${type}&keyword=${keyword}&num=${page.startPage-1}">[이전]</a>
		</c:if>
		<c:forEach var="block" begin="${page.startPage}" end="${page.endPage}" step="1">
			
			
			<a href="/date/qaSearch?searchType=${type}&keyword=${keyword}&num=${block}">${block}</a>
		</c:forEach>
	
		<c:if test="${page.endPage<page.pageCount}">
			<a href="/date/qaSearch?searchType=${type}&keyword=${keyword}&num=${page.endPage+1}">[다음]</a>
		</c:if>
		
		</div>
	</div>
	</c:if>
	</div>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
	<%@include file="/WEB-INF/views/user/common/footer.jsp" %>
</body>
</html>