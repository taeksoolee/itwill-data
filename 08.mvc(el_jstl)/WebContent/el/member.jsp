<%@page import="site.itwill.el.Car"%>
<%@page import="site.itwill.el.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- Member 인스턴스를 request 내장객체의 저장하고 다른 JSP 문서로 포워드
이동하는 JSP 문서 - 모델 역활 --%>    
<%
	Member member=new Member("홍길동", new Car("산타페", "하얀색"));

	//request 내장객체에 인스턴스 저장(Request Scope)
	// => request 내장객체를 공유하여 사용하는 JSP 문서에서 저장 인스턴스 사용
	request.setAttribute("member", member);
	
	//포워드 이동 : 스레드를 다른 JSP 문서로 이동 - request와 response 내장객체 전달
	//request.getRequestDispatcher("member_non_el.jsp").forward(request, response);
	request.getRequestDispatcher("member_el.jsp").forward(request, response);
%>









