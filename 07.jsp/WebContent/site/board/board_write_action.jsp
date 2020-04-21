<%@page import="site.itwill.dao.BoardDAO"%>
<%@page import="site.itwill.dto.BoardDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 게시글 입력페이지(board_write.jsp)에서 전달된 게시글(새글 또는 답급)을
반환받아 BOARD 테이블에 저장하고 게시글 목록 출력페이지(board_list.jsp)로 
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

	//입력값(전달값)을 반환받아 저장
	int ref=Integer.parseInt(request.getParameter("ref"));
	int reStep=Integer.parseInt(request.getParameter("reStep"));
	int reLevel=Integer.parseInt(request.getParameter("reLevel"));
	String pageNum=request.getParameter("pageNum");

	//입력값에서 태그 관련 기호를 Escape 문자로 변환하여 저장
	// => XSS 공격을 방어하는 방법
	String subject=request.getParameter("subject").replace("<", "&lt;").replace(">", "&gt;");
	int status=0;
	//비밀글(checkbox)를 체크하여 전달된 경우
	if(request.getParameter("secret")!=null) {
		status=Integer.parseInt(request.getParameter("secret"));
	}
	String content=request.getParameter("content").replace("<", "&lt;").replace(">", "&gt;");
	
	//시퀸스 객체의 다음값을 검색하여 반환하는 DAO 클래스의 메소드 호출
	int num=BoardDAO.getDAO().selectNextNum();
	
	//클라이언트의 IP 주소를 반환받아 저장
	//request.getRemoteAddr() : 클라이언트의 IP 주소를 반환하는메소드
	// => 이클립스에 의해 동작되는 WAS는 IPV6 프로토콜의 128bit 형태에 IP 주소 제공
	// => Run > Run Configurations... > Apache Tomcat > Tomcat 이름 > 
	//    Arguments > VM Arguments > [-Djava.net.preferIPv4Stack=true] 추가 
	String ip=request.getRemoteAddr();
	//System.out.println("ip = "+ip);
	
	//새글 또는 답글을 구분하여 처리하기 위한 명령
	if(ref==0) {//새글
		ref=num;
	} else {//답글
		//부모글 정보(ref, reStep)를 전달하여 BOARD 테이블에 저장된 게시글
		//정보를 변경하는 DAO 클래스의 메소드 호출
		BoardDAO.getDAO().updateReStep(ref, reStep);
	
		//부모글의 reStep 전달값과 reLevel 전달값을 1 증가
		reStep++;
		reLevel++;
	}
	
	//DTO 인스턴스를 생성하고 필드값 변경
	BoardDTO board=new BoardDTO();
	board.setNum(num);//자동증가값
	board.setId(loginMember.getId());//로그인 사용자 아이디
	board.setWriter(loginMember.getName());//로그인 사용자 이름
	board.setSubject(subject);//입력값
	board.setRef(ref);//새글 : 자동증가값, 답글 : 부모글 전달값(ref)
	board.setReStep(reStep);//새글 : 0, 답글 : 부모글 전달값(reStep)+1
	board.setReLevel(reLevel);//새글 : 0, 답글 : 부모글 전달값(reLevel)+1
	board.setContent(content);//입력값
	board.setIp(ip);//클라이언트 IP 주소
	board.setStatus(status);//일반글 : 0, 비밀글 : 1
	
	//게시글을 전달하여 BOARD 테이블에 저장하는 DAO 클래스의 메소드 호출
	BoardDAO.getDAO().insertBoard(board);
	
	//게시글 목록 출력페이지 이동
	// => 페이지 번호 전달 - 새글 : 1 페이지, 답글 : 부모글의 페이지 번호  
	out.println("<script type='text/javascript'>");
	out.println("location.href='"+request.getContextPath()+"/site/index.jsp?workgroup=board&work=board_list&pageNum="+pageNum+"';");
	out.println("</script>");
%>