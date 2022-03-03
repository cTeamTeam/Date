<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
<link href="/date/resources/css/styles.css" rel="stylesheet" />
<link href="/date/resources/css/banner.css" rel="stylesheet" />
<link href="/date/resources/css/footer.css" rel="stylesheet" />
<link href="/date/resources/css/dropdown.css" rel="stylesheet" />
<script
	src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<title>게시판</title>
</head>
<body>
	<!-- 네비게이션 바 -->
	<%@include file="/WEB-INF/views/user/common/header.jsp" %>
	<div id="root">
		<h3 style="color:pink;font-weight:800;margin-top:60px;">매칭 후기</h3>
		<hr />

		<div>
			<%@include file="nav.jsp"%>
		</div>
		<hr />

		<section id="container">
			<form name="updateForm" role="form" method="post" action="/date/user/review/replyUpdate">
				<input type="hidden" name="seq" value="${replyUpdate.seq}"
					readonly="readonly" /> <input type="hidden" id="rseq" name="rseq"
					value="${replyUpdate.rseq}" /> <input type="hidden" id="page"
					name="page" value="${scri.page}"> <input type="hidden"
					id="perPageNum" name="perPageNum" value="${scri.perPageNum}">
				<input type="hidden" id="searchType" name="searchType"
					value="${scri.searchType}"> <input type="hidden"
					id="keyword" name="keyword" value="${scri.keyword}">
				<table style="margin:auto;margin-bottom:20px;">
					<tbody>
						<tr>
							<td><label for="content">댓글 내용</label><input type="text"
								id="content" name="content" value="${replyUpdate.content}" /></td>
						</tr>

					</tbody>
				</table>
				<div>
					<button id="btn" type="submit">저장</button>
					<button id="btn" type="button" class="cancel_btn">취소</button>
				</div>
			</form>
		</section>
	</div>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
	<%@include file="/WEB-INF/views/user/common/footer.jsp" %>
</body>
</html>