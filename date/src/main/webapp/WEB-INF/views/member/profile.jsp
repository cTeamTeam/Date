<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
function PreviewImage() {
	var preview = new FileReader();
    preview.onload = function (e) {
    document.getElementById("user_image").src = e.target.result;
};
preview.readAsDataURL(document.getElementById("user_profile_img").files[0]);
};


</script>
</head>
<body>
	<h1>Profile Regist</h1>
	<form:form commandName="profile">
		<table>
			<tr>
				<td>키</td>
				<td><form:input path="height"/></td>
			</tr>
			
			<tr>
				<td>몸무게</td>
				<td><form:input path="weight" /></td>
			</tr>
			
			<tr>
				<td>성격</td>
				<td><form:input path="character" /></td>
			</tr>
			
			<tr>
				<td>취미</td>
				<td><form:input path="hobby" /></td>
			</tr>
			
			<tr>
				<td>혈액형</td>
				<td><select name="bloodType">
						<option value="A">A</option>
						<option value="B">B</option>
						<option value="C">C</option>
						<option value="AB">AB</option>
					</select>
				</td>
			</tr>
			
			<tr>
				<td>직업</td>
				<td><form:input path="job"/>
			</tr>
			
			<tr>
				<td>연봉</td>
				<td><form:input path="salary"/>
			</tr>
			
			<tr>
				<td>주소</td>
				<td><form:input path="address"/>
			</tr>
			
			<tr>
				<td colspan="2">
					<p><span style="color:red">*</span> 이미지</p>
					<img id="user_image" src="#"  style="height:180px; width:150px;margin-top:10px;">
					<input style="margin-left:50px;" accept=".jpg" onchange="PreviewImage();" type="file" id="user_profile_img" name="imageFile" >
				</td>
			</tr>
			
			<tr>
				<td><button type="reset">다시 입력</button>
				<td><button type="submit">입력</button>
			</tr>	
		</table>
	</form:form>
</body>
</html>