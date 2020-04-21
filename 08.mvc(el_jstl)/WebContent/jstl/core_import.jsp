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
	<%-- import 태그 : 현재 JSP 문서에 대한 페이지의 응답 결과를 포함하는 기능을 제공하는 태그 --%>
	<%-- => include 태그는 현재 서버 페이지의 응답 결과를 포함하지만 import 태그는 다른 서버 페이지의 응답 결과 포함 가능 --%>
	<%-- url 속성 : 응답 결과를 제공할 페이지의 URL 주소를 속성값으로 설정 --%>
	<%-- <c:import url="core_import_source.jsp"/> --%>
	
	<c:import url="core_import_source.jsp">
		<%-- param 태그 : 요청 페이지에 값을 전달하기 위한 태그 --%>
		<%-- => url 관리 태그의 종속 태그 --%>
		<c:param name="name" value="홍길동"/>
	</c:import>
	<hr>
	<c:import url="https://www.daum.net"/>
</body>
</html>







