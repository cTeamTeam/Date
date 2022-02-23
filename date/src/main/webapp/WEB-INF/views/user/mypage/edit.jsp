<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<meta name="description" content="" />
<meta name="author" content="" />
<title>메인 페이지</title>
<link href="/date/resources/css/styles.css" rel="stylesheet" />
<link href="/date/resources/css/banner.css" rel="stylesheet" />
<link href="/date/resources/css/footer.css" rel="stylesheet" />
<script type="text/javascript" src="/date/resources/js/scripts.js"></script>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
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
    margin-left:auto; 
    margin-right:auto;
}

table, td, th {
    border-collapse : collapse;
    border : 1px solid black;
};
</style>
<link rel="stylesheet" type="text/css" href="/date/resources/style.css" />
<meta charset="UTF-8">
<title>회원정보 수정</title>
</head>
<body>
<!-- 네비게이션 바 -->
<%@include file="/WEB-INF/views/user/common/header.jsp" %>
        <h1> 회원 정보 수정</h1>
    <form:form commandName="editMember">
    	<table border ="1">
    		<tr>
    			<th><form:label path="id">아이디</form:label></th>
    			<td>${editMember.id }</td>
    		</tr>
    		<tr>
    			<th><form:label path="name">이름</form:label></th>
    			<td><form:input path="name" value="${editMember.name }"/></td>
    		</tr>
    		<tr>
    			<th><form:label path="nickname">닉네임</form:label></th>
    			<td><form:input path="nickname" value="${editMember.nickname }"/></td>
    		</tr>
 			<tr>
				<td><label for="nickName" id="nick_check" class="nick_check" class="error" style="color:red;font-size:10px;"></label>
			</tr>
    		
    	</table>
    	<div>
    	<input type="submit" value="수정">
    	<a href="<c:url value="/mypage" />">마이페이지</a>
    	</div>
    </form:form>
    <script src="/date/resources/js/signValid.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
    
	<%@include file="/WEB-INF/views/user/common/footer.jsp" %>
</body>
</html>