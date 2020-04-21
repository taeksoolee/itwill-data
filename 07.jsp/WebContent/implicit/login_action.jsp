<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 입력페이지(login_form.jsp)에서 전달된 인증정보를 반환받아 인증 처리하는 JSP 문서 - 처리페이지 --%>
<%-- => 인증성공 : 인증 관련 정보를 공유 후 환영메세지 출력 --%>    
<%-- => 인증실패 : 에러메세지와 아이디 공유 후 입력페이지로 이동 --%>
<%
	//비정상적인 요청에 대한 응답처리
	if(request.getMethod().equals("GET")) {
		session.setAttribute("message", "비정상적인 방법으로 페이지를 요청 하였습니다.");
		response.sendRedirect("login_form.jsp");
		return;
	}

	//입력값을 반환받아 저장
	String id=request.getParameter("id");
	String passwd=request.getParameter("passwd");
	
	//인증 실패에 대한 응답 처리
	if(!id.equals("abc123") || !passwd.equals("123456")) {
		session.setAttribute("message", "가입하지 않은 아이디이거나, 잘못된 비밀번호입니다.");
		session.setAttribute("id", id);
		response.sendRedirect("login_form.jsp");
		return;
	}
	
	//인증 성공 - 인증 관련 정보를 세션에 저장(공유)
	session.setAttribute("loginId", id);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP</title>
</head>
<body>
	<h1>로그인 성공</h1>
	<hr>
	<p><%=id %>님 환영합니다.&nbsp;&nbsp;
	<a href="logout_action.jsp">로그아웃</a></p>
	<p><a href="login_form.jsp">로그인 입력페이지 이동</a></p>
</body>
</html>





