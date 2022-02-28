<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<meta charset="UTF-8">
<link href="/date/resources/css/styles.css" rel="stylesheet" />
<link href="/date/resources/css/banner.css" rel="stylesheet" />
<link href="/date/resources/css/footer.css" rel="stylesheet" />
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script src="/date/resources/js/notice.js"></script>
<script src="/date/resources/js/review.js"></script>
<script src="/date/resources/js/noticeForm.js"></script>
<title>공지사항 작성</title>
</head>
	<body>
		
		<!-- 네비게이션 바 -->
		<%@include file="/WEB-INF/views/user/common/header.jsp" %>
		<h3 style="color:pink;font-weight:800;margin-top:60px;">공지 사항</h3>
		
		<div id="root">			
			<section id="container">
				<form name="writeForm" method="post"  enctype="multipart/form-data">
					<table>
						<tbody>
								<tr>
									<td>
										<label for="title">제목</label><input type="text" id="title" name="title"  title="제목을 입력하세요."/>
									</td>
								</tr>	
								<tr>
									<td>
										<label for="content">내용</label><textarea id="content" name="content"  title="내용을 입력하세요."></textarea>
									</td>
								</tr>
								<tr>
									<td>
										<label for="writer">작성자 : ${loginVo}</label><input type="hidden" id="writer" name="name" value="${loginVo}" />
									</td>
								</tr>
								<tr>
								<tr>
									<td id="fileIndex">
										<c:forEach var="file" items="${file}" varStatus="var">
											<div>
												<input type="hidden" id="FILE_NO" name="FILE_NO_${var.index}" value="${file.FILENUM }">
												<input type="hidden" id="FILE_NAME" name="FILE_NAME" value="FILE_NO_${var.index}">
												<a href="#" id="fileName" onclick="return false;">${file.ORG_FILE_NAME}</a>(${file.FILE_SIZE}kb)>
												<button id="fileDel" onclick="fn_del('${file.FILENUM}','FILE_NO_${var.index}');" type="button">삭제</button>
											</div>
										</c:forEach>
									</td>
								</tr>
								<tr>
									<td>						
										<button class="write_btn" type="submit">작성</button>	
										<button class="fileAdd_btn" type="button">파일추가</button>	
									</td>
								</tr>	
						</tbody>			
					</table>
				</form>
				
			</section>
			<hr />
		</div>
		
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>

		<%@include file="/WEB-INF/views/user/common/footer.jsp" %>
		
	</body>
</html>