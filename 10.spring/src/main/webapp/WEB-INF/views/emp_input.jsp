<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Spring</title>
</head>
<body>
	<h1>사원등록</h1>
	<hr>
	<form action="emp" method="post">
	<table>
		<tr>
			<td>사원번호</td>
			<td><input type="text" name="num"></td>
		</tr>
		<tr>
			<td>이름</td>
			<td><input type="text" name="name"></td>
		</tr>
		<tr>
			<td>전화번호</td>
			<%-- 
			<td>
				<input type="text" name="phone1" size="3"> - 
				<input type="text" name="phone2" size="4"> - 
				<input type="text" name="phone3" size="4"> 
			</td>
			--%>
			<td>
				<input type="text" name="phone.phone1" size="3"> - 
				<input type="text" name="phone.phone2" size="4"> - 
				<input type="text" name="phone.phone3" size="4"> 
			</td>
		</tr>
		<tr>
			<td colspan="2">
				<button type="submit">등록</button>
			</td>
		</tr>
	</table>
	</form>
</body>
</html>