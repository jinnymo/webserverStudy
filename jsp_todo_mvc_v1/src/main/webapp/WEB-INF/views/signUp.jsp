<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<link rel="stylesheet" type="text/css" href="../css/styles.css">
</head>
<body>
<%
	//String eMessage = (String)request.getAttribute("message");
	String eMessage = (String)request.getParameter("message");
	if(eMessage != null){
	%>
	<p style="color: red"><%=eMessage %></p>
		
<%	} %>

<h1>회원가입 jsp 파일 입니다.</h1>

<form action="/mvc/user/signUp"  method="post">

	<label>사용자 이름 :</label>
	<input type="text" id="username" name="username" value="야스오">
	<label>비밀번호 :</label>
	<input type="text" id="password" name="password" value="1234">
	<label>이메일 :</label>
	<input type="text" id="email" name="email" value="a@naver.com">
	<button type="submit">회원가입</button>	
</form>
</body>
</html>