<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Spring</title>
</head>
<body>
	<h1>사원정보</h1>
	<hr>
	<ul>
		<li>사원번호 = ${employee.num }</li>
		<li>사원이름 = ${employee.name }</li>
		<%-- <li>전화번호 = ${employee.phone1 } - ${employee.phone2 } - ${employee.phone3 }</li>--%>
		<li>전화번호 = ${employee.phone.phone1 } - ${employee.phone.phone2 } - ${employee.phone.phone3 }</li>
	</ul>
</body>
</html>