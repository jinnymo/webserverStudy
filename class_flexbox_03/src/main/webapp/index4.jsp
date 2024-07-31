<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	.container{
		display: flex;
		flex-direction: column;
		height:300px;
		width:300px;
		flex-wrap: wrap;
		padding: 10px;
		background-color: aqua;
		border: 1px solid orange;
		border-radius: 20px;
		align-content: center;
		justify-content: center;
		
	}
	.item{
		background-color: red;
		height:150px;
		width:150px;
		border: none;
		border-radius: 8px;
		text-align: center;
		align-self: stretch;
		
	}

</style>
</head>
<body>
<%--
 	http:localhost:8080/class_flexbox_03/index.jsp
 --%>

	<h2>order 속성</h2>
	<div class="container">
		<div class="item">아이템 1</div>
		
	
	</div>
</body>
</html>