<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자 페이지</title>
</head>
<body>
	<form action ="/date/managerlogin" method="post">
		<p>
		아이디:<input type="text" name="id" type="text" required><br>
		</p>
		<p>
		비밀번호:<input type="password" name="pw" type="password" required><br>
		</p>
		<input type="submit" value="로그인"><br>
		<p>
				<label>
				 <input type="checkbox" name="loginCookie">
					로그인 유지
				</label>
			</p>
	</form>
</body>
</html>