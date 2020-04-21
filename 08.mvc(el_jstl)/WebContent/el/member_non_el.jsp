<%@page import="site.itwill.el.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- request 내장객체에 저장된 인스턴스를 반환받아 클라이언트에게 전달하는 JSP 문서 --%>
<%-- => member.jsp를 요청하지 않고 현재 JSP 문서를 요청한 경우 NullPointerException 발생 --%>
<%
	Member member=(Member)request.getAttribute("member");
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MVC</title>
</head>
<body>
	<h1>EL 미사용</h1>
	<hr>
	<%-- <p>회원 = <%=member %></p> --%>
	<p>회원이름 = <%=member.getName() %></p>	
	<%-- <p>회원 자동차 = <%=member.getCar() %></p> --%>	
	<p>회원 자동차 이름 = <%=member.getCar().getName() %></p>	
	<p>회원 자동차 색상 = <%=member.getCar().getColor() %></p>	
</body>
</html>


