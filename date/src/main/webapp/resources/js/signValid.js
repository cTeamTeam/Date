
//패스워드 일치하는지 검사
$("#passwordCheck").blur(function() {
	var password = $('#password').val();
	var pwCheck = $('#passwordCheck').val();

	if (password!=pwCheck) {
		$("#pw_check").text("비밀번호가 일치하지 않습니다.");
		$("#pw_check").css('color', 'red');
	} else {
		$("#pw_check").text("비밀번호가 일치합니다.");
		$("#pw_check").css('color', 'green');
	}
});

//아이디 길이, 아이디 중복확인
$("#id").blur(function() {
	var id = $('#id').val();
	$.ajax({
		url : "idCheck",
		type : 'post',
		data : {id : id},
		success : function(data) {
			if (id.length<8 || id.length>15) {
				$("#id_check").text("8자리 이상 12자리이하로 입력하세요.");
				$("#id_check").css('color', 'red');
			} else {
				if (data==1) {
					$("#id_check").text("사용중인 아이디입니다.");
					$("#id_check").css('color', 'red');
				} else if (data==0) {
					$("#id_check").text("사용가능한 아이디입니다.");
					$("#id_check").css('color', 'green');
				}
			}
			
		}
		})
});

//닉네임 중복 체크
$("#nickName").blur(function() {
	var nickName = $('#nickName').val();
	$.ajax({
		url : "nickNameCheck",
		type : 'post',
		data : {nickName : nickName},
		success : function(data) {
			if (nickName=="") {
				$("#nick_check").text("닉네임을 입력하세요");
				$("#nick_check").css('color', 'red');
			} else {
				if (data == 1) {
					$("#nick_check").text("이미 사용중인 닉네임입니다.");
					$("#nick_check").css('color', 'red');
				} else if (data == 0) {
					$("#nick_check").text("사용가능한 닉네임입니다.");
					$("#nick_check").css('color', 'green');
				}
			}			
		}
		})
});

//빈값들 체크
function nullCheck() {
		if ($('#id').val()=="") {
			alert("아이디를 입력하세요");
			$('#id').focus();
		}
		else if ($('#password').val()=="") {
			alert("비밀번호를 입력하세요");
			$('#password').focus();
		}
		else if ($('#passwordCheck').val()=="") {
			alert("비밀번호 확인란을 입력하세요");
			$('#passwordCheck').focus();
		} else if ($('#name').val()=="") {
			alert("이름을 입력하세요");
			$('#name').focus();
		} else if ($('#nickName').val()=="") {
			alert("닉네임을 입력하세요");
			$('#nickName').focus();
		} else if ($('#birth').val()=="") {
			alert("생년월일을 입력해주세요");
			$('#birth').focus();
		} else if ($('#gender').val()=="") {
			alert("성별을 입력해주세요");
			$('#gender').val()=="".focus();
		} else if ($('#phoneNum').val()=="") {
			alert("전화번호를 입력해주세요");
			$('#phoneNum').focus();
		} else if ($('#email').val()=="") {
			alert("이메일을 입력해주세요");
			$('#email').focus();
		} else if ($('#authKey').val()=="") {
			alert("이메일을 인증하세요");
			return;
		}
		else {
			registForm.submit();
		}
	}

//중복 이메일 확인
$('#email').blur(function() {
		var email = $('#email').val();
		var filter = /^([\w-\.]+)@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.)|(([\w-]+\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\]?)$/;
		
		$.ajax({
			url : "emailCheck",
			type : 'post',
			data : {email : email},
			success : function(data) {
				if (email=="") {
					$("#email_check").text("이메일을 입력하세요");
					$("#email_check").css('color', 'red');
				} else {
					if (filter.test(email) === false && email!="") {
						$("#email_check").text("올바른 이메일 형식이 아닙니다.");
						$("#email_check").css('color', 'red');
					} else {
						if (data != 0) {
							$("#email_check").text("이미 사용중인 이메일.");
							$("#email_check").css('color', 'red');
						} else if (data == 0) {
							$("#email_check").text("사용가능한 이메일입니다.");
							$("#email_check").css('color', 'green');
						}
					}		
				}		
			}
			})
	});

//입력한 이메일로 인증번호 전송
$("#authKeySend").click(function() {
	var email = $("#email").val();
	var authKey = $("#authKeyInput").val();
	
	//이메일을 입력하지 않고 인증을 눌렀을때 리턴
	if (email=="") {
		$("#email_check").text("이메일을 입력하세요.");
		$("#email_check").css("color","red");
		return;
	}
	
	//이메일 발송 성공했을때 ajax로 authKeySend에 매핑하여 데이터 전달
	alert("인증번호를 발송하였습니다.\n입력한 이메일에서 인증번호를 확인해주세요.");
	console.log(email);
	$.ajax({
		url : "authKeySend",
		type : 'GET',
		cache:false,
		data : {email : email},
		
		//데이터 전송 성공 후
		success : function(data) {
			
			//인증하기 버튼 클릭했을때 이벤트 (인증번호 일치여부)
			$("#authKeyInput").click(function() {
				if ($("#authKey").val()=="") {
					$("#successEmailCheck").text("인증번호를 입력하세요.");
					$("#successEmailCheck").css("color","red");
				} else {
					if ($("#authKey").val()==data) {
						$("#successEmailCheck").text("인증에 성공하였습니다");
						$("#successEmailCheck").css("color","green");
					} else {
						$("#successEmailCheck").text("인증번호가 일치하지 않습니다.");
						$("#successEmailCheck").css("color","red");
					}
				}
			});
				
		}
	})
});