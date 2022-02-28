// 상세 페이지 이동
function goView(seq){
	$("#seq").val(seq);
	
	var f = $("#frm");
	
	f.attr("action", "/date/user/review/view");
	f.attr("method", "POST");
	f.submit();
};

function goUpdateView(seq){
	$("#seq").val(seq);

	var f = $("#frm");
	f.attr("action", "/date/user/review/goUpdateView");
	f.attr("method", "POST");
	f.submit();
};

//로그인 하지 않고 글쓰기 버튼 클릭시
function notLogin(){
	
	alert('로그인 후 이용해주세요.');
	location.href='/date/loginForm';
}

function reviewDelete(seq) {
	
	$("#seq").val(seq);

	var f = $("#frm");
	alert('삭제되었습니다.');
	f.attr("action", "/date/user/review/delete");
	f.attr("method", "POST");
	f.submit();
};

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