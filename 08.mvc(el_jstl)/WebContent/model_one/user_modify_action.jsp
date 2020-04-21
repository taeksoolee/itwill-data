<%@page import="site.itwill.dao.UserinfoModelOneDAO"%>
<%@page import="site.itwill.dto.UserinfoDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 회원정보를 전달받아 USERINFO 테이블에 저장된 해당 회원정보를 변경하고
회원정보 상세 출력페이지(user_view.jsp)를 요청하도록 응답하는 JSP 문서 --%>    
<%
	if(request.getMethod().equals("GET")) {
		response.sendRedirect("user_error.jsp");
		return;
	}
	
	request.setCharacterEncoding("UTF-8");
	
	String userid=request.getParameter("userid");
	String password=request.getParameter("password");
	String name=request.getParameter("name");
	String email=request.getParameter("email");
	
	UserinfoDTO userinfo=new UserinfoDTO();
	userinfo.setUserid(userid);
	if(password==null || password.equals("")) {
		userinfo.setPassword(UserinfoModelOneDAO.getDAO().selectUserinfo(userid).getPassword());
	} else {
		userinfo.setPassword(password);
	}
	userinfo.setName(name);
	userinfo.setEmail(email);
	
	int rows=UserinfoModelOneDAO.getDAO().updateUserinfo(userinfo);
	
	response.sendRedirect("user_view.jsp?userid="+userid);
%>