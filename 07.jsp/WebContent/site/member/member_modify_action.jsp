<%@page import="site.itwill.dao.MemberDAO"%>
<%@page import="site.itwill.util.Utility"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 회원정보 변경 입력페이지(member_modify.jsp)에서 전달된 회원정보를 반환받아 
MEMBER 테이블에 저장된 회원정보를 변경하고 회원정보 상세 출력페이지(member_detail.jsp)로
이동하는 JSP 문서 --%>
<%@include file="/site/security/login_check.jspf" %>
<%
	//비정상적인 요청에 대한 응답처리
	if(request.getMethod().equals("GET")) {
		out.println("<script type='text/javascript'>");
		out.println("location.href='"+request.getContextPath()+"/site/index.jsp?workgroup=error&work=error400';");
		out.println("</script>");
		return;
	}

	//입력값을 반환받아 저장
	String id=request.getParameter("id");
	String passwd=request.getParameter("passwd");
	if(passwd!=null && !passwd.equals("")) {//비밀번호가 입력된 경우 - 새로운 비밀번호 사용
		passwd=Utility.encrypt(passwd);
	} else {//비밀번호가 입력되지 않은 경우 - 기존 비밀번호 사용
		passwd=loginMember.getPasswd();
	}
	String name=Utility.stripTag(request.getParameter("name"));
	String email=request.getParameter("email");
	String mobile=request.getParameter("mobile1")+"-"
		+request.getParameter("mobile2")+"-"+request.getParameter("mobile3");
	String zipcode=request.getParameter("zipcode");
	String address1=request.getParameter("address1");
	String address2=Utility.stripTag(request.getParameter("address2"));
	
	//DTO 인스턴스를 생성하여 반환받은 입력값으로 필드값 변경
	// => 입력값을 변환하여 필드값으로 저장
	MemberDTO member=new MemberDTO();
	member.setId(id);
	member.setPasswd(passwd);
	member.setName(name);
	member.setEmail(email);
	member.setMobile(mobile);
	member.setZipcode(zipcode);
	member.setAddress1(address1);
	member.setAddress2(address2);
		
	//변경 학생정보를 전달하여 MEMBER 테이블에 저장된 학생정보를 변경하는 
	//DAO 클래스의 메소드 호출
	MemberDAO.getDAO().updateMember(member);

	//변경된 회원정보를 세션의 인증정보로 저장
	session.setAttribute("loginMember", MemberDAO.getDAO().selectIdMember(id));
	
	//회원정보 상세 출력페이지로 이동
	out.println("<script type='text/javascript'>");
	out.println("location.href='"+request.getContextPath()+"/site/index.jsp?workgroup=member&work=member_detail';");
	out.println("</script>");
%>




