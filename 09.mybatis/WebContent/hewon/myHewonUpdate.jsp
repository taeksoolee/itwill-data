<%@page import="java.util.List"%>
<%@page import="site.itwill.dao.MyHewonDAO"%>
<%@page import="site.itwill.dto.MyHewon"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	MyHewon modifyHewon=new MyHewon();

	/*
	//아이디가 [aaa]인 회원이름을 [홍기동]으로 변경
	modifyHewon.setId("aaa");
	modifyHewon.setName("홍기동");
	//회원정보 중 아이디와 이름을 제외한 필드는 기본값이 저장되어 전달
	// => MYHEWON 테이블에 저장된 회원정보가 비정상적으로 변경
	MyHewonDAO.getDAO().updateHewon(modifyHewon);
	*/
	
	//아이디가 [aaa]인 회원이름을 [홍기동]으로 변경
	// => 변경하지 않는 컬럼에 대한 필드값도 기존값으로 변경하여 전달
	modifyHewon.setId("aaa");
	modifyHewon.setName("홍기동");
	modifyHewon.setPhone("111-1111");
	modifyHewon.setEmail("aaa@itwill.site");
	modifyHewon.setState(1);
	MyHewonDAO.getDAO().updateHewon(modifyHewon);
	
	List<MyHewon> hewonList=MyHewonDAO.getDAO().selectHewonList();
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
