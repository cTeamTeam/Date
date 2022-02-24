<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!-- Responsive navbar-->
        <nav class="navbar navbar-expand-lg navbar-pink bg-pink" style="background-color:pink">
            <div class="container">
                <a class="navbar-brand" href="/date">쩜오 0.5</a>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation"><span class="navbar-toggler-icon"></span></button>
                <div class="collapse navbar-collapse" id="navbarSupportedContent">
                    <ul class="navbar-nav ms-auto mb-2 mb-lg-0">
                    	<li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle" id="navbarDropdown" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">사이트 안내</a>
                            <ul class="dropdown-menu dropdown-menu-end" aria-labelledby="navbarDropdown">
                                <li><a class="dropdown-item" href="#">서비스 안내</a></li>
                                <li><a class="dropdown-item" href="#">멤버십 안내</a></li>
                            </ul>
                        </li>
                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle" id="navbarDropdown" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">결제 관련</a>
                            <ul class="dropdown-menu dropdown-menu-end" aria-labelledby="navbarDropdown">
                                <li><a class="dropdown-item" href="#">결제 안내</a></li>
                                <li><a class="dropdown-item" href="/date/pay">멤버십 구매</a></li>
                            </ul>
                        </li>
                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle" id="navbarDropdown" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">매칭 관련</a>
                            <ul class="dropdown-menu dropdown-menu-end" aria-labelledby="navbarDropdown">
                                <li><a class="dropdown-item" href="/date/metch">이상형 리스트</a></li>
                                <li><a class="dropdown-item" href="/date/metchList">매칭 현황</a></li>
                            </ul>
                        </li>
                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle" id="navbarDropdown" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">게시판 관련</a>
                            <ul class="dropdown-menu dropdown-menu-end" aria-labelledby="navbarDropdown">
                                <li><a class="dropdown-item" href="#">공지사항</a></li>
                                <li><a class="dropdown-item" href="/date/user/review/list">매칭 후기</a></li>
                                <li><a class="dropdown-item" href="/date/qaList">Q&A</a></li>
                            </ul>
                        </li>
                      	<c:if test="${ loginVo == null }">
                        	<li class="nav-item"><a class="nav-link active" aria-current="page" href="/date/loginForm">로그인</a></li>
                        	<li class="nav-item"><a class="nav-link active" aria-current="page" href="/date/signup">회원가입</a></li>
                        </c:if>
                        <c:if test="${ loginVo != null }">
                        	<c:choose>
                        		<c:when test="${access_Token==null }">
                        			<li class="nav-item" style="color:white"><a class="nav-link active" aria-current="page" href="/date/mypage">${loginVo }</a></li>
                        			<li class="nav-item"><a class="nav-link active" aria-current="page" href="/date/logout">로그아웃</a></li>
                        		</c:when>
                        		<c:when test="${access_Token!=null }">
                        			<li class="nav-item" style="color:white"><a class="nav-link active" aria-current="page" href="/date/mypage">${loginVo }</a></li>
                        			<li class="nav-item"><a class="nav-link active" aria-current="page" href="https://kauth.kakao.com/oauth/logout?client_id=4ce3789c43e59a00faf9d8115fab8b56&logout_redirect_uri=http://localhost:8080/date/kakaologout">카카오 로그아웃</a></li>
                        		</c:when>
                        	</c:choose>                     		  	
                        </c:if>
                    </ul>
                </div>
            </div>
        </nav>

		<div class="banner"> 
		
		
		</div>
    







   
    
