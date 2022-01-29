<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page  %>
<%@ page session="false" %>
<html>
<head>
	<title>회원가입</title>
	<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
	<script type="text/javascript" src="/date/resources/js/jquery.validate.js"></script>
	<script type="text/javascript" src="/date/resources/js/jquery.validate.min.js"></script>
	<link rel="stylesheet" href="/date/resources/css/signUp.css"/>
	<link rel="stylesheet" href="/date/resources/css/style.css"/>
<style>
		h1 {
			text-align:center;
		}
		table {
			margin:auto;
			border-collapse:collapse;
			width:600px;
		}
		
		td {
		}
	</style>

</head>
<body>
<div style="float:right"><a href ="loginForm">로그인</a> <a href ="signup">회원가입</a></div>
<h1 style="color:pink"><a href="mainPage">쩜오 0.5</a></h1>

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
        <a href="#">결제 안내</a>
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
        <a href="#">Q & A</a>
      </div>
    </div>

<h1>Sign Up Form</h1>
<main>
	<div>
		<form:form commandName="member" id="registForm">
			<table>
				<tr>
					<td>
						<p><label for="id">아이디</label></p>
						<p><form:input id="id" path="id"/></p>
					</td>
				</tr>
				<tr>
					<td><span id="id_check" class="error" style="color:red;font-size:10px;"></span></td>
				</tr>
				
				<tr>
					<td>
						<p><label for="pw">비밀번호</label></p>
						<p><form:password id="password" path="password"/>
					</td>
				</tr>
				
				<tr>
					<td><label for="password" id="pw_error" class="error" style="color:red;font-size:10px;"></label>
				</tr>
				
				<tr>
					<td>
						<p><label for="passwordCheck">비밀번호 확인</label></p>
						<p><form:password id="passwordCheck" path="pwCheck"/>
					</td>
				</tr>
				<tr>
					<td><label for="passwordCheck" id="pw_check" class="error" style="color:red;font-size:10px;"></label>
				</tr>
				
				<tr>
					<td>
						<p><label for="name">이름</label></p>
						<p><form:input id="name" path="name"/>
					</td>
				</tr>
				<tr>
					<td>
						<p><label for="nickName">닉네임</label></p>
						<p><form:input id="nickName" path="nickName"/>
					</td>
				</tr>
				<tr>
					<td><label for="nickName" id="nick_check" class="nick_check" class="error" style="color:red;font-size:10px;"></label>
				</tr>
				
				<tr>
					<td>
						<p><label for="birth">생년월일</label></p>
						<p><form:input type="date" id="birth" path="birth"/>
					</td>
				</tr>
				
				<tr>
					<td>
						<p><label for="gender">성별</label></p>
						<p><input type="radio" value="남자" id="gender" name="gender">남자
						<input type="radio" value="여자" id="gender" name="gender">여자
						</p>
					</td>
				</tr>
				
				<tr>
					<td>
						<p><label for="phoneNum">전화번호</label></p>
						<p><form:input  id="phoneNum" path="phoneNum"/>
					</td>
				</tr>
				<tr>
					<td><label for="phoneNum" class="error" style="color:red;font-size:10px;"></label>
				</tr>
				
				<tr>
					<td>
						<p><label for="email">이메일</label></p>
						<p><form:input id="email" path="email"/>
						<button type="button" id="authKeySend" >인증번호 받기</button>
					</td>
				</tr>
				<tr>
					<td><label for="email" id="email_check" class="error" style="color:red;font-size:10px;"></label>
				</tr>
				<tr>
					<td>
						<p><input type="text" id="authKey">
						<button type="button" id="authKeyInput">인증하기</button>
					</td>
				</tr>
				<tr>
					<td><span id="successEmailCheck" style="font-size:10px"></span>
				</tr>
				<tr>
					<td colspan="2">
						<button type="reset">다시 입력</button>
						<button type="button" onclick="nullCheck()">제출</button>
					</td>
				</tr>
				<tr>
					<td colspan="2">
						<c:if test="${!empty signUpMsg}">
							<span style="color:red;font-size:15px;">${signUpMsg}</span>
						</c:if>
					</td>
				</tr>
			</table>
		</form:form>
	</div>
</main>
<script src="/date/resources/js/signValid.js"></script>


	
</body>
</html>
