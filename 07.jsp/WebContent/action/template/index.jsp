<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 클라이언트의 요청을 받아 템플릿 페이지로 스레드를 이동하는 JSP 문서 - 요청 페이지 --%>
<%
	//클라이언트 요청에 대한 전달값을 반환받아 저장
	String part=request.getParameter("part");
	if(part==null) part="main";
	
	String work=request.getParameter("work");
	if(work==null) work="print";
%>
<jsp:forward page="layout/template.jsp">
	<jsp:param value="<%=part %>" name="part"/>
	<jsp:param value="<%=work %>" name="work"/>
</jsp:forward>