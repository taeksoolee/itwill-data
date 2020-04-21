<%@page import="site.itwill.dao.MemberDAO"%>
<%@page import="site.itwill.util.Utility"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 비밀번호 입력페이지(remove_confirm.jsp)에서 전달된 값을 반환받아
비교 후 회원탈퇴 처리하고 로그아웃 처리페이지(member_logout_action.jsp)로
이동하는 JSP 문서 --%>
<%-- => 비로그인 상태에서 요청(비정상적인 요청)한 경우 에러페이지(error400.jsp) 이동 --%>
<%-- => 비밀번호가 틀릴 경우 비밀번호 입력페이지로 이동 --%>
<%@include file="/site/security/login_check.jspf" %>
<%
	if(request.getMethod().equals("GET")) {
		out.println("<script type='text/javascript'>");
		out.println("location.href='"+request.getContextPath()+"/site/index.jsp?workgroup=error&work=error400';");
		out.println("</script>");
		return;
	}
	
	//입력값을 반환받아 저장
	String passwd=Utility.encrypt(request.getParameter("passwd"));
	
	//입력 비밀번호를 로그인 사용자의 비밀번호와 비교하여 맞지 않을 경우
	if(!passwd.equals(loginMember.getPasswd())) {
		session.setAttribute("message", "비밀번호가 맞지 않습니다.");
		out.println("<script type='text/javascript'>");
		out.println("location.href='"+request.getContextPath()+"/site/index.jsp?workgroup=member&work=remove_confirm';");
		out.println("</script>");
		return;
	}
	
	//로그인 사용자의 아이디를 전달하여 MEMBER 테이블에 저장된 회원정보를
	//삭제하는 DAO 클래스의 메소드 호출
	MemberDAO.getDAO().deleteMember(loginMember.getId());
	
	//로그아웃 처리페이지로 이동
	out.println("<script type='text/javascript'>");
	out.println("location.href='"+request.getContextPath()+"/site/index.jsp?workgroup=member&work=member_logout_action';");
	out.println("</script>");
%>





