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
	<h1>Core - 흐름 제어 태그</h1>
	<hr>
	<c:set var="phone" value="010-1234-5678"/>
	<p>전화번호 = ${phone }</p>
	
	<%-- forTokens 태그 : 속성값을 특정 문자열로 분리하여 반복 처리하는 태그 --%>
	<%-- var 속성 : 분리된 값을 저장하기 위한 속성명을 속성값으로 설정 --%>
	<%-- items 속성 : 분리하기 위한 값을 속성값으로 설정 --%>
	<%-- delims 속성 : 분리하기 위한 구분값을 속성값으로 설정 --%>
	<c:forTokens var="num" items="${phone}" delims="-">
		<div>${num }</div>
	</c:forTokens>
</body>
</html>






