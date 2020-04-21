<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//Java 주석문 사용 가능
	Date now=new Date();
	SimpleDateFormat sdf=new SimpleDateFormat("yyyy년 MM월 dd일 HH시 mm분 ss초");
	String printNow=sdf.format(now);
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP</title>
<style type="text/css">
#display {
	width: 500px;
	margin: 0 auto;
	padding: 20px;
	font-size: 2em;
	text-align: center;
	border: 1px solid black;
}
</style>
</head>
<body>
	<h1>Hello, JSP!!!</h1>
	<hr>
	<!-- HTML 주석문 : 클라이언트에게 전달 - 소스보기 가능(디자이너) -->
	<%-- JSP 주석문 : 클라이언트에게 미전달 - 소스보기 불가능(프로그래머) --%>
	<p>JSP(Java Server Page) : 서블릿보다 쉽게 웹어플리케이션을 작성하기 위한 기술
	- 스크립트 태그(Script Tag), 지시어 태그(Directive Tag), 액션 태그(Action Tag)</p>
	<hr>
	<p id="display"><%=printNow %></p>
	
	<script type="text/javascript">
	setInterval(function() {
		location.reload();		
	}, 1000);
	</script>
</body>
</html>




