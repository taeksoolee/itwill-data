<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	Map<String, String> carMap=new HashMap<String, String>();

	carMap.put("name", "싼타페");
	carMap.put("color", "하얀색");
	
	pageContext.setAttribute("car", carMap);
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MVC</title>
</head>
<body>
	<h1>EL(Expression Language)</h1>
	<hr>
	<h2>EL 미사용</h2>
	<%
		@SuppressWarnings("unchecked")
		Map<String, String> car
			=(Map<String, String>)pageContext.getAttribute("car");
	%>	
	<p>자동차 이름 = <%=car.get("name") %></p>
	<p>자동차 색상 = <%=car.get("color") %></p>
	<hr>
	<h2>EL 미사용</h2>
	<%-- ${속성명.키} 형식으로 Map 인스턴스의 키에 대한 값을 반환받아 출력 --%>
	<p>자동차 이름 = ${car.name }</p>
	<p>자동차 색상 = ${car.color }</p>
</body>
</html>







