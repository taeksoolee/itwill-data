<%@page import="site.itwill.bean.Hewon"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 입력페이지(noUseBean_form.jsp)에서 전달된 값을 반환받아 공유하고
응답페이지(noUseBean_print.jsp)로 이동하는 JSP 문서 --%>    
<%
	//비정상적인 요청에 대한 응답 처리
	if(request.getMethod().equals("GET")) {
		response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
		return;
	}

	//입력값을 전달받기 위한 캐릭터셋 변경
	request.setCharacterEncoding("utf-8");

	//입력값을 반환받아 저장
	String name=request.getParameter("name");
	String phone=request.getParameter("phone");
	String address=request.getParameter("address");
	
	//VO 클래스로 인스턴스 생성하고 전달값으로 필드값 변경
	Hewon hewon=new Hewon();
	hewon.setName(name);
	hewon.setPhone(phone);
	hewon.setAddress(address);
	
	//Java 명령을 이용한 페이지 이동방법 
	// => 다른 JSP 문서에 응답 결과 제공 
	
	//1.리다이렉트 이동 : 클라이언트에게 301 코드와 URL 주소를 전달하여
	//다른 JSP 문서를 재요청하여 응답되도록 구현
	// => 클라이언트 브라우저의 URL 주소 변경
	// => session 내장객체를 이용하여 인스턴스 공유(Session Scope)
	//session.setAttribute("hewon", hewon);
	//response.sendRedirect("noUseBean_print.jsp");
	
	//2.포워드 이동 : 요청 JSP 문서에서 다른 JSP 문서로 스레드를 이동하여
	//응답되도록 구현
	// => 클라이언트 브라우저의 URL 주소 미변경
	// => request 내장객체를 이용하여 인스턴스 공유(Request Scope)
	request.setAttribute("hewon", hewon);

	//request.getRequestDispatcher(String url) : 스레드 이동 관련 정보를
	//저장하는 RequestDispatcher 인스턴스를 반환하는 메소드
	//RequestDispatcher.forward(ServletRequest request, ServletResponse reponse) : 
	//RequestDispatcher 인스턴스에 저장된 JSP 문서로 스레드를 이동시키는 메소드
	request.getRequestDispatcher("noUseBean_print.jsp").forward(request, response);
%>
