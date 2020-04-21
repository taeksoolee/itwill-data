<%@page import="site.itwill.dao.UserinfoModelOneDAO"%>
<%@page import="site.itwill.dto.UserinfoDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 인증정보를 전달받아 USERINFO 테이블에 저장된 회원정보와 비교하여 인증 처리하는 JSP 문서 --%>
<%-- => 인증 성공 : 세션에 인증정보를 저장하고 환영메세지를 전달하는 JSP 문서(user_login.jsp)를 요청하도록 응답하는 JSP 문서 --%>    
<%-- => 인증 실패 : 인증정보를 입력하기 위한 문서(user_login.jsp)를 요청하도록 응답하는 JSP 문서 --%>    
<%
	if(request.getMethod().equals("GET")) {
		response.sendRedirect("user_error.jsp");
		return;
	}

	String userid=request.getParameter("userid");
	String password=request.getParameter("password");
	
	UserinfoDTO userinfo=UserinfoModelOneDAO.getDAO().selectUserinfo(userid);
	if(userinfo==null) {
		session.setAttribute("message", "입력된 아이디가 존재하지 않습니다.");
		session.setAttribute("userid", userid);
		response.sendRedirect("user_login.jsp");
		return;
	}
	
	if(!password.equals(userinfo.getPassword())) {
		session.setAttribute("message", "입력된 아이디가 잘못 되었거나 비밀번호가 맞지 않습니다.");
		session.setAttribute("userid", userid);
		response.sendRedirect("user_login.jsp");
		return;
	}
	
	session.setAttribute("loginUserinfo", userinfo);
	response.sendRedirect("user_login.jsp");
%>










