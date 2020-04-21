<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MVC</title>
</head>
<body>
	<h1>EL 내장객체 - Context Init Parameter</h1>
	<hr>
	<h2>EL 미사용</h2>
	<p>web.xml 파일에 등록된 이름 = <%=config.getServletContext().getInitParameter("name") %></p>
	<hr>
	<h2>EL 사용</h2>
	<p>web.xml 파일에 등록된 이름 = ${initParam.name }</p>
</body>
</html>







