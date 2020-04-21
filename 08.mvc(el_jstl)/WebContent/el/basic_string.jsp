<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//pageContext.setAttribute(String name, Object value) : pageContext
	//내장객체의 속성으로 인스턴스를 저장하는 메소드 - Page Scope
	// => pageContext 내장객체는 JSP 문서에서만 사용 가능
	// => pageContext 내장객체에 의해 저장된 인스턴스는 하나의 JSP 문서에서만 사용 가능
	pageContext.setAttribute("name", "홍길동");
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MVC</title>
</head>
<body>
	<h1>EL(Expression Language)</h1>
	<hr>
	<p>EL : 객체속성으로 저장된 인스턴스를 반환받아 출력하기 위해 사용하는 언어</p>
	<hr>
	<h2>EL 미사용</h2>
	<%
		//pageContext.getAttribute(String name) : pageContext 내장객체에
		//저장된 인스턴스를 반환하는 메소드
		String name=(String)pageContext.getAttribute("name");

		//속성명으로 저장된 인스턴스가 없는 경우 null 반환 
		String pageName=(String)pageContext.getAttribute("pageName");
	%>
	<p>이름 = <%=name %></p>
	<%-- 표현식에서는 null을 문자열로 변환하여 출력 --%>
	<%-- <p>이름 = <%=pageName %></p> --%>
	<%-- if 구문을 이용하여 반환된 결과값이 null이 아닌 경우 출력 --%>
	<p>이름 = <% if(pageName!=null) { %><%=pageName %><% } %></p>
	<hr>
	<h2>EL 사용</h2>
	<%-- ${속성명} : 속성명으로 저장된 인스턴스 반환받아 출력 --%>
	<%-- => getAttribute() 메소드와 표현식 생략 --%>
	<p>이름 = ${name}</p>
	<%-- 속성명으로 저장된 인스턴스가 없는 경우 미출력 --%>
	<p>이름 = ${pageName}</p>
</body>
</html>