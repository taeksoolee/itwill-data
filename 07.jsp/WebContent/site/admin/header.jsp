<%@page import="site.itwill.dto.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 관리자 페이지의 머릿부에 포함될 JSP 문서 --%>
<%-- => 로그인 상태의 관리자만 접근 가능하도록 권한 설정 --%>    
<%
	//세션에 저장된 인증정보를 반환받아 저장
	MemberDTO loginMember=(MemberDTO)session.getAttribute("loginMember");

	//비정상인 요청에 의한 응답처리 - 권한이 없는 사용자가 요청한 경우
	if(loginMember==null || loginMember.getStatus()!=9) {
		out.println("<script type='text/javascript'>");
		out.println("location.href='"+request.getContextPath()+"/site/index.jsp?workgroup=error&work=error400';");
		out.println("</script>");
		return;
	}
%>
<div id="profile">
	[<%=loginMember.getName() %>]님 환영합니다.&nbsp;&nbsp;
	<a href="index.jsp?workgroup=member&work=member_logout_action">로그아웃</a>&nbsp;&nbsp;
	<a href="index.jsp?workgroup=product&work=product_list">쇼핑몰</a>&nbsp;&nbsp;
</div>
<div id="logo"><a href="index.jsp?workgroup=admin&work=admin_main">관리페이지</a></div>
<div id="menu">
	<a href="index.jsp?workgroup=admin&work=member_manager">회원관리</a>
	<a href="index.jsp?workgroup=admin&work=product_manager">제품관리</a>
	<a href="index.jsp?workgroup=admin&work=order_manager">구매관리</a>
	<a href="index.jsp?workgroup=admin&work=board_manager">게시글관리</a>
</div>







