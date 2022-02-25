<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script src="${path}/resources/js/review.js"></script>
<script>
	$(function() {
		if('${result}' == 1) {
			alert('수정 완료 되었습니다.');
		}
	});
	//댓글 수정 View
	function replyUpdateBtn(seq, rseq) {
		location.href = "/user/review/replyUpdateView?seq=" + seq
			+ "&page=${scri.page}"
			+ "&perPageNum=${scri.perPageNum}"
			+ "&searchType=${scri.searchType}"
			+ "&keyword=${scri.keyword}"
			+ "&rseq="+ rseq;
	}
	
	//댓글 삭제 View
	function replyDeleteBtn(seq , rseq) {
		location.href = "/user/review/replyDeleteView?seq=" + seq
			+ "&page=${scri.page}"
			+ "&perPageNum=${scri.perPageNum}"
			+ "&searchType=${scri.searchType}"
			+ "&keyword=${scri.keyword}"
			+ "&rseq="+ rseq;
	}
</script>
<title>게시글</title>
</head>
<body>


	<form id = "frm">
		<input type="hidden" id="seq" name="seq"/>
		<div>제목 : ${view.title} 조회수 : ${view.readCount}</div>
		<div>작성자 : ${view.name}</div>
		<div>내용 : ${view.content}</div>
		<img src="../image/21f030f1cd1d43e093a0a33745264bb7.jpg"/>
		<button type = "button" onclick='location.href="/user/review/list"'>목록</button>
		<button type = "button" onclick='goUpdateView(${view.seq})'>수정</button>
		<button type = "button" onclick='reviewDelete(${view.seq})'>삭제</button>	
	</form>
	
	<c:forEach var="file" items="${file}" varStatus="var">
		<a href="/user/review/fileDownLoad?fileNum=${file.FILENUM}">${file.ORG_FILE_NAME}</a>
		(${file.FILE_SIZE}kb)
	</c:forEach>
	
	<div id="reply">
		<ol class = "replyList">
			<c:forEach var="replyList" items="${replyList}">
				<li>
					<p>
						-----------댓글---------------<br/>
						작성자 :  ${loginVo} <br/>
						작성일 : <fmt:formatDate value="${replyList.regdate}" pattern="yyyy-MM-dd"/>
					</p>
					<p>${replyList.content}</p>
					<c:if test="${ loginVo != null }">
						<div>
			  				<button type="button"  onclick = "replyUpdateBtn(${view.seq}, ${replyList.rseq})">수정</button>
			 				<button type="button"  onclick = "replyDeleteBtn(${view.seq}, ${replyList.rseq})">삭제</button>
						</div>
					</c:if>
				</li>
			</c:forEach>
		</ol>
	</div>
	
	<section class="replyForm">
		<form role="form" method="post" action="/user/review/replyWrite">
			<input type="hidden" id="seq" name="seq" value="${view.seq}" readonly="readonly" />
			<input type="hidden" id="page" name="page" value="${scri.page}" readonly="readonly" />
			<input type="hidden" id="perPageNum" name="perPageNum" value="${scri.perPageNum}" readonly="readonly" />
			<input type="hidden" id="searchType" name="searchType" value="${scri.searchType}" readonly="readonly" />
			<input type="hidden" id="keyword" name="keyword" value="${scri.keyword}" readonly="readonly" />
			<input type="hidden" id="FILENUM" name="FILENUM" value="">
			<c:if test="${ loginVo == null }">
				<div>로그인 후 댓글 작성이 가능합니다.</div>
			</c:if>
			<c:if test="${ loginVo != null }">
			<p>
				<label for="writer">작성자</label>
				<input type="text" id="writer" name="writer" />
			</p>
			<p>
				<label for="content">댓글 내용</label>
				<textarea id="content" name="content"></textarea>
			</p>
			<p>
				<input type="submit" value="작성"/>
			</p>
			</c:if>
		</form>
</section>
</body>
</html>