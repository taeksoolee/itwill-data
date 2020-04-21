<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 세션에 저장된 인증정보를 제거하고 인증정보 입력페이지(user_login.jsp)를 
요청하도록 응답하는 JSP 문서 --%>    
<%
	//session.removeAttribute("loginUserinfo");
	session.invalidate();

	response.sendRedirect("user_login.jsp");
%>