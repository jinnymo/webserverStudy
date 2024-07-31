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
		flex-wrap: wrap;
		border: 2px solid #333;
		padding: 10px;
		background-color: #f9f9f9;
	}
	div{
		
	}
	.item{
	
	}
	.order-1{
	
	}

</style>
</head>
<body>
<%--
 	http:localhost:8080/class_flexbox_03/index.jsp
 --%>

	<h2>order 속성</h2>
	<div class="container">
		<div class="item order-2" style="flex: 0.5">아이템 1</div>
		<div class="item order-1"style="flex: 1.5">아이템 2</div>
		<div class="item order-3"style="flex: 1">아이템 3</div>
	
	</div>
</body>
</html>