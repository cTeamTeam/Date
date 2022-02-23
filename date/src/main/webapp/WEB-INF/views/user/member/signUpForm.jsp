<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page  %>
<%@ page session="false" %>
<html>
<head>
	<meta charset="utf-8" />
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
	<meta name="description" content="" />
	<meta name="author" content="" />
	<title>회원 가입 페이지</title>
	<link href="/date/resources/css/styles.css" rel="stylesheet" />
	<link href="/date/resources/css/banner.css" rel="stylesheet" />
	<link href="/date/resources/css/footer.css" rel="stylesheet" />
	<link href="/date/resources/css/signUp.css" rel="stylesheet" />
	<script type="text/javascript" src="/date/resources/js/scripts.js"></script>
	<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
	<link rel="stylesheet" href="/date/resources/css/signUp.css"/>
</head>
<body>
<!-- 네비게이션 바 -->
<%@include file="/WEB-INF/views/user/common/header.jsp" %>


<h1><strong>쩜 오 0.5</strong></h1>
		<form:form commandName="member" id="registForm">
			<div class="signOutput">
			
				<div class="inputHeight">
					<form:input class="signInput" id="id" path="id" placeholder="아이디"/>
				</div>
				<div class="validText">
					<span id="id_check" class="error" style="color:red;font-size:12px;"></span>
				</div>
				
				<div class="inputHeight">
					<form:password class="signInput" id="password" path="password" placeholder="비밀번호"/>
				</div>
				<div class="validText">
					<label for="password" id="pw_error" class="error" style="color:red;font-size:12px;"></label>
				</div>
				
				<div class="inputHeight">
					<form:password class="signInput" id="passwordCheck" path="pwCheck" placeholder="비밀번호 확인"/>
				</div>
				<div class="validText">
					<label for="passwordCheck" id="pw_check" class="error" style="color:red;font-size:12px;"></label>
				</div>
				
				<div class="inputHeight">
					<form:input class="signInput" id="name" path="name" placeholder="이름"/>
				</div>
				<div class="validText">
					<label></label>
				</div>
				<div class="inputHeight">
					<form:input class="signInput" id="nickName" path="nickName" placeholder="닉네임"/>
				</div>
				<div class="validText">
					<label for="nickName" id="nick_check" class="nick_check" class="error" style="color:red;font-size:12px;"></label>
				</div>
				
				<div class="inputHeight">
					<form:input class="signInput" type="date" id="birth" path="birth"/>
				</div>
				
				<div class="inputHeight">
					<input class="radioSize" type="radio" value="남자" id="gender" name="gender"><span class="inputGender">남자</span>
					<input class="radioSize" type="radio" value="여자" id="gender" name="gender"><span class="inputGender">여자</span>
				</div>
				
				<div class="inputHeight">
					<form:input class="signInput" id="email" path="email" placeholder="이메일"/>
				</div>
				<span><button class="signUpButton" type="button" id="authKeySend" >인증번호 받기</button></span>
				<div class="validText">
					<label for="email" id="email_check" class="error" style="color:red;font-size:12px;"></label>
				</div>
				
				<div class="inputHeight">
					<input type="text" class="signInput" id="authKey" placeholder="인증번호">
				</div>
				<span><button class="signUpButton" type="button" id="authKeyInput">인증하기</button></span>
				<div class="validText">
					<span id="successEmailCheck" style="font-size:12px"></span>
				</div>
				
				<div>
					<button class="signUpButton" type="reset">Reset</button>
					<button class="signUpButton" type="button" onclick="nullCheck()">Sign In</button>
				</div>
				
				<div class="signValid">
					<c:if test="${!empty signUpMsg}">
						<span class="signValidText">${signUpMsg}</span>
					</c:if>
				</div>
			</div>

		</form:form>
<script src="/date/resources/js/signValid.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
	<%@include file="/WEB-INF/views/user/common/footer.jsp" %>
</body>
</html>
