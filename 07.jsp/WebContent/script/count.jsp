<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 선언문(Declaration) : 클래스 내부에 선언되는 요소(필드 또는 메소드) --%>    
<%!
	//클래스 내부에 선언된 필드
	// => 인스턴스 제거시(WAS 종료) 필드 자동 소멸
	int count=0;
%>    
    
<%-- 스크립틀릿(Scripelet) : _jspService() 메소드 내부에 작성되는 명령 --%>    
<%
	//_jspService() 메소드 내부에 선언된 지역변수
	// => 메소드 종료시 지역변수 자동 소멸
	//int count=0;
	count++;
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP</title>
</head>
<body>
	<h1>스트립트 태그(Script Tag)</h1>
	<hr>
	<%-- <p>JSP 문서의 요청횟수 = <% out.println(count); %></p> --%>
	<%-- 표현식(Expression) : 값을 문자열로 변환하여 클라이언트에게 전달 --%>
	<p>JSP 문서의 요청횟수 = <%=count %></p>
</body>
</html>



