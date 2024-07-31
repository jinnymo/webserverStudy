

<%@page import="java.util.Date"%>
<%@page import="java.util.Random"%>
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
	<%-- 표현식 : 임의의 숫자를 생성해서 출력 --%>
	<p>임의의 숫자 : <%=new Random().nextInt(100) %></p>


	<%-- 선언문 : 사용자 정의 메서드 선언--%>
	<%!
		public String getwelcomeMessage(String name){
		return "환영한다."+name+"!!!";
	}
	%>
	
	<p><%= getwelcomeMessage("김동윤")  %></p>
	<%
		Integer visitCounter = (Integer)application.getAttribute("visitCount");
		if(visitCounter == null){
			visitCounter = 1;
		}else{
			visitCounter +=1;
		}
		application.setAttribute("visitCount", visitCounter);
	%>
	<p>현재 페이지 방문 횟수 : <%= visitCounter %></p>
	
	<%
		int second = new Date().getSeconds();
		String color;	
	if (second <20){
		color= "#abc3dg";
		}else if(second <40){
		color= "#2d23dg";
			
		}else {
			
		color= "#hd33dg";
		}
		
	%>
	<style>
		body{
			background-color: <%=color%>
		}
		
	</style>
	


</body>
</html>