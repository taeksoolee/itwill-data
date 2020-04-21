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
	<h1>Core - EL 지원 태그</h1>
	<hr>
	<c:set var="num" value="100"/>
	<p>정수값 = ${num }</p>

	<%-- out 태그 : 클라이언트에게 값을 전달하는 태그 --%>
	<p>정수값 = <c:out value="${num }"/></p>
	<hr>
	<c:set var="html" value="<font size='7' color='red'>안녕하세요.</font>"/>
	<%-- EL를 이용하여 HTML 태그가 포함된 문자열을 출력할 경우 HTML 태그로 적용 --%>
	<p>html = ${html }</p>
	<%-- out 태그를 이용하여 HTML 태그가 포함된 문자열을 출력할 경우 무조건 문자열 적용 --%>
	<p>html = <c:out value="${html }"/></p>
</body>
</html>
