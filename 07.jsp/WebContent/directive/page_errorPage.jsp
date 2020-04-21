<%-- <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="error.jsp"%> --%>
<%-- web.xml 파일에 JSP 문서로 에러메세지를 제공하는 엘리먼트 설정 --%>    
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>    
<%
	//String text="ABCDEFG";
	String text=null;
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP</title>
</head>
<body>
	<h1>page Directive - errorPage 속성</h1>
	<hr>
	<p>JSP 문서에서 예외가 발생될 경우 클라이언트에게 에러 메세지를 
	전달하기 위한 문서를 지정하기 위한 속성</p>
	<hr>
	<p>문자열의 문자 갯수 = <%=text.length() %></p>
</body>
</html>




