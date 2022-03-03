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
<script src="/date/resources/js/resources/js/review.js"></script>
<script src="/date/resources/js/reviewUpdate.js"></script>
<title>게시글 수정</title>
</head>
<body>
	<!-- 네비게이션 바 -->
		<%@include file="/WEB-INF/views/user/common/header.jsp" %>

		<h3 style="color:pink;font-weight:800;margin-top:60px;margin:auto">매칭 후기</h3>
		
		<div id="root">
		<section id="container">
			<form name="updateForm" role="form" method="post" action="/date/user/review/update" enctype="multipart/form-data">
				<input type="hidden" name="seq" value="${update.seq}" readonly="readonly"/>
				<input type="hidden" id="page" name="page" value="${scri.page}"> 
				<input type="hidden" id="perPageNum" name="perPageNum" value="${scri.perPageNum}"> 
				<input type="hidden" id="searchType" name="searchType" value="${scri.searchType}"> 
				<input type="hidden" id="keyword" name="keyword" value="${scri.keyword}">
				<table>
					<tbody>
						<tr>
							<th class="qaWriteHead" colspan="2">매칭 후기</th>
						</tr>
						<tr>
							<td><label for="title" class="qaId">제목</label></td>
							<td><input class="qaWriteTitle" type="text" placeholder = "제목" id = "title" name = "title" value="${view.title}"></td>
						</tr>
						<tr>
							<td style="color:#BDBDBD;font-weight:800"><label for="writer" >작성자</label></td>
							<td>
								<input type="text" placeholder="작성자" id="name" name="name" readonly="readonly" value="${view.name}">
							</td>
						</tr>
						<tr>
							<td><label for="content" class="qaId">내용</label></td>
							<td>
								<input class="qaWriteContent" type="text" placeholder="내용" id="content" name="content" value="${view.content}">
							</td>
						</tr>
						<tr>
							<td id="fileIndex" colspan="2">
								<c:forEach var="file" items="${file}" varStatus="var">
									<div>
										<input type="hidden" id="FILE_NO" name="FILE_NO_${var.index}" value="${file.FILENUM }">
										<input type="hidden" id="FILE_NAME" name="FILE_NAME" value="FILE_NO_${var.index}">
										<a href="#" id="fileName" onclick="return false;">${file.ORG_FILE_NAME}</a>(${file.FILE_SIZE}kb)
										<button id="fileDel" onclick="fn_del('${file.FILENUM}')" type="button">삭제</button>
									</div>
								</c:forEach>
							</td>
						</tr>
					</tbody>
				</table>
				<div style="margin-top:20px;margin-bottom:20px;">
					<input type = "hidden" value="${view.seq}" name = "seq" id = "seq">
					<button type="button" style="color:white;background-color:pink;font-weight:800;border:none;width:50px;height:35px;border-radius:6%"
					class="update_btn">저장</button>
					<button type="button" class="fileAdd_btn">파일추가</button>
				</div>
			</form>
		</section>
	</div>
	
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>

	<%@include file="/WEB-INF/views/user/common/footer.jsp" %>
</body>
</html>