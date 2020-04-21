<%@page import="site.itwill.dao.MyHewonDAO"%>
<%@page import="site.itwill.dto.MyHewon"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	List<MyHewon> hewonList=MyHewonDAO.getDAO().selectDiscriminatorHewonList();
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

.id { width: 150px; }
.name { width: 150px; }
.phone { width: 200px; }
.email { width: 200px; }
.state { width: 100px; }
</style>
</head>
<body>
	<h1>회원목록</h1>
	<hr>
<table>
		<tr>
			<td class="id">아이디</td>
			<td class="name">이름</td>
			<td class="phone">전화번호</td>
			<td class="email">이메일</td>
			<td class="state">공개범위</td>
		</tr>
		<% for(MyHewon hewon:hewonList) { %>
		<tr>
			<td class="id"><%=hewon.getId() %></td>
			<td class="name"><%=hewon.getName() %></td>
			<td class="phone"><%=hewon.getPhone() %></td>
			<td class="email"><%=hewon.getEmail() %></td>
			<td class="state"><%=hewon.getState() %></td>
		</tr>
		<% } %>
	</table>
</body>
</html>



