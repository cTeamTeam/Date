<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자 메인 페이지</title>
<link rel="stylesheet" type="text/css" href="/date/resources/css/bootstrap.css" />

</head>
<body>
<div class="navbar-header">

<button type="button" class="navbar-toggle collapsed"

data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"

aria-expanded="false">

<span class="icon-bar"></span>

<span class="icon-bar"></span>

<span class="icon-bar"></span>

</button>

<a class="navbar-brand" >쩜오(0.5) 관리자 페이지</a>

</div>

<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
<c:if test="${!empty adminId }">
	<div>${adminId }님 환영</div>
	<div><a href="admin/logout">로그아웃</a></div>
</c:if>

<div class="dropdown">
      <button class="dropbtn">회원 관리</button>
      <div class="dropdown-content">
        <a href="admin/list">회원 목록</a>
      </div>
    </div>
      <a href="/date/notice/list"><button class="dropbtn">공지 관리</button></a>

      <a href="/date/metch/allList"><button class="dropbtn">매칭 관리</button></a>

      <a href="/date/pay/list"><button class="dropbtn">결제 관리</button></a>

      <button class="dropbtn"><a href="/date/adminQA">Q & A 관리</a></button>
</div>
</body>
</html>