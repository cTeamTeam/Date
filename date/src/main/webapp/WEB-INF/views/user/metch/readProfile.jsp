<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri ="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/date/resources/css/readProfile.css" />
</head>
<body>
<c:forEach var="profileVo" items="${profileVo }">
<table>
	<tr>
		<td style="width:200px;" rowspan="10"><img src="/date/resources/images/${profileVo.imageFile}" height="280" width="180"></td>
		<td class="infoTitle">키</td>
		<td class="infoTitle" style="padding-left:15px;">${profileVo.height }</td>
	</tr>
	<tr>
		<td class="infoTitle">몸무게</td>
		<td class="infoTitle" style="padding-left:15px;">${profileVo.weight }</td>
	</tr>
	<tr>
		<td class="infoTitle">성격</td>
		<td class="infoTitle" style="padding-left:15px;">${profileVo.character }</td>
	</tr>
	<tr>
		<td class="infoTitle" >취미</td>
		<td class="infoTitle" style="padding-left:15px;">${profileVo.hobby }</td>
	</tr>
	<tr>
		<td class="infoTitle">혈액형</td>
		<td class="infoTitle" style="padding-left:15px;">${profileVo.bloodType }</td>
	</tr>
	<tr>
		<td class="infoTitle">직업</td>
		<td class="infoTitle" style="padding-left:15px;">${profileVo.job }</td>
	</tr>
	<tr>
		<td class="infoTitle">연봉</td>
		<td class="infoTitle" style="padding-left:15px;">${profileVo.salary }</td>
	</tr>
	<tr>
		<td class="infoTitle">거주지</td>
		<td class="infoTitle" style="padding-left:15px;">${profileVo.address }</td>
	</tr>
	<tr>
		<td class="infoTitle">이상형</td>
		<td class="infoTitle" style="padding-left:15px;">${profileVo.idealType }</td>
	</tr>
	<tr>
		<td class="infoTitle">나이</td>
		<td class="infoTitle" style="padding-left:15px;">${profileVo.age }</td>
	</tr>


	<tr>
	</tr>
</table>
</c:forEach>
</body>
</html>