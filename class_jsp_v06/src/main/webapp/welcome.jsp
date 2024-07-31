<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>testResult</title>
</head>
<body>
	<%
		
		String username = (String)session.getAttribute("username");
		long sessionTime = session.getCreationTime();
		String id = session.getId();
		if(username == null || username.trim().isEmpty()){
			username = request.getParameter("username");
			if(username != null && !username.trim().isEmpty()){
			}else{
				response.sendRedirect("test.jsp");
				return;
			}
		}

		Integer visitCount = (Integer)application.getAttribute("visitCount");
		if(visitCount == null){
			visitCount = 1;
		}else{
			visitCount++;
		}
		
		Date now = new Date();
		
	%>
	<h2>환영합니다.<%= username%></h2>
	<p>현재시간 : <%=now %></p>
	<p>방문횟수 : <%=visitCount %></p>
	<p>세션 유지 시간 : <%=sessionTime%></p>
	<p>세션 유지 시간 : <%=id%></p>
	
	
</body>
</html>