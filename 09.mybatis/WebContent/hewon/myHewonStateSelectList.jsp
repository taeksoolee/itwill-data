<%@page import="site.itwill.dao.MyHewonDAO"%>
<%@page import="site.itwill.dto.MyHewon"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	int state=0;
	if(request.getParameter("state")!=null) {
		state=Integer.parseInt(request.getParameter("state"));
	}
	
	List<MyHewon> hewonList=null;
	if(state==0) {
		 hewonList=MyHewonDAO.getDAO().selectHewonList();//전체 검색
	} else {
		 hewonList=MyHewonDAO.getDAO().selectStateHewonList(state);//조건 검색
	}
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
	<br>
	
	<form method="post">
		회원검색(공개범위) :
		<select name="state">
			<option value="0" selected="selected">전체</option>
			<option value="1">&nbsp;1&nbsp;</option>
			<option value="2">&nbsp;2&nbsp;</option>
			<option value="3">&nbsp;3&nbsp;</option>
			<option value="4">&nbsp;4&nbsp;</option>
		</select>	
		<button type="submit">검색</button>
	</form>
</body>
</html>







