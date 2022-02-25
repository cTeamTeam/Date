

// 상세보기 페이지 이동
function noticeView(bno){
	$("#bno").val(bno);
	
	var f = $("#root");
	f.attr("action", "/user/notice/noticeView");
	f.attr("method", "POST");
	f.submit();
};






































