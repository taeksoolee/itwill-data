<%@page import="site.itwill.dao.UserinfoModelOneDAO"%>
<%@page import="site.itwill.dto.UserinfoDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 아이디를 전달받아 USERINFO 테이블에 저장된 해당 회원정보를 삭제하고
회원목록 출력페이지(user_list.jsp)를 요청하도록 응답하는 JSP 문서 --%>
<%-- => 관리자가 자신을 삭제처리한 경우 로그아웃 처리페이지(user_logout_action.jsp) 요청 --%>   
<%
	UserinfoDTO loginUserinfo=(UserinfoDTO)session.getAttribute("loginUserinfo");
	
	if(loginUserinfo==null || loginUserinfo.getStatus()!=9) {
		response.sendRedirect("user_error.jsp");
		return;
	}
	
	String userid=request.getParameter("userid");
	
	UserinfoModelOneDAO.getDAO().deleteUserinfo(userid);
	
	if(loginUserinfo.getUserid().equals(userid)) {
		response.sendRedirect("user_logout_action.jsp");
	} else {
		response.sendRedirect("user_list.jsp");
	}
%>





