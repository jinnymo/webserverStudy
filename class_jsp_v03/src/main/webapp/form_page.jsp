<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>
<div class="container">
		<h1>cm를 인치로 변환</h1>
		<form action="result.jsp" method="POST">
			<label for="num1">cm</label> 
			<input type="number" id="num1" name="num1" required="required">
			
			<input type="submit" value="변환">
		</form>
	</div>
<%@ include file="footer.jsp" %>