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
	<%-- action 속성을 생략하면 현재 요청 URL 주소의 페이지를 재요청 --%>
	<form method="post">
	<table>
		<tr>
			<td>아이디</td>
			<td><input type="text" name="id"></td>
		</tr>
		<tr>
			<td>이름</td>
			<td><input type="text" name="name"></td>
		</tr>
		<tr>
			<td colspan="2">
				<button type="submit">전송</button>
			</td>
		</tr>
	</table>	
	</form>
</body>
</html>






