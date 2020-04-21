<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 비로그인 상태 또는 로그인 상태를 구분하여 다른 응답 결과를 제공하는 JSP 문서 --%>
<%-- => 세션에 저장된 인증정보를 이용하여 상태 구분 --%>
<%-- 비로그인 상태 : 인증정보(아이디와 비밀번호)를 입력받아 처리페이지(login_action.jsp)를 요청하여 전달 - 입력페이지 --%>
<%-- 로그인 상태 : 환영메세지 출력 - 출력페이지 --%>
<%
	String message=(String)session.getAttribute("message");	
	if(message==null) {
		message="";
	} else {
		session.removeAttribute("message");
	}
	
	String id=(String)session.getAttribute("id");	
	if(id==null) {
		id="";
	} else {
		session.removeAttribute("id");
	}
	
	String loginId=(String)session.getAttribute("loginId");
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP</title>
</head>
<body>
	<% if(loginId==null) { //비로그인 상태 %>
		<h1>로그인</h1>
		<hr>
		<form action="login_action.jsp" method="post" name="loginForm">
		<table>
			<tr>
				<td>아이디</td>
				<td><input type="text" name="id" value="<%=id%>"></td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td><input type="password" name="passwd"></td>
			</tr>
			<tr>
				<td colspan="2">
					<button type="button" id="btn">로그인</button>
				</td>
			</tr>
		</table>
		</form>
		<div id="message" style="color: red;"><%=message %></div>
	<% } else { //로그인 상태 %>
		<h1>로그인 성공</h1>
		<hr>
		<p><%=loginId %>님 환영합니다.&nbsp;&nbsp;
		<a href="logout_action.jsp">로그아웃</a></p>
	<% } %>
	
	<script type="text/javascript">
	loginForm.id.focus();
	
	document.getElementById("btn").onclick=function() {
		if(loginForm.id.value=="") {
			document.getElementById("message").innerHTML="아이디를 입력해 주세요.";
			loginForm.id.focus();
			return;
		}
		
		if(loginForm.passwd.value=="") {
			document.getElementById("message").innerHTML="비밀번호를 입력해 주세요.";
			loginForm.passwd.focus();
			return;
		}
		
		loginForm.submit();
	}
	</script>
</body>
</html>