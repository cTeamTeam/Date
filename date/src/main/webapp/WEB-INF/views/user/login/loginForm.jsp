<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<meta name="viewport" content="width=device-width,initial-scale=1">
<title>로그인</title>
<script src="https://developers.kakao.com/sdk/js/kakao.js"></script>
</head>
<body>
	<h3>Log In</h3>
	<div>
		<form action="/date/login" method="post">
			<p>
				<label>ID</label> 
				<input id="id" name="id"
					type="text" required>
			</p>
			<p>
				<label>Password</label> <input id="password"
					name="password" type="password" required>
			</p>
			<p>
				<label>
				 <input type="checkbox" name="loginCookie">
					로그인 유지
				</label>
			</p>
				<button type="submit">로그인</button>
				<button type="button" onclick="history.go(-1)">취소</button>
				<button type="button" onclick="location.href='forGotPage'">아이디/패스워드찾기</button>
		</form>
	</div>
	<!-- 카카오 로그인 -->
	<ul>
      <li onclick="kakaoLogin();">
        <a href="javascript:void(0)">
            <span>카카오 로그인</span>
        </a>
      </li>
  </ul>

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
</body>
</html>