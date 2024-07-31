

<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>JSP 기본 태그 예제</h1>
	<%-- 스크립트 릿 : 현재 시간을 java 코드로 가져와서 출력 --%>
	<p> 현재 시간: <%
	
		java.util.Date now = new java.util.Date();
		//한국 시간 형식으로 포맷 설정하기
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-ddd HH:mm:ss");
		String formattedDate = sdf.format(now);
		out.println(formattedDate);
	%>
	</p>
</body>
</html>