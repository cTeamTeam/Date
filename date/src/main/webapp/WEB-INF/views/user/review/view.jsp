<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="/date/resources/css/styles.css" rel="stylesheet" />
<link href="/date/resources/css/banner.css" rel="stylesheet" />
<link href="/date/resources/css/footer.css" rel="stylesheet" />
<link href="/date/resources/css/qaContent.css" rel="stylesheet" />
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script src="/date/resources/js/review.js"></script>
<script>
	$(function() {
		if('${result}' == 1) {
			alert('수정 완료 되었습니다.');
		}
	});
	//댓글 수정 View
	function replyUpdateBtn(seq, rseq) {
		location.href = "/date/user/review/replyUpdateView?seq=" + seq
			+ "&page=${scri.page}"
			+ "&perPageNum=${scri.perPageNum}"
			+ "&searchType=${scri.searchType}"
			+ "&keyword=${scri.keyword}"
			+ "&rseq="+ rseq;
	}
	
	//댓글 삭제 View
	function replyDeleteBtn(seq , rseq) {
		location.href = "/date/user/review/replyDeleteView?seq=" + seq
			+ "&page=${scri.page}"
			+ "&perPageNum=${scri.perPageNum}"
			+ "&searchType=${scri.searchType}"
			+ "&keyword=${scri.keyword}"
			+ "&rseq="+ rseq;
	}
</script>
<title>게시글</title>
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

	<h3 style="color:pink;font-weight:800;margin-top:60px;">매칭 후기</h3>
	
	<table>
		<tr>
			<th class="qaWriteHead" colspan="2">매칭 후기</th>
		</tr>
		<tr style="height:40px;">
			<td class="qaId">제목</td>
			<td><span class="qaContent"> ${view.title}</span></td>
		</tr>
		<tr style="height:40px;">
			<td class="qaId">작성자</td>
			<td><span class="qaContent">${view.name}</span></td>
		</tr>
		<tr style="height:400px;">
			<td class="qaId" style="vertical-align:top; padding-top:10px;">내용</td>
			<td style="vertical-align:top; margin-top:20px;"><span class="qaContent">${view.content}</span></td>
		</tr>
		<tr style="height:40px;">
			<td class="qaId">조회수</td>
			<td><span class="qaContent">${view.readCount}</span></td>
		</tr>
	</table>
	
	<div style="margin-top:20px;">
	<c:forEach var="file" items="${file}" varStatus="var">
	<form id = "frm">
		<input type="hidden" id="seq" name="seq"/>
		<img width="400" height="350" src="/date/resources/metchImages/${file.STORED_FILE_NAME}"/>
	</form>
	</c:forEach>
	</div>
	
	<c:forEach var="file" items="${file}" varStatus="var">
		<a href="/date/user/review/fileDownLoad?fileNum=${file.FILENUM}">${file.ORG_FILE_NAME}</a>
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
			  				<button type="button" class="qaButton" onclick = "replyUpdateBtn(${view.seq}, ${replyList.rseq})">수정</button>
			 				<button type="button" class="qaButton" onclick = "replyDeleteBtn(${view.seq}, ${replyList.rseq})">삭제</button>
						</div>
					</c:if>
				</li>
			</c:forEach>
		</ol>
	</div>
	
	<section class="replyForm">
		<form role="form" method="post" action="/date/user/review/replyWrite">
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
		
		<div style="margin-bottom:20px;">
			<button class="qaButton" type="button" onclick='location.href="/date/user/review/list"'>목록</button>
			<button class="qaButton" type="button" onclick='goUpdateView(${view.seq})'>수정</button>
			<button class="qaButton" type="button" onclick='reviewDelete(${view.seq})'>삭제</button>	
		</div>
</section>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
<%@include file="/WEB-INF/views/user/common/footer.jsp" %>
</body>
</html>