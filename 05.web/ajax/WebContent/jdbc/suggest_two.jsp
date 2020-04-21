<?xml version="1.0" encoding="UTF-8"?>
<%@page import="site.itwill.dao.SuggestDAO"%>
<%@page import="site.itwill.dto.SuggestDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/xml; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 키워드를 전달받아 SUGGEST 테이블에서 키워드가 포함된 제시어 관련 정보를
검색하여 반환받아 XML 텍스트 데이타를 전달하는 JSP 문서 --%>
<%-- REST(RePresentation State Transfer) : 웹어플리케이션을 이용하여 정보를 제공하는 기능 --%>
<%
	request.setCharacterEncoding("UTF-8");

	String keyword=request.getParameter("keyword");
			
	List<SuggestDTO> suggestList=null;
	if(keyword!=null && !keyword.equals("")) {
		suggestList=SuggestDAO.getDAO().selectSuggestList(keyword);
	}
%>
<result>
	<% if(suggestList!=null && !suggestList.isEmpty()) { %>
	<code>success</code>
	<data><![CDATA[
		[
		<% for(int i=0;i<suggestList.size();i++) { %>
			<% if(i>0) { %>,<% } %>
			{"word":"<%=suggestList.get(i).getWord()%>"
				,"address":"<%=suggestList.get(i).getAddress()%>"}
		<% } %>
		]
	]]>	
	</data>
	<% } else { %>
	<code>empty</code>	
	<% } %>
</result>








