<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP</title>
</head>
<body>
	<h1>표준 액션 태그(Standard Action Tag)</h1>
	<hr>
	<p>Java 명령으로 구현해야만 되는 기능을 JSP 태그로 제공하는 기능</p>
	<hr>
	<ul>
		<li>include 태그 : 현재 JSP 문서에서 다른 JSP 문서로 스레드를 이동
		하여 명령 실행 후 결과(HTML)를 전달받아 문서에 포함하는 태그</li>
		<li>forward 태그 : 현재 JSP 문서에서 다른 JSP 문서로 스레드를 이동
		하여 처리 결과를 클라이언트에게 전달(응답)하는 태그</li>
		<li>param 태그 : 현재 JSP 문서의 값(문자열)을 스레드가 이동하는
		JSP 문서로 전달하기 위한 기능 - include 태그와 forward 태그의 하위 태그</li>
		<li>useBean 태그 : JSP 문서에서 인스턴스를 생성하여 공유하거나 
		공유 인스턴스 반환받아 저장하는 태그</li>
		<li>setProperty 태그 : useBean 태그로 생성된 공유 인스턴스의 
		필드값을 변경하는 태그 - useBean 태그의 종속태그</li>
		<li>getProperty 태그 : useBean 태그로 생성된 공유 인스턴스의 
		필드값을 반환하는 태그 - useBean 태그의 종속태그</li>
	</ul>
</body>
</html>