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
	<%-- 객체속성으로 저장된 Map 인스턴스의 맵키가 EL 표현식의 작성 규칙에
	맞지 않을 경우 . 연산자의 EL 표현식으로 출력 불가능 --%>
	<%-- => EL 표현식의 작성 규칙에 맞지 않을 경우 [] 연산자를 이용하여 맵키 표현 --%>
	<%-- <p>이름-1 = ${hewonMap.first.name}, 이름-2 = ${hewonMap.second.name}</p> --%>
	<p>이름-1 = ${hewonMap["first.name"]}, 이름-2 = ${hewonMap["second.name"]}</p>
</body>
</html>








