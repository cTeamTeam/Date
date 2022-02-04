<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
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
<c:if test="${ loginVo == null }">
		<input type="button" value="회원가입" onclick="location.href='signup'">
		<input type="button" value="로그인" onclick="location.href='loginForm'">
	</c:if>
	<c:if test="${ loginVo != null }">
		<c:choose>
			<c:when test="${access_Token==null }">
				<p>${loginVo}님</p>
				<i class="glyphicon glyphicon-user" style="font-size:48px;" onclick="location.href='mypage'"></i>
				<input type="button" value="로그아웃" onclick="location.href='logout'">
			</c:when>
			<c:when test="${access_Token!=null }">
				<p>${loginVo}님</p>
				<i class="glyphicon glyphicon-user" style="font-size:48px;" onclick="location.href='mypage'"></i>
				<a href="https://kauth.kakao.com/oauth/logout?client_id=93175f79121624f22c8acce52fd16344&logout_redirect_uri=http://localhost:8080/date/kakaologout">카카오로그아웃</a>
			</c:when>
		</c:choose>
	</c:if>

	
<h1 style="color:pink"><a href="/date/">쩜오 0.5</a></h1>
 <div class="dropdown">
      <button class="dropbtn">사이트 안내</button>
      <div class="dropdown-content">
        <a href="service">서비스 안내</a>
        <a href="#">멤버쉽 안내</a>
      </div>
    </div>
     <div class="dropdown">
      <button class="dropbtn">결제 관련 메뉴</button>
      <div class="dropdown-content">
        <a href="payGuide">결제 안내</a>
        <a href="#">멤버쉽 구매</a>
      </div>
    </div>
      <div class="dropdown">
      <button class="dropbtn">매칭 관련 메뉴</button>
      <div class="dropdown-content">
        <a href="#">이상형 리스트</a>
        <a href="#">매칭 현환</a>
      </div>
    </div>
      <div class="dropdown">
      <button class="dropbtn">게시판 관련 메뉴</button>
      <div class="dropdown-content">
        <a href="#">공지사항</a>
        <a href="#">매칭 후기</a>
        <a href="qaList">Q & A</a>
      </div>
    </div>
    
    <div>
    	<form name="searchForm" method="get" action="/date/qaSearch?keyword=${document.searchForm.keyword.value}">
 			 <select name="searchType">
 			 	<option value="title">제목</option>
 			 	<option value="content">내용</option>
 			 	<option value="writer">작성자</option>
 			 </select>검색 : <input type="text" name="keyword" id="keyword">
 			 <span>
 			 	<button type="button" onclick="searchCheck()">검색</button>
 			 </span>   	
    	</form>
    </div>
    
    <table style="margin-top:60px; margin:auto;">
    	<c:if test="${empty questionList }">
    		<tr>
    			<th colspan="5">Q&A 목록</th>
    		</tr>
    		<tr>
    			<td colspan="5">등록된 Q&A가 없습니다</td> 
    		</tr>
    	</c:if>
 		<c:if test="${!empty questionList }">
 			<tr>
    		<th>번호</th>
    		<th>작성자</th>
    		<th>제목</th>
    		<th>조회수</th>
    		<th>답변 상태</th>
    	</tr>
    	<c:forEach var="list" items="${questionList }">
    		<tr>
    			<td>${list.rnum }</td>
    			<td>${list.id }</td>
    			<td><a href="/date/qaContent?qaNum=${list.num}">${list.title }</a></td>  			
    			<td>${list.count }</td>
    			<td>${list.state }</td>
    		</tr>
    	</c:forEach>
 		</c:if>
    </table>
    
    <div>	
    	<a href="/date/qaWrite"><button type="button">작성하기</button></a>
    </div>
    
    <c:set var="list" value="${questionList}"/>
	<c:if test="${!empty list}">
	<div>
		<div>
		
		<c:if test="${page.startPage > page.pageBlock}">
			<a href="/date/qaList?num=${page.startPage-1}">[이전]</a>
		</c:if>
		<c:forEach var="block" begin="${page.startPage}" end="${page.endPage}" step="1">
			
			
			<a href="/date/qaList?num=${block}">${block}</a>
		</c:forEach>
	
		<c:if test="${page.endPage<page.pageCount}">
			<a href="/date/qaList?num=${page.endPage+1}">[다음]</a>
		</c:if>
		
		</div>
	</div>
	</c:if>

  
</body>
</html>