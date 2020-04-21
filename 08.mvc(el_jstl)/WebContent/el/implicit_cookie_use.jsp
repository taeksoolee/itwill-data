<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MVC</title>
</head>
<body>
	<h1>EL 내장객체 - Cookie</h1>
	<hr>
	<h2>EL 미사용</h2>
	<%
		Cookie[] cookies=request.getCookies();
		String userName="";
		for(Cookie cookie:cookies) {
			if(cookie.getName().equals("userName")) {
				userName=cookie.getValue();
			}
		}
	%>
	<p>쿠키에 저장된 사용자명 = <%=userName %></p>
	<hr>
	<h2>EL 사용</h2>
	<p>쿠키에 저장된 사용자명 = ${cookie.userName.value }</p>
	<p>JSESSIONID = ${cookie.JSESSIONID.value }</p>
</body>
</html>








