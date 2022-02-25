<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
<meta charset="UTF-8">
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script src="${path}/resources/js/notice.js"></script>
	 	<title>공지사항</title>

</head>
<script type="text/javascript">
		$(document).ready(function(){
			var formObj = $("form[name='readForm']");
			
			// 수정 
			$(".update_btn").on("click", function(){
				formObj.attr("action", "/user/notice/noticeUpdate");
				formObj.attr("method", "post");
				formObj.submit();				
			})
			
			// 삭제
			$(".delete_btn").on("click", function(){
				formObj.attr("action", "/user/notice/noticeDelete");
				formObj.attr("method", "post");
				formObj.submit();
				alert('삭제되었습니다.');
			})
			
			// 취소
			$(".list_btn").on("click", function(){
				
				location.href = "/user/notice/noticeList";
			})
		});

	</script>
	<body>
		<section id="container">
			<form name="readForm" role="form" method="post">
				<input type="hidden" id="bno" name="bno" value="${read.bno}" />
			</form>
				<table>
					<tbody>
						<tr>
							<td><label for="title">제목</label><input type="text" id="title" name="title" value="${read.title}" readonly="readonly" /></td>
						</tr>	
						<tr>
							<td><label for="content">내용</label><textarea id="content" name="content" readonly="readonly"><c:out value="${read.content}" /></textarea>
						</tr>
						<tr>
							<td><label for="writer">작성자</label><input type="text" id="writer" name="writer" value="${read.name}"  readonly="readonly"/></td>
							</tr>
						<tr>
							<td>
								<label for="regdate">작성날짜</label>
								<fmt:formatDate value="${read.regdate}" pattern="yyyy-MM-dd" />					
							</td>
						</tr>		
					</tbody>			
				</table>
					<c:forEach var="file" items="${file}" varStatus="var">
						<a href="/user/notice/noticeFileDown?fileNo=${file.FILE_NO}">${file.ORG_FILE_NAME}</a>
						(${file.FILE_SIZE}kb)
					</c:forEach>
				<div>
					<button type="submit" class="update_btn">수정</button>
					<button type="submit" class="delete_btn">삭제</button>
					<button type="submit" class="list_btn">목록</button>	
				</div>
			</section>
	</body>	
</html>