<%-- <%@page import="java.util.ArrayList,java.util.List"%> --%>
<%-- page Directive에서 동일한 속성을 여러번 선언할 경우 에러 발생 - 500 코드 --%>
<%-- => import 속성은 여러번 선언 가능 --%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//java.util.List<java.lang.String> nameList=new java.util.ArrayList<java.lang.String>();
	List<String> nameList=new ArrayList<String>();

	nameList.add("홍길동");
	nameList.add("임꺽정");
	nameList.add("전우치");
	nameList.add("일지매");
	nameList.add("장길산");
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP</title>
</head>
<body>
	<h1>page Directive - import 속성</h1>
	<hr>
	<p>클래스(인터페이스)를 쉽게 사용할 수 있도록 JSP 문서에 패키지 
	형식으로 표현하고 정의하는 속성</p>
	<hr>
	<ul>
	<% for(String name:nameList) { %>
		<li><%=name %></li>
	<% } %>			
	</ul> 
</body>
</html>



