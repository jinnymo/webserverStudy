<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 페이지</title>
</head>
<body>
	<h2>로그인</h2>
	<!-- 로그인 처리는 예외적인 사항으로 post 요청을 하자 -->
	<form action="welcome.jsp" method="POST">
		<label for ="">username : </label>
		<input type="text" id="usernmae" name="username" value="홍길동">
		
		<label for ="">password : </label>
		<input type="password" id="password" nmae="password" value="1234">
		
		<button type="submit">로그인</button>
	</form>
</body>
</html>