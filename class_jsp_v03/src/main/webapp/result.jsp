<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ include file="header.jsp" %>


<h1>변환 결과</h1>
	<%
		double num1 = Double.parseDouble(request.getParameter("num1"));
		
		
		out.println("<br><br>");	
		out.println( (num1*0.394) +"inch");
	%>
	
<%@ include file="footer.jsp" %>