<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//쿠키값으로 문자열만 저장 가능하며 한글 저장 불가능
	Cookie cookie=new Cookie("userName","HongGilDong");
	cookie.setMaxAge(60*60);
	response.addCookie(cookie);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MVC</title>
</head>
<body>
	<h1>EL 내장객체 - Cookie</h1>
	<hr>
	<p>클라이언트에게 쿠키 전달 - 클라이언트에 쿠키 저장</p>
	<p><a href="implicit_cookie_use.jsp">쿠키 사용</a></p>
</body>
</html>







