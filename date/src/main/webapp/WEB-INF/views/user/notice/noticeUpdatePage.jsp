<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script src="${path}/resources/js/notice.js"></script>
<title>공지사항 수정</title>
</head>	
	<script type="text/javascript">
		$(document).ready(function(){
			var formObj = $("form[name='updateForm']");
			
			$(document).on("click","#fileDel", function(){
				$(this).parent().remove();
			})
			
			fn_addFile();
			
			$(".cancel_btn").on("click", function(){
				event.preventDefault();
				location.href = "/user/notice?bno=${update.bno}"
					   + "&page=${scri.page}"
					   + "&perPageNum=${scri.perPageNum}"
					   + "&searchType=${scri.searchType}"
					   + "&keyword=${scri.keyword}";
			})
			
			$(".update_btn").on("click", function(){
				if(fn_valiChk()){
					return false;
				}
				formObj.attr("action", "/user/notice/noticeWrite");
				formObj.attr("method", "post");
				formObj.submit();
			})
		})
			
		function fn_valiChk(){
			var updateForm = $("form[name='updateForm'] .chk").length;
			for(var i = 0; i<updateForm; i++){
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
 		
 		function fn_del(fileNo) {
 			$('#keyword').parent().append('<input type="hidden" name="fileDel" value="' + fileNo + '"/>');
 		}
	</script>
<body>
	<div id="root">
		<section id="container">
			<form name="updateForm" role="form" method="post"  enctype="multipart/form-data">
				<input type="hidden" name="seq" value="${update.seq}" readonly="readonly"/>
				<input type="hidden" id="page" name="page" value="${scri.page}"> 
				<input type="hidden" id="perPageNum" name="perPageNum" value="${scri.perPageNum}"> 
				<input type="hidden" id="searchType" name="searchType" value="${scri.searchType}"> 
				<input type="hidden" id="keyword" name="keyword" value="${scri.keyword}">
				<table>
					<tbody>
						<tr>
							<td>제목 : <input type = "text" placeholder = "제목" id = "title" name = "title" value="${read.title}"></td>
						</tr>
						<tr>
							<td>작성자 : <input type="text" placeholder="작성자" id="name" name="name" readonly value="${loginVo}"></td>
						</tr>
						<tr>
							<td>내용 : <input type="text" placeholder="내용" id="content" name="content" value="${read.content}"></td>
						</tr>
						<tr>
							<td id="fileIndex">
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
				<div>
					<input type = "hidden" value="${view.bno}" name = "seq" id = "seq">
					<button type="button" class="update_btn">저장</button>
					<button type="button" class="fileAdd_btn">파일추가</button>
				</div>
			</form>
		</section>
	</div>
</body>
</html>