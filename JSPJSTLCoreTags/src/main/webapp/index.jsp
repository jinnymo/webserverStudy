<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri ="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@taglib uri ="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>jstl 예제</h1>
<c:set var="message" value="안녕하세요 jstl 하이"></c:set>
<br>
<h1><c:out value="${message}"></c:out></h1>

<!-- IF -->
<% String a = "가나다"; %>
<c:set var="a" value="<%=a %>"/>
<c:if test="${message != null}">
	<p>메세지 값이 null 이 아님</p>
	<c:out value="${a}"></c:out>
</c:if>

<!-- ForEach -->
<c:forEach var="i" begin="1" end="10" step="1">
	<p>Number : ${i}</p>
</c:forEach>

<!-- format -->
<h2>JSTL Formatting Example</h2>
<c:set var="now" value="<%=new Date() %>"></c:set>
<fmt:formatDate var="formattedDAte" value="${now}" pattern="yyyy-MM-dd HH:mm:ss"/>
<p>현재 시간 : ${formattedDAte }</p>


<c:set var="price" value="12345.678"></c:set>
<fmt:formatNumber value="${price }" type="currency" var="formatPrice"></fmt:formatNumber>
<p>Format Price : ${formatPrice}</p>
</body>
</html>