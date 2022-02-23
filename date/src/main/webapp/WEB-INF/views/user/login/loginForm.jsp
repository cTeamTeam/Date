<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<meta name="description" content="" />
<meta name="author" content="" />
<title>로그인 페이지</title>
<link href="/date/resources/css/styles.css" rel="stylesheet" />
<link href="/date/resources/css/banner.css" rel="stylesheet" />
<link href="/date/resources/css/footer.css" rel="stylesheet" />
<link href="/date/resources/css/login.css" rel="stylesheet" />
<script type="text/javascript" src="/date/resources/js/scripts.js"></script>
<script src="https://developers.kakao.com/sdk/js/kakao.js"></script>
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
	<h1><strong>쩜 오 0.5</strong></h1>
		
		<div class="loginWrap">
			<form action="/date/login" method="post">
			<table>
				<tr>
					<td colspan="3"><input class="loginInput" id="id" name="id" type="text" placeholder="아이디" required></td>
				</tr>
				<tr>
					<td colspan="3"><input class="loginInput" id="password" name="password" type="password" placeholder="비밀번호" required ></td>
				</tr>
				<tr>
					<td colspan="3"><button class="loginButton" type="submit">로그인</button></td>
				</tr>
				<tr>
					<td><a href="/date/signup">회원 가입</a></td>
					<td><a href="/date/idSearch">아이디 찾기</a></td>
					<td><a href="/date/pwSearch">비밀번호 찾기</a></td>
					
				</tr>
				<tr>
					<td colspan="3">
						<a href="javascript:kakaoLogin();">
						<img src="/date/resources/images/kakao_button.png">
						</a>
					</td>
				</tr>
			</table>
			</form>
		</div>
<script src="https://developers.kakao.com/sdk/js/kakao.js"></script>

<script>
  //카카오로그인
  function kakaoLogin() {
    $.ajax({
        url: '/date/login/getKakaoAuthUrl',
        type: 'get',
        async: false,
        dataType: 'text',
        success: function (res) {
            location.href = res;
        }
    });

  }
 </script>
 <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
 <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
 <%@include file="/WEB-INF/views/user/common/footer.jsp" %>
</body>
</html>