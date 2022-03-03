<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
<script src="/date/resources/js/review.js"></script>
<script src="/date/resources/js/reviewForm.js"></script>
<body>
		
		<!-- 네비게이션 바 -->
		<%@include file="/WEB-INF/views/user/common/header.jsp" %>

		<h3 style="color:pink;font-weight:800;margin-top:60px;">매칭 후기</h3>
		<div id="root" class="qaWriteWrap">			
			<section id="container">
				<form name="writeForm" method="post"  enctype="multipart/form-data">
					<table>
						<tbody>
								<tr>
									<th class="qaWriteHead" colspan="2">매칭 후기</th>
								</tr>
								<tr>
									<td><label for="title" class="qaId">제목</label></td>
									<td>
										<input class="qaWriteTitle" type="text" id="title" name="title"  title="제목을 입력하세요."/>
									</td>
								</tr>	
								<tr>
									<td><label for="content" class="qaId">내용</label></td>
									<td>
										<textarea class="qaWriteContent" id="content" name="content"  title="내용을 입력하세요."></textarea>
									</td>
								</tr>
								<tr>
    								<td style="color:#BDBDBD;font-weight:800"><label for="writer" >작성자</label></td>
    								<td><span class="qaWriteId">${loginVo}</span></td>
    								<td>
										<input type="hidden" id="writer" name="name" value="${loginVo}" />
									</td>
    							</tr>
								<tr>
									<td id="fileIndex" colspan="2">
										<c:forEach var="file" items="${file}" varStatus="var">
											<div style="float:right">
												<input type="hidden" id="FILE_NO" name="FILE_NO_${var.index}" value="${file.FILENUM }">
												<input type="hidden" id="FILE_NAME" name="FILE_NAME" value="FILE_NO_${var.index}">
												<a href="#" id="fileName" onclick="return false;">${file.ORG_FILE_NAME}</a>(${file.FILE_SIZE}kb)>
												<button id="fileDel" onclick="fn_del('${file.FILENUM}','FILE_NO_${var.index}');" type="button">삭제</button>
											</div>
										</c:forEach>
									</td>
								</tr>
								<tr>
									<td colspan="2">						
										<button class="write_btn" type="submit">작성</button>	
										<button class="fileAdd_btn" type="button">파일추가</button>	
									</td>
								</tr>	
						</tbody>			
					</table>
				</form>
				
			</section>
		</div>
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>

		<%@include file="/WEB-INF/views/user/common/footer.jsp" %>
	</body>
</html>