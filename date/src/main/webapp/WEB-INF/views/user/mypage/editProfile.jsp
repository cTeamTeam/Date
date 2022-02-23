<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri ="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<meta name="description" content="" />
<meta name="author" content="" />
<title>프로필 수정 페이지</title>
<link href="/date/resources/css/styles.css" rel="stylesheet" />
<link href="/date/resources/css/banner.css" rel="stylesheet" />
<link href="/date/resources/css/footer.css" rel="stylesheet" />
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
table {
    margin-left:auto; 
    margin-right:auto;
}

table, td, th {
    border-collapse : collapse;
    border : 1px solid black;
};
</style>
</head>
<body>
<!-- 네비게이션 바 -->
<%@include file="/WEB-INF/views/user/common/header.jsp" %>
<form:form commandName="editProfile" method="POST">
	<table border="1">
			<c:forEach var="test" items="${profileVo }">
			<tr>
				<th>닉네임</th>
				<td>${test.nickname }</td>
			</tr>
			<tr>
				<th>키</th>
				<td><form:input path="height" value="${test.height}" /></td>
			</tr>
			
			<tr>
				<th>몸무게</th>
				<th><form:input path="weight" value="${test.weight }"/></th>
			</tr>
			
			<tr>
				<th>성격</th>
				<td><form:input path="character" value="${test.character }"/></td>
			</tr>
			
			<tr>
				<th>취미</th>
				<td><form:input path="hobby" value="${test.hobby }"/></td>
			</tr>
			
			<tr>
				<th>혈액형</th>
				<th><form:input path="bloodType" value="${test.bloodType }"/></th>
			</tr>
			
			<tr>
				<td>직업</td>
				<td><form:input path="job" value="${test.job }"/></td>
			</tr>
			
			<tr>
				<th>연봉</th>
				<td><form:input path="salary" value="${test.salary }"/></td>
			</tr>
			
			<tr>
				<th>거주지</th>
				<td><form:input path="address" value="${test.address }"/></td>
			</tr>
			<tr>
				<th>이상형</th>
				<td><form:input path="idealType" value="${test.idealType }"/></td>
			</tr>
			<tr>
				<th>나이</th>
				<td><form:input path="age" value="${test.age }"/></td>
			</tr>
			<tr>
				<th>이미지파일</th>
				<td><form:input path="imageFile" value="${test.imageFile }" /></td>
			</tr>
			
			</c:forEach>
</table>
<div>
<input type="submit" value="수정">
</div>
</form:form>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
<%@include file="/WEB-INF/views/user/common/footer.jsp" %>
</body>
</html>