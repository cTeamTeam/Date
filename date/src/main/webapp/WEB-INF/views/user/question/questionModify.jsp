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
<title>Q&A 수정</title>
<link href="/date/resources/css/styles.css" rel="stylesheet" />
<link href="/date/resources/css/banner.css" rel="stylesheet" />
<link href="/date/resources/css/footer.css" rel="stylesheet" />
<link href="/date/resources/css/qaWrite.css" rel="stylesheet" />
<link href="/date/resources/css/dropdown.css" rel="stylesheet" />
<script type="text/javascript" src="/date/resources/js/scripts.js"></script>
</head>
<body>
<!-- 네비게이션 바 -->
<%@include file="/WEB-INF/views/user/common/header.jsp" %>
    
    <h3 style="color:pink;font-weight:800;margin-top:60px;">Q&A 수정</h3>
    
    <div class="qaWriteWrap">
    <form:form method="post" commandName="qaModify">
    	<table>
    		<tr>
				<th class="qaWriteHead" colspan="2">Q&A</th>
			</tr>
			<tr>
    			<td class="qaId">작성자</td>
    			<td><span class="qaWriteId">${modify.id }</span></td>
    		</tr>
    		<tr>
    			<td class="qaId">제목</td>
    			<td><form:input class="qaWriteTitle" path="title" value="${modify.title }"/>
    		</tr>
    		<tr>
    			<td class="qaId" style="vertical-align:top;padding-top:10px;">내용</td>		
    			<td>
    				<textarea class="qaWriteContent" cols="30" rows="10"name="content">${modify.content }</textarea>
    			</td>
    		</tr>
    		<tr>
    			<td colspan="2">
    				<button class="qaButton" type="submit">수정</button>
    				<button class="qaButton" type="reset">리셋</button>
    			</td>
    		</tr>
    	</table>	
    </form:form>
    </div>
    
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
    <%@include file="/WEB-INF/views/user/common/footer.jsp" %>
</body>
</html>