<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MVC</title>
</head>
<body>
	<h1>EL 내장객체 - Request Header</h1>
	<hr>
	<h2>EL 미사용</h2>
	<ul>
		<li>서버명 = <%=request.getHeader("host") %></li> 
		<li>브라우저 종류 = <%=request.getHeader("user-Agent") %></li>
		<li>Accept = <%=request.getHeaders("accept").nextElement() %></li>
	</ul>
	<hr>
	<h2>EL 미사용</h2>
	<ul>
		<li>서버명 = ${header.host }</li> 
		<li>브라우저 종류 = ${header["user-Agent"]}</li>
		<li>Accept = ${headerValues.accept[0]}</li>
	</ul>
</body>
</html>







