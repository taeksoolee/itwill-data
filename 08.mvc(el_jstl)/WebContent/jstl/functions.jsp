<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MVC</title>
</head>
<body>
	<h1>functions</h1>
	<hr>
	<c:set var="phone" value="010-1234-5678"/>
	<div>전화번호 = ${phone }</div>
	<hr>

	<%-- split 함수 : 문자열을 특정 문자로 구분 분리하여 반환하는 함수 --%>
	<c:set var="array" value="${fn:split(phone,'-') }"/>
	<c:forEach var="num" items="${array }">
		<div>${num}</div>
	</c:forEach>
	<hr>
	
	<%-- substring 함수 : 문자열을 시작첨자와 종료첨자로 분리하여 반환하는 함수 --%>
	<div>${fn:substring(phone,0,3) }</div>
	<div>${fn:substring(phone,4,8) }</div>
	<div>${fn:substring(phone,9,13) }</div>
	<hr>
	
	<c:set var="content" value="안녕하세요.\n반갑습니다."/>
	<%-- replace 함수 : 문자열에서 특정 문자열을 원하는 문자열로 변환하여 반환하는 함수 --%>
	<div>${fn:replace(content,'\\n','<br>') }</div>
	<hr>
	
	<c:set var="html" value="<font size='7' color='red'>안녕하세요.</font>"/>
	<%-- EL 표현식으로 HTML 태그가 포함된 문자열을 출력할 경우 태그가 적용되어 출력 --%>
	<div>${html }</div>
	<%-- out 태그를 사용하면 HTML 태그가 포함된 문자열을 있는 그대로 출력 --%>
	<div><c:out value="${html }"/></div>
	<%-- escapeXml 함수 : HTML 태그 관련 문자열을 Escape 문자로 변환하여 반환하는 함수 --%>
	<div>${fn:escapeXml(html) }</div>
</body>
</html>
