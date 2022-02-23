<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri ="http://java.sun.com/jstl/core_rt" %>
<%@ page import="com.date.jum5.user.login.vo.*" %>
<%@ page import="com.date.jum5.user.mypage.vo.*" %>
<% LoginVo loginVo;
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<meta name="description" content="" />
<meta name="author" content="" />
<title>프로필 등록 페이지</title>
<link href="/date/resources/css/styles.css" rel="stylesheet" />
<link href="/date/resources/css/banner.css" rel="stylesheet" />
<link href="/date/resources/css/footer.css" rel="stylesheet" />
<link href="/date/resources/css/profileForm.css" rel="stylesheet" />
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

<h3 style="color:pink;font-weight:800;margin-top:60px;">프로필 등록</h3>

<div class="profileWrap">
<form:form commandName="profileVo" method="POST" enctype="multipart/form-data">
	<table>
			<tr>
				<td class="profileHead" colspan="2">Profile</td>
			</tr>
			<tr class="profileTr">	
				<th class="profileTitle">닉네임</th>
				<td class="profileTitle">${loginVo}</td>
			</tr>
			<tr class="profileTr">
				<th class="profileTitle">키</th>
				<td><form:input class="profileInput" path="height" /></td>
			</tr>
			<tr class="profileTr">
				<th class="profileTitle">몸무게</th>
				<td><form:input class="profileInput" path="weight" /></td>
			</tr>
			<tr class="profileTr">
				<th class="profileTitle">성격</th>
				<td><form:input class="profileInput" path="character" /></td>
			</tr>
			<tr class="profileTr">
				<th class="profileTitle">취미</th>
				<td><form:input class="profileInput" path="hobby" /></td>
			</tr>
			<tr class="profileTr">
				<th class="profileTitle">혈액형</th>
				<td><form:input class="profileInput" path="bloodType" /></td>
			</tr>
			<tr class="profileTr">
				<th class="profileTitle">직업</th>
				<td><form:input  class="profileInput" path="job" /></td>
			</tr>
			<tr class="profileTr">
				<th class="profileTitle">연봉</th>
				<td><form:input  class="profileInput" path="salary" /></td>
			</tr>
			<tr class="profileTr">
				<th class="profileTitle">거주지</th>
				<td><form:input class="profileInput" path="address" /></td>
			</tr>
			<tr class="profileTr">
				<th class="profileTitle">이상형</th>
				<td><form:input class="profileInput" path="idealType" /></td>
			</tr>
			<tr class="profileTr">
				<th class="profileTitle">나이</th>
				<td><form:input class="profileInput" path="age" /></td>
			</tr>
			<tr class="profileTr">
				<th class="profileTitle">사진 파일</th>
				<td style="padding-left:50px;"><form:input type="file" name="uploadFile" id="imageFile" path="uploadFile" /></td>
			</tr>
</table>
<div style="margin-top:40px;">
<input type="submit" class="qaButton" value="등록">
</div>
</form:form>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
<%@include file="/WEB-INF/views/user/common/footer.jsp" %>
</body>
</html>