<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Spring</title>
</head>
<body>
	<h1>리소스 파일</h1>
	<hr>
	<%-- 리소스 파일 : 멀티미디어 파일, CSS 파일, JavaScript 파일 등 --%>
	<%-- => 리소스 파일은 클라이언트에서 직접 접근하여 사용 가능 --%>
	
	<%-- 현재 시스템에서는 클라이언트의 모든 요청을 Front Controller를 이용하여 처리  --%>
	<%-- 문제점)리소스 파일에 대한 요청을 Front Controller에게 요청할 경우 미응답 --%>
	<%-- 해결법)리소스 파일은 Front Controller를 이용하지 않고 직접 요청하여 응답되도록 설정 --%>
	<%-- => Bean Configuration File(servlet-context.xml)에서 resources 엘리먼트 사용 --%>
	<%-- <img src="resources/images/Koala.jpg" width="200"> --%>
	<img src="images/Koala.jpg" width="200">
	
	<%-- 리소스 파일은 절대경로로 요청하는 것을 권장 --%>
	<img src="/spring/images/Koala.jpg" width="200">

	<%-- 컨텍스트 경로는 변경 가능하므로 메소드를 호출하여 컨텍스트 경로를 제공받아 표현 --%>
	<img src="<%=request.getContextPath() %>/images/Koala.jpg" width="200">
	
	<%-- 컨텍스트 경로를 EL 내장객체를 이용하여 표현 --%>
	<img src="${pageContext.request.contextPath }/images/Koala.jpg" width="200">
	
	<%-- Core 태그 라이브러리의 url 태그를 이용하여 컨텍스트 경로를 포함하여 표현 --%>
	<img src=<c:url value="/images/Koala.jpg"/> width="200">
	
	<%-- Spring 태그 라이브러리의 url 태그를 이용하여 컨텍스트 경로를 포함하여 표현 --%>
	<img src=<spring:url value="/images/Koala.jpg"/> width="200">
</body>
</html>