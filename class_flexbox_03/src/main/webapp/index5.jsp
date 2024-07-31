<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	body{
		display: flex;
		flex-direction: column;
	}
	.container{
		display: flex;
		flex-direction: row;
		flex-wrap: wrap;
		
		background-color: #f9f9f9;
		
		
	}
	.item{
		background-color: red;
		height:100px;
		flex:1;
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
	<div class="container">
		<div class="item">아이템 4</div>
		<div class="item">아이템 5</div>
		<div class="item">아이템 6</div>
	</div>
	<div class="container">
		<div class="item">아이템 7</div>
		<div class="item">아이템 8</div>
		<div class="item">아이템 9</div>
	</div>
</body>
</html>