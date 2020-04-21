<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="site.itwill.dao.MyHewonDAO"%>
<%@page import="site.itwill.dto.MyHewon"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
	String searchColumn=request.getParameter("searchColumn");
	String searchKeyword=request.getParameter("searchKeyword");

	List<MyHewon> hewonList=null;
	//검색기능을 이용하지 않은 경우
	if(searchKeyword==null || searchKeyword.equals("")) {
		//전체 회원정보를 검색하여 반환
		hewonList=MyHewonDAO.getDAO().selectHewonList();
	} else {//검색기능을 이용한 경우
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("searchColumn", searchColumn);
		map.put("searchKeyword", searchKeyword);
		
		//특정 회원정보를 검색하여 반환
		hewonList=MyHewonDAO.getDAO().selectSearchHewonList(map);
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
	
	<form method="post">
		<!-- 검색대상 선택 입력 - 전달값은 테이블의 컬럼명과 동일하도록 설정 -->
		<select name="searchColumn">
			<option value="hewon_id" selected>아이디</option>
			<option value="hewon_name">이름</option>
			<option value="hewon_phone">전화번호</option>
		</select>
		<!-- 검색단어 입력 -->
		<input type="text" name="searchKeyword">
		<button type="submit">검색</button>
	</form>
</body>
</html>



