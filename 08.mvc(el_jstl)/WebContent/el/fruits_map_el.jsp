<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MVC</title>
</head>
<body>
	<h1>EL - Map</h1>
	<hr>
	<h2>과일의 종류</h2>
	<ul>
		<li>${fruitsMap.one }</li>
		<li>${fruitsMap.two }</li>
		<li>${fruitsMap.three }</li>
	</ul>
	<hr>
	<%-- EL 표현식에서 다른 객체속성으로 저장된 인스턴스의 값을 이용할
	경우 [] 연산자로 표현 가능 --%>
	<h3>좋아하는 과일 = ${fruitsMap[choice] }</h3>
</body>
</html>




