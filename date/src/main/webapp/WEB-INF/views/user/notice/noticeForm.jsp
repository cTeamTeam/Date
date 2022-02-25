<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<meta charset="UTF-8">
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script src="${path}/resources/js/notice.js"></script>
<title>공지사항 작성</title>
</head>
<script src="${path}/resources/js/review.js"></script>
	<script type="text/javascript">
		$(document).ready(function(){
			var formObj = $("form[name='writeForm']");
			$(".write_btn").on("click", function(){
				if(fn_valiChk()){
					return false;
				}
				formObj.attr("action", "/user/notice/noticeWrite");
				formObj.attr("method", "post");
				formObj.submit();
			});
			fn_addFile();
		})
		function fn_valiChk(){
			var regForm = $("form[name='writeForm'] .chk").length;
			for(var i = 0; i<regForm; i++){
				if($(".chk").eq(i).val() == "" || $(".chk").eq(i).val() == null){
					alert($(".chk").eq(i).attr("title"));
					return true;
				}
			}
		}
		function fn_addFile(){
			var fileIndex = 1;
			$(".fileAdd_btn").on("click", function(){
				$("#fileIndex").append("<div><input type='file' style='float:left;' name='file_"+(fileIndex++)+"'>"+"</button>"+"<button type='button' style='float:right;' id='fileDelBtn'>"+"삭제"+"</button></div>");
			});
			$(document).on("click","#fileDelBtn", function(){
				$(this).parent().remove();
				
			});
		}
	</script>
	<body>
	
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
	</body>
</html>
