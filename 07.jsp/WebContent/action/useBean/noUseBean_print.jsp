<%@page import="site.itwill.bean.Hewon"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 처리페이지(noUseBean_action.jsp)에서 공유된 인스턴스를 반환받아 응답하는 JSP 문서 --%>
<%
	/*
	//비정상적인 요청에 대한 응답 처리
	if(session.getAttribute("hewon")==null) {
		response.sendError(HttpServletResponse.SC_BAD_REQUEST);
		return;
	}

	//공유 인스턴스를 반환받아 저장
	Hewon hewon=(Hewon)session.getAttribute("hewon");
	//다른 JSP 문서에서 사용할 수 없도록 공유 인스턴스 제거
	session.removeAttribute("hewon");
	*/
	
	//비정상적인 요청에 대한 응답 처리
	if(request.getAttribute("hewon")==null) {
		response.sendError(HttpServletResponse.SC_BAD_REQUEST);
		return;
	}
	
	//공유 인스턴스를 반환받아 저장
	Hewon hewon=(Hewon)request.getAttribute("hewon");
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP</title>
</head>
<body>
	<h1>회원정보확인</h1>
	<hr>
	<ul>
		<li>이름 = <%=hewon.getName() %></li>
		<li>전화번호 = <%=hewon.getPhone() %></li>
		<li>주소 = <%=hewon.getAddress() %></li>
	</ul>
</body>
</html>




