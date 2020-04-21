<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MVC</title>
</head>
<body>
	<h1>EL 내장객체 - pageContext</h1>
	<hr>
	<h2>EL 미사용</h2>
	<%-- 
	<p>컨텍스트 경로 = <%=request.getContextPath() %></p>
	<p>요청 URI = <%=request.getRequestURI() %></p>
	--%>
	<p>컨텍스트 경로 = <%=((HttpServletRequest)pageContext.getRequest()).getContextPath()%></p>
	<p>요청 URI = <%=((HttpServletRequest)pageContext.getRequest()).getRequestURI() %></p>
	<hr>
	<h2>EL 사용</h2>
	<%-- EL 표현식으로 인스턴스의 메소드 호출 가능 --%>
	<%-- <p>컨텍스트 경로 = ${pageContext.getRequest().getContextPath() }</p> --%>
	<p>컨텍스트 경로 = ${pageContext.request.contextPath }</p> 
	<p>요청 URI = ${pageContext.request.requestURI }</p> 
</body>
</html>








