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
	<form action="xss" method="post">
	<table>
		<tr>
			<td>제목</td>
			<td><input type="text" name="subject"></td>
		</tr>
		<tr>
			<td>내용</td>
			<td><textarea rows="3" cols="60" name="content"></textarea></td>
		</tr>
		<tr>
			<td colspan="2"><button type="submit">전송</button></td>
		</tr>
	</table>
	</form>
</body>





</html>