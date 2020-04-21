<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//내장객체를 이용한 인스턴스 공유 - setAttribute(String name, Object value)
	pageContext.setAttribute("pageName", "홍길동");//Page Scope
	request.setAttribute("requestName", "임꺽정");//Request Scope
	session.setAttribute("sessionName", "전우치");//Session Scope
	application.setAttribute("applicationName", "일지매");//Application Scope
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP</title>
</head>
<body>
	<h1>인스턴스 공유와 사용</h1>
	<hr>
	<%
		//내장객체를 이용한 공유 인스턴스 반환 - getAttribute(String name)
		// => 공유이름으로 공유된 인스턴스가 없는 경우 null 반환
		// => Object 타입의 인스턴스 반환 : 반드시 객체 형변환하여 사용
		String pageName=(String)pageContext.getAttribute("pageName");
		String requestName=(String)request.getAttribute("requestName");
		String sessionName=(String)session.getAttribute("sessionName");
		String applicationName=(String)application.getAttribute("applicationName");
	%>
	<ul>
		<li>pageName = <%=pageName %></li>
		<li>requestName = <%=requestName %></li>
		<li>sessionName = <%=sessionName %></li>
		<li>applicationName = <%=applicationName %></li>
	</ul>
</body>
</html>






