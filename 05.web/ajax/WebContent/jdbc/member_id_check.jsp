<?xml version="1.0" encoding="UTF-8"?>
<%@page import="site.itwill.dao.AjaxMemberDAO"%>
<%@page import="site.itwill.dto.AjaxMemberDTO"%>
<%@ page language="java" contentType="text/xml; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 아이디를 전달받아 AJAX_MEMBER 테이블에서 전달 아이디의 저장유무를 
검색하여 XML 텍스트 데이타를 전달하는 JSP 문서 --%>
<%
	String id=request.getParameter("id");

	AjaxMemberDTO ajaxMember=null;
	if(id!=null && !id.equals("")) {
		ajaxMember=AjaxMemberDAO.getDAO().selectAjaxMember(id);	
	}
%>
<result>
	<% if(ajaxMember==null) { %>
	<code>possible</code>
	<% } else { %>
	<code>impossible</code>
	<% } %>
</result>


