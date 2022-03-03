<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="/date/resources/css/styles.css" rel="stylesheet" />
<link href="/date/resources/css/banner.css" rel="stylesheet" />
<link href="/date/resources/css/footer.css" rel="stylesheet" />
<link href="/date/resources/css/reviewForm.css" rel="stylesheet" />
<link href="/date/resources/css/dropdown.css" rel="stylesheet" />
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script src="/date/resources/js/notice.js"></script>
<script src="/date/resources/js/noticeUpdate.js"></script>
<title>공지사항 수정</title>
<style>
#btn {
	color:white;
	background-color:pink;
	border:none;
	border-radius:6%;
	width:100px;
	height:35px;
	font-weight:800;
}

#btn:hover {
	trasition:all 0.5s ease;
	background-color:#F6CEF5;
}
</style>
</head>	
<body>

	<!-- 네비게이션 바 -->
	<%@include file="/WEB-INF/views/user/common/header.jsp" %>
	
	<div id="root">
		<h3 style="color:pink;font-weight:800;margin-top:60px;">공지 사항</h3>
	
		<section id="container">
			<form name="updateForm" role="form" method="post"  enctype="multipart/form-data">
				<input type="hidden" name="seq" value="${update.seq}" readonly="readonly"/>
				<input type="hidden" id="page" name="page" value="${scri.page}"> 
				<input type="hidden" id="perPageNum" name="perPageNum" value="${scri.perPageNum}"> 
				<input type="hidden" id="searchType" name="searchType" value="${scri.searchType}"> 
				<input type="hidden" id="keyword" name="keyword" value="${scri.keyword}">
				<table style="margin:auto">
					<tbody>
						<tr>
							<th class="qaWriteHead" colspan="2">공지 사항</th>
						</tr>
						<tr>
							<td><label for="title" class="qaId">제목</label></td>
							<td>
								<input class="qaWriteTitle" type = "text" placeholder = "제목" id = "title" name = "title" value="${read.title}">
							</td>
						</tr>
						<tr>
							<td style="color:#BDBDBD;font-weight:800"><label for="writer" >작성자</label></td>
							<td>
								<input class="qaWriteTitle" type="text" placeholder="작성자" id="name" name="name" readonly value="${loginVo}">
							</td>
						</tr>
						<tr>
							<td><label for="content" class="qaId">내용</label></td>
							<td><input class="qaWriteContent" type="text" placeholder="내용" id="content" name="content" value="${read.content}"></td>
						</tr>
						<tr>
							<td id="fileIndex" colspan="2">
								<c:forEach var="file" items="${file}" varStatus="var">
									<div>
										<input type="hidden" id="FILE_NO" name="FILE_NO_${var.index}" value="${file.FILE_NO }">
										<input type="hidden" id="FILE_NAME" name="FILE_NAME" value="FILE_NO_${var.index}">
										<a href="#" id="fileName" onclick="return false;">${file.ORG_FILE_NAME}</a>(${file.FILE_SIZE}kb)>
										<button id="fileDel" onclick="fn_del('${file.FILE_NO}')" type="button">삭제</button>
									</div>
								</c:forEach>
							</td>
						</tr>
					</tbody>
				</table>
				<div style="margin-top:20px;margin-bottom:20px;">
					<input type = "hidden" value="${view.bno}" name = "seq" id = "seq">
					<button type="button" class="update_btn">저장</button>
					<button type="button" class="fileAdd_btn">파일추가</button>
				</div>
			</form>
		</section>
	</div>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
	<%@include file="/WEB-INF/views/user/common/footer.jsp" %>
</body>
</html>