<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>JSP 전용태그 연습</h1>
	<% String name = "HELLO SPRING"; %>
	<!-- 주석 부분입니다. 소스보기에서 보이지요. -->
	<%-- 이 부분은 JSP 페이지에서만 보이고 소스보기를 해도 보이지 않아요! 브라우저에서 보내지 않는 문장 (사용자에게 보여주지 말아야하는 부분) --%>
	<%=name /* 표현식 안에서 사용하는 주석 입니다. */ %> <span>BOOT</span>
</body>
</html>