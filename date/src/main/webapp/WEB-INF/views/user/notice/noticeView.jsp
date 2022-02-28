<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
<meta charset="UTF-8">
<link href="/date/resources/css/styles.css" rel="stylesheet" />
<link href="/date/resources/css/banner.css" rel="stylesheet" />
<link href="/date/resources/css/footer.css" rel="stylesheet" />
<link href="/date/resources/css/qaContent.css" rel="stylesheet" />
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script src="/date/resources/js/notice.js"></script>
<script src="/date/resources/js/noticeView.js"></script>
<title>공지사항</title>
<style>
a:link{color:pink;}
a:visited{color:pink;}
a{text-decoration:none;}
body { text-align: center; }
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

		<h3 style="color:pink;font-weight:800;margin-top:60px;">공지 사항</h3>
	
		<section id="container">
			<form name="readForm" role="form" method="post">
				<input type="hidden" id="bno" name="bno" value="${read.bno}" />
			</form>
				<table>
					<tbody>
						<tr style="height:30px;">
							<th class="qaWriteHead" colspan="2" style="text-align:center;">매칭 후기</th>
						</tr>
						<tr style="height:40px;">
							<td class="qaId">제목</td>
							<td><span class="qaContent">${read.title}</span></td>
							
						</tr>	
						<tr style="height:40px;">
							<td class="qaId" style="vertical-align:top; padding-top:10px;">내용</td>
							<td style="vertical-align:top; margin-top:20px;"><span class="qaContent">${read.content}</span></td>
						</tr>
						<tr style="height:40px;">
							<td class="qaId">작성자</td>
							<td><span class="qaContent">${read.name}</span></td>
						</tr>
						<tr style="height:40px;">
							<td class="qaId">작성일</td>
							<td>
								<span class="qaContent"><fmt:formatDate value="${read.regdate}" pattern="yyyy-MM-dd" /></span>
							</td>
						</tr>		
					</tbody>			
				</table>
				<c:forEach var="file" items="${file}" varStatus="var">
					<a href="/date/user/notice/noticeFileDown?fileNo=${file.FILE_NO}">${file.ORG_FILE_NAME}</a>
					(${file.FILE_SIZE}kb)
				</c:forEach>
				
				<div style="margin-bottom:20px;margin-top:20px;">
					<button  type="submit" class="update_btn">수정</button>
					<button  type="submit" class="delete_btn">삭제</button>
					<button  type="submit" class="list_btn">목록</button>	
				</div>
				
			</section>
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
		<%@include file="/WEB-INF/views/user/common/footer.jsp" %>
	</body>	
</html>