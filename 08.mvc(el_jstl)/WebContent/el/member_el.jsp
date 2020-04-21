<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- request 내장객체에 저장된 인스턴스를 반환받아 클라이언트에게 전달하는 JSP 문서 --%>
<%-- => member.jsp를 요청하지 않고 현재 JSP 문서를 요청한 경우에도 NullPointerException 미발생 --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MVC</title>
</head>
<body>
	<h1>EL 사용</h1>
	<hr>
	<%-- <p>회원 = ${member }</p> --%>
	<p>회원이름 = ${member.name }</p>
	<p>회원이름 = ${member["name"] }</p>
	<%-- <p>회원 자동차 = ${member.car }</p> --%>
	<p>회원 자동차 이름 = ${member.car.name }</p>	
	<p>회원 자동차 색상 = ${member.car.color }</p>		
</body>
</html>










