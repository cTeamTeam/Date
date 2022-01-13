<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page  %>
<%@ page session="false" %>
<html>
<head>
	<title>회원가입</title>
	<script>
		function idCheck() {
			var id = document.getElementById("inputId").value;
			var win = window.open("/date/idCheck/"+id+"", "아이디 체크", "_blank",
					"width=200, height=200");
		}
		function nickNameCheck() {
			var nickName = document.getElementById("inputNickName").value;
			alert(nickName);
			var win = window.open("/date/nickNameCheck/"+nickName+"", "닉네임 체크", "_blank",
					"width=200, height=200");
		}
	</script>
	<style>
		table {
			border:1px solid black;
			border-collapse:collapse;
		}
		
		td {
			border:1px solid black;
		}
	</style>
</head>
<body>
<h1>Sign Up Form</h1>

<main>
	<div>
		<form:form commandName="member">
		<table>
			<tr>
				<td><span>* 은 필수 입력 항목입니다.</span>
			</tr>
			<tr>
				<td colspan="2">아이디</td>
			</tr>
			<tr>
				<td><form:input id="inputId" path="id"/></td>
				<td><button onclick="idCheck()">중복 확인</button>
				<p style="font-size:10px; color:red"><form:errors path="id"/></p>
				</td>
				
			</tr>
			
			<tr>
				<td colspan="2">비밀번호</td>
			</tr>
			<tr>
				<td colspan="2"><form:password path="password"/>
				<p style="font-size:10px; color:red"><form:errors path="password"/></p>
				</td>		
			</tr>
			
			<tr>
				<td colspan="2">비밀번호 확인</td>
			</tr>
			<tr>
				<td colspan="2"><form:password path="pwCheck"/>
				<p style="font-size:10px; color:red"><form:errors path="pwCheck"/></p>
				</td>
			</tr>
			
			<tr>
				<td colspan="2">이름</td>
			</tr>
			<tr>
				<td colspan="2"><form:input path="name"/>
				<p style="font-size:10px; color:red"><form:errors path="name"/></p>	
				</td>
			</tr>
			
			<tr>
				<td colspan="2">닉네임</td>
			</tr>
			<tr>
				<td><form:input id="inputNickName" path="nickName"/></td>
				<td><button onclick="nickNameCheck()">중복 확인</button>
				<p style="font-size:10px; color:red"><form:errors path="nickName"/></p>
				</td>
			</tr>
			
			<tr>
				<td colspan="2">생년월일</td>
			</tr>
			<tr>
				<td colspan="2"><form:input type="date" path="birth"/>
				<p style="font-size:10px; color:red"><form:errors path="birth"/></p>
				</td>
			</tr>
			
			<tr>
				<td colspan="2">성별</td>
			</tr>
			<tr>
				<td><input type="radio" value="남자" name="gender">남자</td>
				<td><input type="radio" value="여자" name="gender">여자</td>
			</tr>
			
			<tr>
				<td colspan="2">전화번호</td>
			</tr>
			<tr>
				<td colspan="2"><form:input path="phoneNum"/>
				<p style="font-size:10px; color:red"><form:errors path="phoneNum"/></p>
				</td>
			</tr>
			
			<tr>
				<td><input type="reset" value="다시 입력"></td>
				<td><input type="submit" value="회원 가입"></td>
			</tr>
		</table>
		</form:form>
	</div>
</main>
</body>
</html>
