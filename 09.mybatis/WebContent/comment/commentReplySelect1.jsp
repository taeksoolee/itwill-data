<%@page import="site.itwill.dao.MyReplyDAO"%>
<%@page import="site.itwill.dto.MyReply"%>
<%@page import="java.util.List"%>
<%@page import="site.itwill.dao.MyCommentDAO"%>
<%@page import="site.itwill.dto.MyComment1"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	if(request.getParameter("commentNo")==null) {
		response.sendRedirect("commentUserSelectList2.jsp");
		return;
	}

	int commentNo=Integer.parseInt(request.getParameter("commentNo"));
	
	MyComment1 comment=MyCommentDAO.getDAO().selectComment(commentNo);
	
	List<MyReply> replyList=MyReplyDAO.getDAO().selectCommentNoReplyList(commentNo);
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
.comment { width: 100px; }
</style>
</head>
<body>
	<h1>게시글과 댓글 목록</h1>
	<hr>
	<%-- 게시글 출력 --%>
	<table>
		<tr>
			<td width="200">게시글번호</td>
			<td width="200"><%=comment.getCommentNo() %></td>
		</tr>
		<tr>
			<td width="200">게시글작성자</td>
			<td width="200"><%=comment.getCommentId() %></td>
		</tr>
		<tr>
			<td width="200">게시글내용</td>
			<td width="200"><%=comment.getCommentContent() %></td>
		</tr>
		<tr>
			<td width="200">게시글작성일자</td>
			<td width="200"><%=comment.getCommentDate() %></td>
		</tr>
	</table>
	<br>
	
	<%-- 댓글 목록 출력 --%>
	<table>
		<tr>
			<td class="no">댓글번호</td>
			<td class="name">댓글작성자</td>
			<td class="content">댓글내용</td>
			<td class="date">댓글작성일자</td>
			<td class="comment">게시글번호</td>
		</tr>
		<% if(replyList.isEmpty()) { %>
			<tr>
				<td colspan="5">댓글이 존재하지 않습니다.</td>
			</tr>
		<% } else { %>
			<% for(MyReply reply:replyList) { %>
			<tr>
				<td class="no"><%=reply.getReplyNo() %></td>
				<td class="name"><%=reply.getReplyId()%></td>
				<td class="content"><%=reply.getReplyContent() %></td>
				<td class="date"><%=reply.getReplyDate().substring(0, 19) %></td>
				<td class="comment"><%=reply.getReplyCommentNo() %></td>
			</tr>
			<% } %>
		<%} %>
	</table>	
</body>
</html>





