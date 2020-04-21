<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 회원정보변경을 위한 비밀번호를 입력하는 JSP 문서 --%>
<%-- => 비로그인 상태에서 요청(비정상적인 요청)한 경우 에러페이지(error400.jsp) 이동 --%>
<%-- => [입력완료] 버튼을 클릭한 경우 회원정보 변경 입력페이지(member_modify.jsp)를 요청하여 입력값 전달 --%>
<%@include file="/site/security/login_check.jspf" %>
<%
	String message=(String)session.getAttribute("message");
	if(message==null) {
		message="";
	} else {
		session.removeAttribute("message");
	}
%>
    
<form name="passwdForm" action="<%=request.getContextPath()%>/site/index.jsp?workgroup=member&work=member_modify" 
	method="post" onsubmit="return submitCheck();">
	<p>회원정보변경을 위한 비밀번호를 입력해 주세요.</p>
	<p>
		<input type="password" name="passwd">
		<button type="submit">입력완료</button>
	</p>	
	<p id="message" style="color: red;"><%=message %></p>
</form>

<script type="text/javascript">
passwdForm.passwd.focus();

function submitCheck() {
	if(passwdForm.passwd.value=="") {
		document.getElementById("message").innerHTML="비밀번호를 입력해 주세요.";
		passwdForm.passwd.focus();
		return false;
	}
	return true;
}
</script>









