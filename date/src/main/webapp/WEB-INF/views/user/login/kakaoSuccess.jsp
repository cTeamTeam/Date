<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>카카오 로그인 성공 테스트</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>
<body>
카카오 로그인 성공 테스트 페이지
<a href="https://kauth.kakao.com/oauth/logout?client_id=93175f79121624f22c8acce52fd16344&logout_redirect_uri=http://localhost:8080/date/kakaologout">로그아웃</a>
<script src="https://developers.kakao.com/sdk/js/kakao.js"></script>
<script>
$(document).ready(function() {
    var kakaoInfo = '${kakaoInfo}';
    if(kakaoInfo != ""){
        var data = JSON.parse(kakaoInfo);
        alert("카카오로그인 성공 \n accessToken : " + data['accessToken']);
        alert(
        "user : \n" + "email : "
        + data['email']  
        + "\n nickname : " 
        + data['nickname']);
       // location.href="/date/";
    }
});  
</script>
</body>
</html>