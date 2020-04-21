<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- JSP 문서에서 커스텀 태그를 사용하고자 할 경우 TLD 파일을 taglib Directive로 불러와 제공 --%>
<%-- prefix 속성 : 태그에 대한 접두사(NameSpace)를 속성값으로 설정 --%>
<%-- uri 속성 : TLD 파일에 선언된 url 엘리먼트값을 속성값 설정 --%>
<%@taglib prefix="simple" uri="http://www.itwill.site/mvc/simple"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MVC</title>
</head>
<body>
	<h1>Custom Tag - NoAttribute and NoBody</h1>
	<hr>
	<%-- 태그내용이 있는 경우 시작태그와 종료태그를 따로 선언 --%>
	<%-- <simple:hello></simple:hello> --%>
	<%-- 태그내용이 없는 경우 시작태그와 종료태그를 같이 선언 --%>
	<simple:hello/>	
	<simple:hello/>	
	<simple:hello/>	
	<simple:hello/>	
	<simple:hello/>	
</body>
</html>







