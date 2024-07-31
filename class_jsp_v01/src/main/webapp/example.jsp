<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%
	//localhost:8080/jsp/example.jsp
	//초기화 단계(jsp intit() 역할)
	if(application.getAttribute("initialized") == null){
		application.setAttribute("initialized", true);
		application.setAttribute("initializedTime", new Date());
		out.println("JSP가 초기화 되었습니다.<br>");
	}

	out.println("요청이 완료 되었습니다.<br>");
	out.println("현재 시간 : "+new Date() +"<br>");
	
	//세션이라는 전역 메모리에 데이터를 저장하고 확인해 보자
	String msg = (String)session.getAttribute("msg");
	if(msg != null){
		out.println("세션 메세지 : "+ msg);
	}else{
		out.println("저장된 세션 메세지가 없습니다.");
	}
	
	session.setAttribute("msg","안녕 세션에 저장한 메세지");

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>JSP 라이프 사이클 확인</h1>
<p>이 페이지에 학습 목적은 JSP동작 방식에 대한 이해와 라이프 사이클 입니다.</p>
<img style="display: block;-webkit-user-select: none;margin: auto;background-color: hsl(0, 0%, 90%);transition: background-color 300ms;" 
src="http://localhost/as.png">
</body>
</html>
<%
//소멸 단계 호가인 (JspDestroy)
if(application.getAttribute("initialized")!=null){
	application.removeAttribute("initialized");
	application.removeAttribute("initializedTime");
	out.println("JSP 객체가(서블릿) 소멸 되었습니다.<br>");
}

%>