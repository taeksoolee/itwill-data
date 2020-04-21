<%@page import="site.itwill.dao.StudentDAO"%>
<%@page import="site.itwill.dto.StudentDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	List<StudentDTO> studentList=StudentDAO.getDAO().selectAllStudent();
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Mybatis</title>
<style type="text/css">
table {
	border: 1px solid black;
	border-collapse: collapse;
}

td {
	border: 1px solid black;
	text-align: center;
	padding: 10px;
}
</style>
</head>
<body>
	<h1>학생목록</h1>
	<hr>
	<table>
		<tr>
			<td>학번</td>
			<td>이름</td>
			<td>전화번호</td>
			<td>주소</td>
			<td>생년월일</td>
		</tr>
		<% for(StudentDTO student:studentList) { %>
		<tr>
			<td><%=student.getNo() %></td>
			<td><%=student.getName() %></td>
			<td><%=student.getPhone() %></td>
			<td><%=student.getAddress() %></td>
			<td><%=student.getBirthday().substring(0, 10) %></td>
		</tr>
		<% } %>
	</table>	
</body>
</html>




