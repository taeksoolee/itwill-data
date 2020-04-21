<%@page import="site.itwill.dto.MemberDTO"%>
<%@page import="site.itwill.dao.BoardDAO"%>
<%@page import="site.itwill.dto.BoardDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 게시글번호를 전달받아 BOARD 테이블에 저장된 해당 행을 삭제 처리하고
게시글 목록 출력페이지(board_list.jsp)로 이동하는 JSP 문서 --%>    
<%
	//비정상적인 요청에 대한 응답처리
	if(request.getParameter("num")==null) {
		out.println("<script type='text/javascript'>");
		out.println("location.href='"+request.getContextPath()+"/site/index.jsp?workgroup=error&work=error400';");
		out.println("</script>");
		return;
	}	

	//전달값을 반환받아 저장
	int num=Integer.parseInt(request.getParameter("num"));
	
	//게시글번호를 전달하여 BOARD 테이블에 저장된 해당 게시글을 검색하여 
	//반환하는 DAO 클래스의 메소드 호출
	BoardDTO board=BoardDAO.getDAO().selectNumBoard(num);
	
	//검색된 게시글이 없거나 삭제글인 경우 => 비정상적인 요청
	if(board==null || board.getStatus()==9) {
		out.println("<script type='text/javascript'>");
		out.println("location.href='"+request.getContextPath()+"/site/index.jsp?workgroup=error&work=error400';");
		out.println("</script>");
		return;
	}		
	
	//세션에 저장된 인증정보(회원정보)를 반환받아 저장
	MemberDTO loginMember=(MemberDTO)session.getAttribute("loginMember");
	
	//로그인 상태의 사용자가 작성자가 아니거나 관리자가 아닌 경우 => 비정상적인 요청
	if(loginMember==null || !loginMember.getId().equals(board.getId()) 
		&& loginMember.getStatus()!=9) {
		out.println("<script type='text/javascript'>");
		out.println("location.href='"+request.getContextPath()+"/site/index.jsp?workgroup=error&work=error400';");
		out.println("</script>");
		return;
	}
	
	//게시글번호를 전달하여 BOARD 테이블에 저장된 해당 게시글을 삭제 
	//처리하는 DAO 클래스의 메소드 호출
	BoardDAO.getDAO().deleteBoard(num);
	
	//게시글 목록 출력페이지 이동
	out.println("<script type='text/javascript'>");
	out.println("location.href='"+request.getContextPath()+"/site/index.jsp?workgroup=board&work=board_list';");
	out.println("</script>");
%>







