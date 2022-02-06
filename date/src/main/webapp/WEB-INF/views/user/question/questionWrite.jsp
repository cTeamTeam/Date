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

table {
	margin:auto;
	margin-top:50px;
	border-collapse:collapse;
	border:1px solid black;
}

td {
	border:1px solid black;
}
</style>
</head>
<body>
<c:if test="${login==null }">
	<div style="float:right">
		<a href ="loginForm">로그인</a>
		<a href ="signup">회원가입</a>
	</div>
</c:if>
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
    	<form:form commandName="qaWrite" method="post">
    		<table>
    			<tr>
    				<td>작성자</td>
    				<td>${loginVo}</td>
    			</tr>
    			<tr>
    				<td>제목</td>
    				<td><form:input path="title"/></td>
    			</tr>
    			<tr>
    				<td colspan="2">내용</td>
    			</tr>
    			<tr>
    				<td colspan="2"><textarea cols="30" rows="10" name="content"></textarea>
    			</tr>	
				<tr>
					<td><button type="submit">작성</button></td>
					<td><button type="reset">리셋</button></td>
				</tr> 		
    		</table>
    	</form:form>
    </div>
    
   <c:if test="${loginVo==null }">
   	<script type="text/javascript">
   		alert("로그인을 먼저 하세요");
   		location.href="/date/loginForm";
   	</script>
   </c:if>

    
</body>
</html>