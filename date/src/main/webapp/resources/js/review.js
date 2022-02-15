
// 글등록
function reviewSubmit(){
	

	var form = $('#frm')[0];
	var formData = new FormData(form);

	$.ajax({
		type : "POST",
		enctype : 'multipart/form-data',
		url : "/user/review/reviewWriting",
		data : formData,
		dataType : 'json',
		processData : false,
		contentType : false,
		success: function(data) {
			if(data.result == "Y"){
				alert("글 등록이 완료되었습니다.");
				console.log("success :" , data);
				location.href = "/user/review/list";		
			}
		},
		error: function(data) {
			alert("실패");
			console.log("error :" , data);
		}
	});
}

// 파일 다운로드
function fileDown(fileNum){
	$.ajax({
		type : "POST",
		url : "/user/review/fileDownLoad",
		data : {'fileNum' : fileNum},
		success: function(data) {
			alert('성공');
		},
		error : function(data){
			alert("실패");
		}
	});	
}

// 리뷰 수정
function reviewUpdate(){
	var seq = $("#seq").val();
	var title = $("#title").val();
	var name = $("#name").val();
	var content = $("#content").val();
	var regDate = $("#regDate").val();
	var readCount = $("#readCount").val();
	
	$.ajax({
		type : "POST",
		url : "/user/review/update",
		data : {seq : seq , title : title , name : name , content : content , regDate : regDate , readCount : readCount},
		success: function(data){
			if(data == "Y"){
				alert("글 수정이 완료 되었습니다.");
				location.href = "/user/review/list";
			}
		},
		error: function(data){
			alert("실패");
			console.log(data);
		}
	});
}

// 리뷰 삭제
function reviewDelete(seq){
	$.ajax({
		type : "POST",
		url : "/user/review/delete",
		data : {seq: seq},
		success : function(data){
			if(data == "Y"){
				alert("글 삭제 완료 되었습니다.");
				location.href = "/user/review/list";
			}
		},
		error : function(data){
			alert("실패");
			console.log(data);
		}
	});
}


function goView(seq){
	$("#seq").val(seq);

	var f = $("#frm");
	f.attr("action", "/user/review/view");
	f.attr("method", "POST");
	f.submit();
};

function goUpdateView(seq){
	$("#seq").val(seq);

	var f = $("#frm");
	f.attr("action", "/user/review/goUpdateView");
	f.attr("method", "POST");
	f.submit();
};
































