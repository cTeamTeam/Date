<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<meta name="description" content="" />
<meta name="author" content="" />
<title>결제 페이지</title>
<link href="/date/resources/css/styles.css" rel="stylesheet" />
<script type="text/javascript" src="/date/resources/js/scripts.js"></script>
<link href="/date/resources/css/banner.css" rel="stylesheet" />
<link href="/date/resources/css/pay.css" rel="stylesheet" />
<script type="text/javascript" src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<link href="/date/resources/css/footer.css" rel="stylesheet" />
<link href="/date/resources/css/dropdown.css" rel="stylesheet" />
<script type="text/javascript" src="https://service.iamport.kr/js/iamport.payment-1.1.8.js"></script>
</head>
<body>
<!-- 네비게이션 바 -->
<%@include file="/WEB-INF/views/user/common/header.jsp" %>
 	
 	
 	<div class="pay_wrap" style="margin-top:60px;height:700px">
 		<div style="display:inline-block;margin-right:80px;">
 			<img class="payImg" src="/date/resources/images/date.jpg" width="400" height="500">
 		</div>
 		<div style="display:inline-block;vertical-align:top">
 			<div class="payTitle"><strong>데이트 이용권</strong></div>
 			<div class="payPrice" id="price">
 				6000
 			</div>
 			<div class="payPrice">
 				원
 			</div>
 			<div style="margin-top:25px;margin-bottom:25px;">
 				<select name="payService" class="selectBox">
 					<option id="product" value="데이트 이용권">데이트 1회 이용권</option>
 		 		</select>
 			</div>
 			<div>
 				<button type="button" class="minus">-</button>
 				<input type="number" class="numBox" min="1" max="20" value="1" readonly="readonly"/>
 				<button type="button" class="plus">+</button>
 
 			<script type="text/javascript">
  				$(".plus").click(function(){
   					var num = $(".numBox").val();
  					var plusNum = Number(num) + 1;
   
   					if(plusNum >= 20) {
    					$(".numBox").val(num);
   					} else {
    					$(".numBox").val(plusNum);          
   					}
  				});
  
  				$(".minus").click(function(){
   					var num = $(".numBox").val();
   					var minusNum = Number(num) - 1;
   
   					if(minusNum <= 0) {
    					$(".numBox").val(num);
   					} else {
    					$(".numBox").val(minusNum);          
   					}
  				});
 			</script>
 			</div>
 			
 			
 			<div style="height:50px;">
 				<button class="payButton" id="check_module" type="button">카카오페이 결제</button>
 				
 				<script type="text/javascript">
    $("#check_module").click(function () {
    	//상품명
    	var product_name = $('#product').val();
    	//상품 1개 가격
    	var price = $('#price').text();
    	//수량
    	var num = $('.numBox').val();
    	//상품 총 가격
    	var total_price = price * num;
		//구매자
    	var buyer = "${loginVo}";
    	
    	//var IMP = window.IMP; // 생략가능
    	IMP.init('imp45279189');
    	IMP.request_pay({
    		pg: 'kakao',
    		pay_method: 'card',
    		merchant_uid: 'merchant_' + new Date().getTime(),
    		name: product_name,
    		amount: total_price,
    		buyer_name: buyer,
    		m_redirect_url: 'https://www.yourdomain.com/payments/complete'

    	}, function (rsp) {
    		console.log(rsp);
    		if (rsp.success) {
    			var msg = '결제가 완료되었습니다.';
    			
    			$.ajax({
    				url : "payment",
    				type : 'post',
    				data : {buyer: buyer, num: num, totalPrice : total_price, price : price},
    				success : function(data) {
    					if (data==1) {
    						alert(msg);
    					}
    				}
    			})
    			
    		} else {
    			var msg = '결제에 실패하였습니다.';
    			//msg += '에러내용 : ' + rsp.error_msg;
    		}
    		
    		});
    });


	</script>
 			</div>
 		</div>
 	</div>

    
    <c:if test="${loginVo==null }">
    	<script type="text/javascript">
    		alert("로그인 후 이용 가능합니다");
    		location.href="/date/loginForm";
    	</script>
    </c:if>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
    
    <%@include file="/WEB-INF/views/user/common/footer.jsp" %>
</body>
</html>