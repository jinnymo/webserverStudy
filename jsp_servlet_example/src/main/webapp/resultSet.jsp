<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	out.println("resultset.jsp 파일임");

%>
<h1>사용자 목록</h1>
<table border="1">
	<thead>
		<tr>
			<th>id</th>
			<th>name</th>
			<th>email</th>		
		</tr>
	</thead>
	<tbody>
		<%
		
		List<Map<String,String>> userlist = (List<Map<String,String>>)request.getAttribute("userList"); 	
		if(userlist != null){
			for(Map<String,String> userMap : userlist){%>
					
					<tr>
						<td><%= userMap.get("id") %></td>
						<td><%= userMap.get("name") %></td>
						<td><%= userMap.get("email") %></td>
					</tr>
			<%}
		}else{%>
			<p>등록된 사용자가 없음</p>
		<%
		}
		%>
	</tbody>
	
	

</table>
</body>
</html>