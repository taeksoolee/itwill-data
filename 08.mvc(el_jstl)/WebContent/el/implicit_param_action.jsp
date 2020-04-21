<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MVC</title>
</head>
<body>
	<h1>EL 내장객체 - Request Parameter</h1>
	<hr>
	<h2>EL 미사용</h2>
	<ul>
		<li>이름 = <%=request.getParameter("name") %></li>	
		<li>주소 = <%=request.getParameter("address") %></li>
		<%-- 입력태그의 name 속성값이 같은 경우 첫번째 입력태그의 입력값을 반환받아 사용 --%>
		<%-- 	
		<li>음식-1 = <%=request.getParameter("food") %></li>	
		<li>음식-2 = <%=request.getParameter("food") %></li>
		--%>	
		<li>음식-1 = <%=request.getParameterValues("food")[0] %></li>	
		<li>음식-2 = <%=request.getParameterValues("food")[1] %></li>
	</ul>
	<hr>
	<h2>EL 사용</h2>
	<ul>
		<%-- EL 표현식에서 param 내장객체를 이용하여 전달값을 반환받아 출력 --%>
		<%-- => 입력태그의 name 속성값을 이용하여 전달값 구분 --%>
		<li>이름 = ${param.name }</li>	
		<li>주소 = ${param.address }</li>
		<li>음식-1 = ${paramValues.food[0] }</li>	
		<li>음식-2 = ${paramValues.food[1] }</li>
	</ul>
</body>
</html>




