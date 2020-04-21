<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP</title>
</head>
<body>
	<h1>인스턴스 사용범위(Scope)</h1>
	<hr>
	<p>WAS에 의해 관리되는 JSP(서블릿)이 인스턴스를 공유하여 사용할 수 있는 범위</p>
	<hr>
	<p>JSP에서는 내장객체에 의해 인스턴스를 공유하여 사용 - 내장객체에 따라 공유범위 지정</p>
	<ul>
		<li>인스턴스를 공유하는 메소드 : 내장객체.setAttribute(String name, Object value)</li>
		<li>공유 인스턴스를 반환하는 메소드 : 내장객체.getAttribute(String name)</li>
		<li>공유 인스턴스를 제거하는 메소드 : 내장객체.removeAttribute(String name)</li>
	</ul>
	<hr>
	<p>Page Scope : pageContext 내장객체 이용하여 인스턴스를 공유하여 사용
	- 인스턴스를 공유한 JSP(서블릿)에서만 사용 가능</p>
	<p>Request Scope : request 내장객체 이용하여 인스턴스를 공유하여 사용
	- 인스턴스를 공유한 JSP(서블릿)와 스레드가 이동된 JSP(서블릿)에서 사용 가능</p>
	<p>Session Scope : session 내장객체 이용하여 인스턴스를 공유하여 사용
	- 컨텍스트에 존재하는 모든 JSP(서블릿)에서 사용 가능<br>
	= 클라이언트마다 다른 세션 이용하여 인스턴스 공유(브라우저 종료시 소멸)</p>
	<p>Application Scope: application 내장객체 이용하여 인스턴스를 공유하여 사용
	- 컨텍스트에 존재하는 모든 JSP(서블릿)에서 사용 가능<br>
	= 클라이언트와 상관없이 같은 인스턴스 공유(WAS 종료시 소멸)</p>
</body>
</html>




