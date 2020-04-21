<%@page import="java.util.ArrayList"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="site.itwill.dao.MyHewonDAO"%>
<%@page import="site.itwill.dto.MyHewon"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//,로 구분된 아이디 목록을 반환받아 저장
	String ids=request.getParameter("ids");
	if(ids==null||ids.equals("")) ids=null;
	
	//전달받은 아이디 목록을 분리하여 List 인스턴스의 요소로 저장
	List<String> idList=null;
	if(ids!=null) {
		idList=new ArrayList<String>();
		for(String id:ids.split(",")) {
			idList.add(id.trim());
		}
	}
	//System.out.println(idList);
	
	List<MyHewon> hewonList=MyHewonDAO.getDAO().selectDynamicMultiHewonList(idList);
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
		<% if(hewonList.isEmpty()) { %>
			<tr>
				<td colspan="5">검색된 회원정보가 존재하지 않습니다.</td>
			</tr>
		<% } else { %>		
			<% for(MyHewon hewon:hewonList) { %>
			<tr>
				<td class="id"><%=hewon.getId() %></td>
				<td class="name"><%=hewon.getName() %></td>
				<td class="phone"><%=hewon.getPhone() %></td>
				<td class="email"><%=hewon.getEmail() %></td>
				<td class="state"><%=hewon.getState() %></td>
			</tr>
			<% } %>
		<% } %>
	</table>
	<br>
	
	<form method="post">
		아이디 : <input type="text" name="ids">&nbsp;&nbsp;
		<button type="submit">검색</button><br>
		<b>[검색하고자 하는 아이디가 여러 개인 경우 ,로 구분하여 입력해 주세요.]</b>
	</form>
</body>
</html>
