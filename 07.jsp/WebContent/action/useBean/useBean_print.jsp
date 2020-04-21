<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 처리페이지(useBean_action.jsp)에서 공유된 인스턴스를 반환받아 응답하는 JSP 문서 --%>
<%
	//비정상적인 요청에 대한 응답 처리
	if(request.getAttribute("hewon")==null) {
		response.sendError(HttpServletResponse.SC_BAD_REQUEST);
		return;
	}
%>  
<jsp:useBean id="hewon" class="site.itwill.bean.Hewon" scope="request"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP</title>
</head>
<body>
	<h1>회원정보확인</h1>
	<hr>
	<%-- getProperty 태그의 기능 --%>
	<%-- => useBean 태그로 제공된 인스턴스의 필드값을 반환하는 기능 제공 - Getter 메소드 --%>
	<ul>
		<li>이름 = <jsp:getProperty property="name" name="hewon"/></li>
		<li>전화번호 = <jsp:getProperty property="phone" name="hewon"/></li>
		<li>주소 = <jsp:getProperty property="address" name="hewon"/></li>
	</ul>
</body>
</html>