function searchCheck() {
			if (document.idSearchForm.email.value=="") {
				alert("이메일을 입력하세요");
				document.idSearchForm.email.focus();
				return;
			} else {
				var inputEmail = $('#email').val();
				console.log(inputEmail);
				$.ajax({
					url : "idForGot",
					type : 'post',
					data : {email : inputEmail},
					success : function(data) {
						if (data=="not") {
							alert("찾으신 아이디가 없습니다.");
						} else {
							$("#findId").text("찾으시는 아이디는 " + data +"입니다.");
						}
					}
				})
			}
		}