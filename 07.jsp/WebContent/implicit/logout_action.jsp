<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 로그아웃 처리를 위한 JSP 문서 - 로그아웃 후 login_form.jsp 문서로 이동 --%>    
<%
	//로그아웃 처리 - 세션에 저장된 인증정보 제거
	//session.removeAttribute("loginId");

	//session.invalidate() : 바인딩된 세션을 제거하는 메소드
	// => 세션에 저장된 모든 인스턴스 제거
	session.invalidate();
	
	response.sendRedirect("login_form.jsp");
%>