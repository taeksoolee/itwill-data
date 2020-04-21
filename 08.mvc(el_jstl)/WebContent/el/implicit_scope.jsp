<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//인스턴스를 저장하는 내장객체에 의해 사용 범위 구분 
	// => 객체속성의 범위(Scope) : Page, Request, Session, Application
	pageContext.setAttribute("pageName", "홍길동");
	request.setAttribute("requestName", "임꺽정");
	session.setAttribute("sessionName", "전우치");
	application.setAttribute("applicationName", "일지매");
	
	//인스턴스를 저장하는 객체속성의 속성명을 동일하게 선언
	// => 내장객체가 같은 경우 덮어씌우기가 발생하지만 내장객체가 다른 경우 아무런 상관 없음 
	pageContext.setAttribute("name", "홍길동");
	request.setAttribute("name", "임꺽정");
	session.setAttribute("name", "전우치");
	application.setAttribute("name", "일지매");
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>EL 내장객체 - Scope Attribute</h1>
	<hr>
	<h3>객체속성명이 다른 경우</h3>
	<ul>
		<li>객체속성값(Page Scope) = ${pageName }</li>
		<li>객체속성값(Request Scope) = ${requestName }</li>
		<li>객체속성값(Session Scope) = ${sessionName }</li>
		<li>객체속성값(Application Scope) = ${applicationName }</li>
	</ul>
	<hr>
	<%-- EL 표현식에서는 객체속성으로 저장된 인스턴스를 찾기 위한 순서 존재 --%>
	<%-- => Page Scope >> Request Scope >> Session Scope >> Application Scope --%>
	<%-- => EL 표현식을 사용하고자 할 경우 객체속성의 속성명을 다르게 선언하는 것을 권장 --%>
	<h3>객체속성명이 같은 경우 - 내장객체 미사용</h3>
	<ul>
		<li>객체속성값(Page Scope) = ${name }</li>
		<li>객체속성값(Request Scope) = ${name }</li>
		<li>객체속성값(Session Scope) = ${name }</li>
		<li>객체속성값(Application Scope) = ${name }</li>
	</ul>
	<hr>
	<h3>객체속성명이 같은 경우 - 내장객체 사용</h3>
	<%-- EL 표현식에서 내장객체를 이용하면 원하는 범위의 속성값을 명시 가능 --%>
	<%-- => pageScope, requestScope, sessionScope, applicationScope --%>
	<ul>
		<li>객체속성값(Page Scope) = ${pageScope.name }</li>
		<li>객체속성값(Request Scope) = ${requestScope.name }</li>
		<li>객체속성값(Session Scope) = ${sessionScope.name }</li>
		<li>객체속성값(Application Scope) = ${applicationScope.name }</li>
	</ul>
</body>
</html>