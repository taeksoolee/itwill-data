<%@page import="site.itwill.dao.StudentDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 학번을 전달받아 STUDENT 테이블에 저장된 해당 학번의 학생정보를 삭제하고
학생정보 검색 출력페이지(displayStudent.jsp)로 이동하는 JSP 문서 --%>        
<%
	//비정상적인 요청에 대한 응답처리
	if(request.getParameter("no")==null) {
		session.setAttribute("message", "비정상적인 방법으로 페이지를 요청 하였습니다.");
		response.sendRedirect("displayStudent.jsp");
		return;
	}

	//전달된 학번을 반환받아 저장
	int no=Integer.parseInt(request.getParameter("no"));
	
	//전달된 학번의 학생정보를 STUDENT 테이블에서 삭제하는 DAO 클래스의 메소드 호출
	int rows=StudentDAO.getDAO().deleteStudent(no);

	//비정상적인 요청에 대한 응답 처리
	if(rows<=0) {//삭제된 학생정보가 없는 경우
		session.setAttribute("message", "삭제하고자 하는 학번의 학생정보가 없습니다.");
	}
	
	//학생정보 검색 출력페이지로 이동
	response.sendRedirect("displayStudent.jsp");
%>






