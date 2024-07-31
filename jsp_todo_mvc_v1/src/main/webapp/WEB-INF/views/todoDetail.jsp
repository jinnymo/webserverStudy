<%@page import="com.tenco.model.TodoDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>수정</title>
</head>
<body>
<h1>detail page</h1>
	<!-- http://localhost:8080/mvc/todo/add -->
	
	<%
		TodoDTO todoDTO = (TodoDTO)request.getAttribute("todoDTO");
		String con = todoDTO.getDescription();
		String date = todoDTO.getDueDate();
		boolean complete = todoDTO.isCompleted();

	
	
	%>
	
	<form action="edit" method="post">
		<label for="title">제목 :</label>
		<input type="text" id="title" name="title" value="${todoDTO.getTitle()}"> 
		<br><br>
		<label for="description">설명 :</label>
		<textarea rows="10" cols="50" id="description" name="description" value="<%=con%>">
			그래얏 성공...............................
		</textarea>
		<br><br>
		<label for="dueDate">마감기한 :</label>
		<input type="date" id="dueDate" name="dueDate" value="<%=date%>"> 
		<br><br>
		<label for="completed">완료 여부:</label>
		<input type="hidden" name="id" value="<%=todoDTO.getId() %>">
		<input type="checkbox" id="completed" name="completed" value="true" 
		
		<%if(complete == true){%>
		checked="checked"
		<%	} %>

		> 
		
		<br><br>
		<button type="submit">수정</button>
	
	</form>
	<br><br>
	<a href="list">목록으로 돌아가기</a>

</body>
</html>