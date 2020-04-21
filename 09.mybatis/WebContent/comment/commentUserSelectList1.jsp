<%@page import="site.itwill.dto.MyCommentUser1"%>
<%@page import="site.itwill.dao.MyCommentDAO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	List<MyCommentUser1> commentUserList
		=MyCommentDAO.getDAO().selectCommentUserList1();
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
	padding: 3px;
}

.no { width: 100px; }
.name { width: 150px; }
.content { width: 250px; }
.date { width: 200px; }
</style>
</head>
<body>
	<h1>게시글 목록</h1>
	<hr>
	<table>
		<tr>
			<td class="no">게시글번호</td>
			<td class="name">게시글작성자</td>
			<td class="content">게시글내용</td>
			<td class="date">게시글작성일자</td>
		</tr>
		<% for(MyCommentUser1 commentUser:commentUserList) { %>
		<tr>
			<td class="no"><%=commentUser.getCommentNo() %></td>
			<td class="name"><%=commentUser.getUserName() %>(<%=commentUser.getCommentId() %>)</td>
			<td class="content"><%=commentUser.getCommentContent() %></td>
			<td class="date"><%=commentUser.getCommentDate().substring(0, 19) %></td>
		</tr>
		<% } %>
	</table>
</body>
</html>







