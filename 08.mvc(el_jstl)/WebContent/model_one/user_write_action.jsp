<%@page import="site.itwill.dao.UserinfoModelOneDAO"%>
<%@page import="site.itwill.dto.UserinfoDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 회원정보를 전달받아 USERINFO 테이블에 저장하고 로그인정보 입력페이지
(user_login.jsp)를 요청하도록 응답하는 JSP 문서 --%>    
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
	userinfo.setPassword(password);
	userinfo.setName(name);
	userinfo.setEmail(email);
	userinfo.setStatus(1);
	
	int rows=UserinfoModelOneDAO.getDAO().insertUserinfo(userinfo);
	
	if(rows>0) {//회원등록이 성공한 경우
		response.sendRedirect("user_login.jsp");
	} else {//회원등록이 실패한 경우 - 중복된 아이디가 입력된 경우 저장 실패
		session.setAttribute("message", "이미 사용중인 아이디를 입력 하였습니다.");
		session.setAttribute("userinfo", userinfo);
		response.sendRedirect("user_write.jsp");
	}
%>
