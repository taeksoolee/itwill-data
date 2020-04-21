<%@page import="site.itwill.dao.BoardDAO"%>
<%@page import="site.itwill.dto.BoardDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 입력페이지(board_modify.jsp)에서 전달된 값을 반환받아 BOARD 테이블에
저장된 게시글을 변경하고 게시글 출력페이지(board_detail.jsp)로 이동하는 JSP 문서 --%>
<%
	//비정상적인 요청에 대한 응답처리
	if(request.getMethod().equals("GET")) {
		out.println("<script type='text/javascript'>");
		out.println("location.href='"+request.getContextPath()+"/site/index.jsp?workgroup=error&work=error400';");
		out.println("</script>");
		return;
	}

	//전달값 반환받아 저장
	int num=Integer.parseInt(request.getParameter("num"));
	String pageNum=request.getParameter("pageNum");
	String search=request.getParameter("search");
	String keyword=request.getParameter("keyword");
	
	String subject=request.getParameter("subject").replace("<", "&lt;").replace(">", "&gt;");
	int status=0;
	if(request.getParameter("secret")!=null) {
		status=Integer.parseInt(request.getParameter("secret"));
	}
	String content=request.getParameter("content").replace("<", "&lt;").replace(">", "&gt;");
	
	//DTO 인스턴스를 생성하고 필드값 변경
	BoardDTO board=new BoardDTO();
	board.setNum(num);
	board.setSubject(subject);
	board.setStatus(status);
	board.setContent(content);
	
	//게시글을 전달하여 BOARD 테이블에 저장된 해당 게시글을 변경하는 DAO 클래스의 메소드 호출
	BoardDAO.getDAO().updateBoard(board);
	
	//게시글 출력페이지로 이동
	//게시글 목록 출력페이지 이동
	out.println("<script type='text/javascript'>");
	out.println("location.href='"+request.getContextPath()
		+"/site/index.jsp?workgroup=board&work=board_detail&num="+num
		+"&pageNum="+pageNum+"&search="+search+"&keyword="+keyword+"';");
	out.println("</script>");
%>    









