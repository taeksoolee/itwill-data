<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Spring</title>
</head>
<body>
	<h1>회원정보확인(HTML)</h1>
	<hr>
	<ul>
		<li>아이디 = ${hewon.id }</li>
		<li>비밀번호 = ${hewon.passwd }</li>
		<li>이름 = ${hewon.name }</li>
		<li>이메일 = ${hewon.email }</li>
		<li>성별 = ${hewon.gender }</li>
	</ul>
</body>
</html>