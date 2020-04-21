<%@page import="site.itwill.dto.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 장바구니 목록을 출력하는 JSP 문서 --%>
<%-- => 로그인 상태에서만 요청 가능한 페이지 --%>    
<%-- => 비로그인 상태에서 요청한 경우 로그인 입력페이지(member_login.jsp)로 이동 --%>
<%--    로그인 인증 성공 후 기존 요청 페이지로 이동되도록 세션에 요청 페이지 정보 저장 --%>    
<%--
	//세션에 저장된 인증정보를 반환받아 저장
	MemberDTO loginMember=(MemberDTO)session.getAttribute("loginMember");

	if(loginMember==null) {//비로그인 상태
		//request.getRequestURI() : 요청 JSP 문서의 URI 주소를 반환하는 메소드
		String requestURI=request.getRequestURI();
		//System.out.println("requestURI = "+requestURI);
		
		String queryString=request.getQueryString();
		//System.out.println("queryString = "+queryString);
		
		if(queryString==null || queryString.equals("")) {
			queryString="";
		} else {
			queryString="?"+queryString;
		}
		
		//세션에 기존 요청페이지 주소를 저장
		session.setAttribute("uri", requestURI+queryString);
		session.setAttribute("message", "로그인 사용자만 접근 가능한 페이지입니다.");
		
		out.println("<script type='text/javascript'>");
		out.println("location.href='"+request.getContextPath()+"/site/index.jsp?workgroup=member&work=member_login';");
		out.println("</script>");
		return;
	}
--%>
<%@include file="/site/security/login_status.jspf" %>
<h1>장바구니 목록</h1>






