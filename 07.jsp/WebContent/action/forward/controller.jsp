<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 클라이언트의 요청을 받아 forward 이동 처리하는 JSP 문서 --%>
<%-- => 전달값을 반환받아 다른 JSP 문서로 스레드 이동 --%>
<%
	String category=request.getParameter("category");

	if(category==null) {
		response.sendRedirect("forward_main.jsp");
		return;
	}
	
	//전달값을 이용하여 스레드가 이동될 JSP 문서의 경로 저장
	String forwardFilePath=category+".jsp";
%>

<%-- forward 태그 : 다른 JSP 문서로 스레드 이동 --%>
<%-- => 요청을 받아 처리 후 다른 JSP 문서로 응답할 수 있는 기능 제공 --%>
<%-- => page 속성값으로 표현식(Expression) 사용 가능 --%>
<%-- <jsp:forward page="JSP file"></jsp:forward> --%>
<%-- 태그내용이 없는 경우 시작태그와 종료태그를 동시에 구현 --%>
<%-- <jsp:forward page="JSP file"/> --%>
<%-- 클라이언트 브라우저의 URL 주소은 변경되지 않고 다른 JSP 문서를 
이용하여 응답 결과 제공 - forward 이동 --%>
<jsp:forward page="<%=forwardFilePath %>"/>