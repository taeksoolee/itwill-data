<%@page import="site.itwill.dao.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 삭제하고자 하는 회원의 아이디를 전달받아 MEMBER 테이블에 저장된 해당
회원정보를 삭제하고 회원목록 출력페이지(member_manager.jsp)로 이동하는 JSP 문서 --%>
<%@include file="/site/security/admin_check.jspf"%>
<%
	//비정상적인 요청에 대한 응답처리
	if(request.getMethod().equals("GET")) {
		out.println("<script type='text/javascript'>");
		out.println("location.href='"+request.getContextPath()+"/site/index.jsp?workgroup=error&work=error400';");
		out.println("</script>");
		return;
	}

	//삭제하고자 하는 회원의 아이디를 반환받아 저장
	// => 같은 이름으로 전달되는 값이 여러 개이므로 request.getParameterValues() 메소드 호출
	String[] checkId=request.getParameterValues("checkId");
	
	//아이디를 전달하여 MEMBER 테이블에 저장된 해당 회원정보를 삭제하는 DAO 클래스의 메소드 호출
	for(String id:checkId) {
		MemberDAO.getDAO().deleteMember(id);
	}
	
	//회원목록 출력페이지로 이동
	out.println("<script type='text/javascript'>");
	out.println("location.href='"+request.getContextPath()+"/site/index.jsp?workgroup=admin&work=member_manager';");
	out.println("</script>");
%>










