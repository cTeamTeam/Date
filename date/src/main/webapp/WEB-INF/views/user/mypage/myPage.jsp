<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.date.jum5.user.login.vo.*" %>
<%@ page import="com.date.jum5.user.mypage.vo.*" %>
<% LoginVo loginVo= new LoginVo(); %>
<% ProfileVo profileVo = new ProfileVo(); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<meta name="description" content="" />
<meta name="author" content="" />
<title>마이 페이지</title>
<link href="/date/resources/css/styles.css" rel="stylesheet" />
<link href="/date/resources/css/banner.css" rel="stylesheet" />
<link href="/date/resources/css/footer.css" rel="stylesheet" />
<link href="/date/resources/css/mypage.css" rel="stylesheet" />
<link href="/date/resources/css/dropdown.css" rel="stylesheet" />
<script type="text/javascript" src="/date/resources/js/scripts.js"></script>
<meta charset="UTF-8">
<title>마이페이지 테스트</title>
<link rel="stylesheet" type="text/css" href="/date/resources/style.css" />
</head>
<body>
<!-- 네비게이션 바 -->
<%@include file="/WEB-INF/views/user/common/header.jsp" %>

<h3 style="color:pink;font-weight:800;margin-top:60px;">My Page</h3>

<div style="height:1200px;">

<div class="infoWrap">
	<div>
		<c:forEach var="profileVo" items="${profileVo }">
		<div style="display:inline-block;margin-top:15px;">
			<c:if test="${empty profileVo}">
				프로필을 등록하세요.
			</c:if>
			<c:if test="${!empty profileVo}">
				<img src="/date/resources/images/${profileVo.imageFile}" class="profileImg" height="230" width="140">
			</c:if>
		</div>
		</c:forEach>
		
		<c:forEach var="loginVo" items="${test }">
		<div style="display:inline-block">
			<table>
			<c:forEach var="loginVo" items="${test }">
			<tr style="height:30px;">
				<td class="infoTitle" style="width:85px;">이름</td>
				<td class="infoTitle"><span style="float:left;padding-left:10px;">${loginVo.name }</span></td>
			</tr>
			<tr style="height:30px;">
				<td class="infoTitle">이메일</td>
				<td class="infoTitle">${loginVo.email }</td>
			</tr>
			<tr style="height:30px;">
				<td class="infoTitle">멤버십</td>
				<td class="infoTitle"> 
					<c:choose>
					<c:when test="${loginVo.membership==0 }">
						<span style="float:left;padding-left:10px;">없음</span>
					</c:when>
					<c:when test="${loginVo.membership==1 }">
						<span style="float:left;padding-left:10px;">브론즈</span>
					</c:when>
					<c:when test="${loginVo.membership==2 }">
						<span style="float:left;padding-left:10px;">실버</span>
					</c:when>
					<c:when test="${loginVo.membership==3 }">
						<span style="float:left;padding-left:10px;">골드</span>
					</c:when>
					<c:when test="${loginVo.membership==4 }">
						<span style="float:left;padding-left:10px;">플래티넘</span>
					</c:when>
					<c:when test="${loginVo.membership==5 }">
						<span style="float:left;padding-left:10px;">다이아몬드</span>
					</c:when>
					<c:when test="${loginVo.membership==6 }">
						<span style="float:left;padding-left:10px;">VIP</span>
					</c:when>
					</c:choose>
				</td>
			</tr>
			<tr style="height:30px;"> 
				<td class="infoTitle">데이트 횟수</td>
				<td class="infoTitle"><span style="float:left;padding-left:10px;">${loginVo.datecount }회	</span></td>
			</tr>
			</c:forEach>
		</table>
		</div>
		</c:forEach>
		
	</div>		
</div>



<h3 style="color:pink;font-weight:800;margin-top:60px;">ProFile</h3>


<table style="margin-top:60px;margin-left:700px;margin:auto;">
	<c:if test="${empty profileVo }">
		<div class="infoNotTitle">프로필을 등록하지 않았습니다.</div>
	</c:if>
	<c:if test="${!empty profileVo }">
	<c:forEach var="profileVo" items="${profileVo }">
	<tr>
		<td class="infoTitle"><li>키</li></td>
		<td class="infoTitle"><span style="float:left;padding-left:20px;">${profileVo.height }</span></td>
	</tr>
	<tr>
		<td class="infoTitle"><li>몸무게</l1></td>
		<td class="infoTitle"><span style="float:left;padding-left:20px;">${profileVo.weight }</span></td>
	</tr>
	<tr>
		<td class="infoTitle"><li>성격</li></td>
		<td class="infoTitle"><span style="float:left;padding-left:20px;">${profileVo.character }</span></td>
	</tr>
	<tr>
		<td class="infoTitle"><li>취미</li></td>
		<td class="infoTitle"><span style="float:left;padding-left:20px;">${profileVo.hobby}</span></td>
	</tr>
	<tr>
		<td class="infoTitle"><li>혈액형</li></td>
		<td class="infoTitle"><span style="float:left;padding-left:20px;">${profileVo.bloodType }</span></td>
	</tr>
	<tr>
		<td class="infoTitle"><li>직업</li></td>
		<td class="infoTitle"><span style="float:left;padding-left:20px;">${profileVo.job }</span></td>
	</tr>
	<tr>
		<td class="infoTitle"><li>연봉</li></td>
		<td class="infoTitle"><span style="float:left;padding-left:20px;">${profileVo.salary }</span></td>
	</tr>
	<tr>
		<td class="infoTitle"><li>주소</li></td>
		<td class="infoTitle"><span style="float:left;padding-left:20px;">${profileVo.address }</span></td>
	</tr>
	<tr>
		<td class="infoTitle"><li>이상형</li></td>
		<td class="infoTitle"><span style="float:left;padding-left:20px;">${profileVo.idealType }</span></td>
	</tr>
	<tr>
		<td class="infoTitle"><li>나이</li></td>
		<td class="infoTitle"><span style="float:left;padding-left:20px;">${profileVo.age }</span></td>
	</tr>
	</c:forEach>
	</c:if>
</table>
<c:forEach var="loginVo" items="${test }">
	<c:if test="${empty profileVo}">
		<a href = "<c:url value="/insertProfile"/>"><button type="button" class="qaButton">프로필 등록</button></a><br><br>
	</c:if>
	<c:if test="${!empty profileVo }">
		<a href = "<c:url value="/editProfile"/>"><button type="button" class="qaButton">프로필 수정</button></a><br><br>
	</c:if>
	<!-- 카카오로 로그인할때는 카카오측에서 정보를 불러와 로그인 하므로
		일반 로그인 시에만 회원정보 수정, 탈퇴 가능하도록 함
	 -->
	<c:if test="${access_Token==null }">
		<a href = "<c:url value="/edit"/>"><button type="button" class="qaButton">정보 수정</button></a>
		<a href = "<c:url value="/delete"/>"><button type="button" class="qaButton">회원 탈퇴</button></a>
	</c:if>
</c:forEach>

<br>

<h3 style="color:pink;font-weight:800;margin-top:60px;">Date</h3>

<c:if test="${empty date }">
	<div class="infoNotTitle">들어온 데이트 신청이 없습니다.</div>
</c:if>
<c:if test="${!empty  date}">
	<table>
	<c:forEach var="metchVo" items="${date }" varStatus="loop">
	<tr>
		<td class="infoTitle"><li>신청한 사람</li></td>
		<td class="infoTitle" style="padding-left:20px;"><a onclick="window.open(this.href, '_blank', 'width=600, height=500'); return false;" href="<c:url value="readProfile/${metchVo.senderId }" />">${metchVo.senderId }</a></td>
		<td>
			<form:form commandName="metchVo" action="/date/accept?idx=${metchVo.idx }" >
			<label for="metchStatus"></label>
			<input type="radio" value="1" id="metchStatus" name="metchStatus">수락
			<input type="radio" value="-1" id="metchStatus" name = "metchStatus">거절
			<input type="hidden" value=${metchVo.idx } id="idx" name="idx">
			<input type="submit" style="width:70px;" class="qaButton" value="전송">
		</form:form>
		</td>
		<td colspan="2" class="infoTitle" style="padding-left:40px;">
			<c:choose>
	
			<c:when test = "${metchVo.metchStatus == -1}">
				<td class="infoTitle">거절</td>
			</c:when>
	
			<c:when test = "${metchVo.metchStatus == 0}">
				<td>대기</td>
			</c:when>
	
			<c:when test = "${metchVo.metchStatus ==1}">
				<td>수락</td>
			</c:when>
			</c:choose>
		</td>
	</tr>
	<tr>
	</tr>
	</c:forEach>

	
	<tr>
	</tr>
</table>
</c:if>


</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
<%@include file="/WEB-INF/views/user/common/footer.jsp" %>

</body>
</html>