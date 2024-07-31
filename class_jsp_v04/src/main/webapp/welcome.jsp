<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>환영해요</title>
</head>
<body>
	<%
	
		//session 객체를 사용하여 사용자 정보가 여부를 확인하자.
		String username = (String)session.getAttribute("username");
		
		if(username == null || username.trim().isEmpty()){
			//request 객체에서 사용자 정보를 추출하자.
			username = request.getParameter("username");
			if(username != null && !username.trim().isEmpty()){
				// 홍길동 ok
				// "" 빈칸이라면 x
				//세션 객체를 사용해서 사용자 정보를 저장(속성과 값을)
				session.setAttribute("username", username);
			}else{
				//사용자가 정상적인 데이터를 보내지 않았다면
				response.sendRedirect("logiin.jsp");
				return;
			}
		}

		//어플리케이션 내장객체를 사용ㅇ하여 방문횟수 증가
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
</body>
</html>