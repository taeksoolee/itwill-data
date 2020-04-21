<%@page import="site.itwill.dto.MyCommentUser2"%>
<%@page import="site.itwill.dao.MyCommentDAO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	List<MyCommentUser2> commentUserList
		=MyCommentDAO.getDAO().selectCommentUserList2();
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
		<% for(MyCommentUser2 commentUser:commentUserList) { %>
		<tr>
			<td class="no"><%=commentUser.getComment().getCommentNo() %></td>
			<td class="name"><%=commentUser.getUser().getUserName() %>(<%=commentUser.getComment().getCommentId() %>)</td>
			<%-- <td class="content"><%=commentUser.getComment().getCommentContent() %></td> --%>
			
			<%-- 
			<td class="content">
				<a href="commentReplySelect1.jsp?commentNo=<%=commentUser.getComment().getCommentNo()%>">
				<%=commentUser.getComment().getCommentContent() %>
				</a>
			</td>
			--%>
			
			<%-- 
			<td class="content">
				<a href="commentReplySelect2.jsp?commentNo=<%=commentUser.getComment().getCommentNo()%>">
				<%=commentUser.getComment().getCommentContent() %>
				</a>
			</td>
			--%>
			
			<td class="content">
				<a href="commentUserReplyUserSelect.jsp?commentNo=<%=commentUser.getComment().getCommentNo()%>">
				<%=commentUser.getComment().getCommentContent() %>
				</a>
			</td>
			
			<td class="date"><%=commentUser.getComment().getCommentDate().substring(0, 19) %></td>
		</tr>
		<% } %>
	</table>
</body>
</html>



