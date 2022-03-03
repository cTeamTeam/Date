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