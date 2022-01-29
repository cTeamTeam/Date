<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>비밀번호 찾기 페이지</title>
<link rel="stylesheet" type="text/css" href="/date/resources/css/style.css" />
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<style>
	.pwFind {
		text-align:center;
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

	<form action="/date/pwForGot" method="post">
		<div class="pwFind">
		<p>비밀번호 찾기</p>
		<hr style="width:60%"></hr>
		<div>
			<p>찾으실 아이디를 입력해주세요</p>
			<div>
				<input style="width:500;height:25px;" type="text" name="id" placeholder="찾으실 비밀번호의 아이디를 입력하세요">
			</div>
	
			<br>
			<div>
				<input type="submit" value="확인">
				<input type="button" value="메인페이지이동" onclick="location.href='/date/'">
			</div>
			
		</div>
	</div>
	</form>
	<c:if test="${idExist==0 }">
		<script type="text/javascript">
			alert("아이디가 존재하지 않습니다!");
			history.back(-1);
		</script>
	</c:if>
</body>
</html>