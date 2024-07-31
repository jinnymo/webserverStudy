<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri ="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>jstl 예제</h1>
<c:set var="message" value="안녕하세요 jstl"></c:set>
<br>
<c:out value="${message}"></c:out>
</body>
</html>