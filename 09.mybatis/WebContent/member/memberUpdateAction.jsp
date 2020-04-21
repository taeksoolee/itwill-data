<%@page import="site.itwill.dao.MyMemberXMLDAO"%>
<%@page import="site.itwill.dto.MyMemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");

	String id=request.getParameter("id");
	String name=request.getParameter("name");
	String phone=request.getParameter("phone");
	String email=request.getParameter("email");
	
	MyMemberDTO member=new MyMemberDTO();
	member.setId(id);	
	member.setName(name);	
	member.setPhone(phone);	
	member.setEmail(email);
	
	MyMemberXMLDAO.getDAO().updateMember(member);
	response.sendRedirect("memberDisplay.jsp");
%>