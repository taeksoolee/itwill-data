<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Spring</title>
</head>
<body>
	<h1>입력페이지</h1>
	<hr>
	<%-- action 속성이 생략된 경우 현재 URL 주소를 이용하여 요청 --%>
	<form <%-- action="method" --%> method="post">
		이름 : <input type="text" name="name">
		<button type="submit">전송</button>
	</form>
</body>
</html>