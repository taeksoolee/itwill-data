<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MVC</title>
</head>
<body>
	<h1>Core - URL 관리</h1>
	<hr>
	<%-- 리소스 파일(CSS 파일, JS 파일, 멀티미디어 파일 등)을 상대경로 표현방식으로 제공 --%>
	<%-- => 요청 페이지의 경로와 응답 JSP 문서의 경로가 다른 경우 404 코드 발생 --%>
	<img src="images/Koala.jpg" width="200">

	<%-- 리소스 파일을 절대경로 표현방식으로 제공하는 것을 권장 --%>
	<%-- => 컨텍스트 이름을 변경될 경우 404 코드 발생 --%>
	<img src="http://localhost:8000/mvc/jstl/images/Koala.jpg" width="200">
	<img src="/mvc/jstl/images/Koala.jpg" width="200">
	
	<%-- request.getContextPath() 메소드로 컨텍스트 이름을 반환받아 표현 --%>
	<img src="<%=request.getContextPath()%>/jstl/images/Koala.jpg" width="200">
	
	<%-- EL 표현식에서 pageContext 내장객체를 이용하여 컨텍스트 이름 표현 --%>	
	<img src="${pageContext.request.contextPath }/jstl/images/Koala.jpg" width="200">
	
	<%-- url 태그를 이용하여 컨텍스트 이름을 제공받아 표현 --%>
	<%-- url 태그 : 컨텍스트 이름이 포함된 리소스 경로를 제공하는 태그 --%>
	<%-- value 속성 : 컨텍스트 이름을 제외한 리소스 파일의 경로를 속성값으로 설정 --%>
	<img src=<c:url value="/jstl/images/Koala.jpg"/> width="200">
</body>
</html>