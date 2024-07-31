<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>계산 결과</title>
</head>
<body>
	<h1>계산 결과</h1>
	<%
		int num1 = Integer.parseInt(request.getParameter("num1"));
		int num2 = Integer.parseInt(request.getParameter("num2"));
		
		out.println("넘겨 받은갑  : "+ num1+" && "+num2);
		
		out.println("<br><br>");	
		out.println("두 값의 합은 : "+ (num1+num2));
		
		out.println("<br><br>");	
		out.println("두 값의 빼기 : "+ (num1-num2));
		
		out.println("<br><br>");
		out.println("두 값의 나눗셈 : "+ (num1/num2));
		
		out.println("<br><br>");
		out.println("두 값의 곱 : "+ (num1*num2));
		
	%>
</body>
</html>