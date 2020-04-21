<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String name="전우치";
	request.setAttribute("name", name);
	
	boolean vip=true;
	request.setAttribute("vip", vip);
%>    
<%@taglib prefix="simple" uri="http://www.itwill.site/mvc/simple"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MVC</title>
</head>
<body>
	<h1>Custom Tag - Attribute and Body</h1>
	<hr>
	<simple:helloBody test="true">홍길동</simple:helloBody>	
	<simple:helloBody test="false">임꺽정</simple:helloBody>
	<hr>
	<simple:helloBody test="true"><%=name %></simple:helloBody>	
	<simple:helloBody test="true">${name}</simple:helloBody>	
	<hr>
	<%-- 기본적으로 태그 속성값은 상수로만 설정 가능 --%>
	<%-- => 표현식 또는 EL를 사용할 경우 에러 발생 --%>
	<simple:helloBody test="<%=vip %>">일지매</simple:helloBody>	
	<simple:helloBody test="${vip }">장길산</simple:helloBody>
</body>
</html>
