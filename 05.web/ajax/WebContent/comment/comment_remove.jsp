<?xml version="1.0" encoding="UTF-8"?>
<%@page import="site.itwill.dao.AjaxCommentDAO"%>
<%@ page language="java" contentType="text/xml; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 댓글번호를 전달받아 AJAX_COMMENT 테이블에 저장된 해당 댓글을 삭제하고
삭제결과를 XML 텍스트 데이타로 응답하는 JSP 문서 --%>
<%
	if(request.getMethod().equals("GET")) {
		response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
		return;
	}
	
	int num=Integer.parseInt(request.getParameter("num"));
	
	int rows=AjaxCommentDAO.getDAO().deleteAjaxComment(num);
%>
<result>
	<% if(rows>0) { %>
	<code>success</code>
	<% } else { %>
	<code>error</code>
	<% } %>
</result>