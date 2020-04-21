<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP</title>
</head>
<body>
	<h1>내장객체(Implicit Object)</h1>
	<hr>
	<p>JSP 문서에 기본적으로 제공되는 인스턴스</p>
	<hr>
	<ul>
		<li>page : JSP 문서를 표현하기 위한 인스턴스(클래스의 this 키워드와 동일)</li>
		<li>config : WAS의 환경설정파일에서 제공되는 값을 얻어오기 위한 인스턴스</li>
		<li>out : 클라이언트에게 값을 전달하기 위한 인스턴스(출력스트림)</li>
		<li>request : 클라이언트의 정보와 요청값을 얻어오기 위한 인스턴스</li>
		<li>response : 클라이언트에게 응답코드와 결과값을 전달하기 위한 인스턴스</li>
		<li>session : 클라이언트와의 연결 지속성 관련 값을 제공하기 위한 인스턴스</li>
		<li>application : WAS(Web Application Server)의 정보를 제공하기 위한 인스턴스</li>
		<li>pageContext : JSP 문서의 컨텍스트 정보를 제공하기 위한 인스턴스</li>
		<li>exception : JSP 문서의 예외 정보를 제공하기 위한 인스턴스
		- page Directive의 isErrorPage 속성값을 true로 설정한 경우 제공</li>
	</ul>
</body>
</html>








