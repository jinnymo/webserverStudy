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
		flex-wrap: wrap;
		padding: 10px;
		background-color: #f9f9f9;
		
		
	}
	.item{
		background-color: red;
		height:100px;
		border: 3px solid #000;
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
		<div class="item">아이템 2</div>
		<div class="item">아이템 3</div>
	
	</div>
</body>
</html>