<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<meta name="description" content="" />
<meta name="author" content="" />
<title>메인 페이지</title>
<link href="/date/resources/css/styles.css" rel="stylesheet" />
<link href="/date/resources/css/banner.css" rel="stylesheet" />
<link href="/date/resources/css/footer.css" rel="stylesheet" />
<link href="/date/resources/css/mainPage.css" rel="stylesheet" />
<script type="text/javascript" src="/date/resources/js/scripts.js"></script>
<style>
a:link{color:pink;}
a:visited{color:pink;}
a{text-decoration:none;}
body { text-align: center;}
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

<h3 style="color:pink;font-weight:800;margin-top:60px;">Service</h3>

<div class="mainWrap">
<div class="mainServiceWrap">
	<div class="content">
		<a href="/date/qaList" ><img src="/date/resources/images/board.png" width="100px;" height="100px;"></a>
		<p class="mainTitle">게시판</p>
		<p class="mainContent">게시판을 통해</p>
		<p class="mainContent">소통해보세요</p>
	</div>
	<div class="content">
		<a href="/date/pay"><img src="/date/resources/images/love.png" width="100px;" height="100px;"></a>
		<p class="mainTitle">이상형</p>
		<p class="mainContent">원하는 이상형을</p>
		<p class="mainContent">찾아보세요</p>
	</div>
	<div class="content">
		<a href="/date/metch"><img src="/date/resources/images/money.png" width="100px;" height="100px;"></a>
		<p class="mainTitle">결제</p>	
		<p class="mainContent">저렴한 가격으로</p>
		<p class="mainContent">데이트 신청을 해보세요</p>
	</div>
</div>

<div class="mainInfoWrap">

	<h3 style="color:pink;font-weight:800;margin-top:60px;padding-top:60px;">Info</h3>
	<div class="mainInfoContentWrap">
		<P class="mainRoadTitle"> 서비스 안내 </P>
		<p class="mainInfoContent">
    	쩜오(0.5)는 2013년부터 커플 매칭을 전문적으로 도와주는 업체입니다.
    	</p>
    	<p class="mainInfoContent">
    	서울 강남에서부터 시작하여 현재 부산, 대전, 대구 등 많은 지점을 두었으며 업체를 통해 커플이 된 사람들은 201,304명 입니다.
    	</p>
    	<p class="mainInfoContent">
    	이 중 결혼까지 성공한 횟수는 전체의 93%입니다.
    	커플 매칭은 멤버십 구매를 통해 이루어 지고 있으며, 멤버십에 따라 회수가 차등 적용됩니다.
    	</p>
	</div>
	<div class="mainInfoContentWrap" style="vertical-align:top;margin-top:30px;margin-left:80px;">
		<video autoplay controls loop width="400" height="300" >
			<source src="/date/resources/videos/wedding.mp4" type="video/mp4">
		</video>
	

	</div>
</div>

<div class="mainRoadWrap">
	<h3 style="color:pink;font-weight:800;margin-top:60px;padding-top:30px;">찾아오시는 길</h3>

	<div>
    	<P class="mainRoadTitle"> 위치 안내 </P>
		<div style="width:72px; margin:0 auto;"id="daumRoughmapContainer1642922716153" class="root_daum_roughmap root_daum_roughmap_landing"></div>


		<script charset="UTF-8" class="daum_roughmap_loader_script" src="https://ssl.daumcdn.net/dmaps/map_js_init/roughmapLoader.js"></script>

		<script charset="UTF-8">
			new daum.roughmap.Lander({
				"timestamp" : "1642922716153",
				"key" : "28w2q",
				"mapWidth" : "640",
				"mapHeight" : "360"
			}).render();
		</script>
	</div>
</div>



</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>

<%@include file="/WEB-INF/views/user/common/footer.jsp" %>
</body>
</html>