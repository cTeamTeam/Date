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
<title>Q&A 작성</title>
<link href="/date/resources/css/styles.css" rel="stylesheet" />
<link href="/date/resources/css/banner.css" rel="stylesheet" />
<link href="/date/resources/css/footer.css" rel="stylesheet" />
<link href="/date/resources/css/qaWrite.css" rel="stylesheet" />
<script type="text/javascript" src="/date/resources/js/scripts.js"></script>
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
    
    <h3 style="color:pink;font-weight:800;margin-top:60px;">Q&A 작성</h3>
    
    <div class="qaWriteWrap">
    	<form:form commandName="qaWrite" method="post">
    		<table>
    			<tr>
					<th class="qaWriteHead" colspan="2">Q&A</th>
				</tr>
    			<tr>
    				<td class="qaId">작성자</td>
    				<td><span class="qaWriteId">${loginVo}</span></td>
    			</tr>
    			<tr>
    				<td class="qaId">제목</td>
    				<td><form:input class="qaWriteTitle" path="title"/></td>
    			</tr>
    			<tr>
    				<td class="qaId" style="vertical-align:top;padding-top:10px;">내용</td>
    				<td colspan="2"><textarea class="qaWriteContent" cols="30" rows="10" name="content"></textarea>
    			</tr>	
				<tr>
					<td colspan="2">
						<button class="qaButton" type="submit">작성</button>
						<button class="qaButton" type="reset">리셋</button>
					</td>
				</tr> 		
    		</table>
    	</form:form>
    </div>
    
   <c:if test="${loginVo==null }">
   	<script type="text/javascript">
   		alert("로그인을 먼저 하세요");
   		location.href="/date/loginForm";
   	</script>
   </c:if>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
    <%@include file="/WEB-INF/views/user/common/footer.jsp" %>
</body>
</html>