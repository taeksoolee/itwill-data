<?xml version="1.0" encoding="UTF-8"?>
<%@page import="site.itwill.util.Utility"%>
<%@page import="site.itwill.dao.AjaxCommentDAO"%>
<%@page import="site.itwill.dto.AjaxCommentDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/xml; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- AJAX_COMMENT 테이블에 저장된 모든 댓글을 검색하여 XML 텍스트 데이타로
응답하는 JSP 문서 --%>    
<%
	List<AjaxCommentDTO> ajaxCommentList
		=AjaxCommentDAO.getDAO().selectAjaxCommentList();
%>
<result>
	<% if(!ajaxCommentList.isEmpty()) { %>
	<code>success</code>
	<data><![CDATA[
		[
		<% for(int i=0;i<ajaxCommentList.size();i++) { %>
			<% if(i>0) { %>,<% } %>	
			{"num":<%=ajaxCommentList.get(i).getNum()%>
			,"writer":"<%=Utility.toJSON(ajaxCommentList.get(i).getWriter())%>"
			,"content":"<%=Utility.toJSON(ajaxCommentList.get(i).getContent())%>"
			,"writeDate":"<%=ajaxCommentList.get(i).getWriteDate().substring(0,19)%>"}
		<% } %>
		]
	]]>
	</data>
	<% } else { %>
	<code>empty</code>
	<message><![CDATA[첫번째 댓글을 등록해 주세요.]]></message>
	<% } %>
</result>







