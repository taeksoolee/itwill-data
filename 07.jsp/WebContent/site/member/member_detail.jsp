<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 로그인 회원정보를 클라이언트에게 전달하는 JSP 문서 --%>
<%-- => 비로그인 상태에서 요청(비정상적인 요청)한 경우 에러페이지(error400.jsp) 이동 --%>
<%-- => [회원정보변경]을 클릭한 경우 회원정보변경을 위한 비밀번호 입력페이지(modify_confirm.jsp)로 이동 --%>
<%-- => [회원탈퇴]을 클릭한 경우 회원정보삭제를 위한 비밀번호 입력페이지(remove_confirm.jsp)로 이동 --%>
<style type="text/css">
#detail {
	width: 400px;
	margin: 0 auto;
	text-align: left;
}

#mypage {
	font-size: 1.1em;
}

#mypage a:hover {
	color: orange;
}
</style>
<%@include file="/site/security/login_check.jspf" %>    
<h1>회원상세정보</h1>
<div id="detail">
	<ul>
		<li>아이디 = <%=loginMember.getId() %></li>
		<li>이름 = <%=loginMember.getName() %></li>
		<li>이메일 = <%=loginMember.getEmail() %></li>
		<li>전화번호 = <%=loginMember.getMobile() %></li>
		<li>우편번호 = <%=loginMember.getZipcode() %></li>
		<li>기본주소 = <%=loginMember.getAddress1() %></li>
		<li>상세주소 = <%=loginMember.getAddress2() %></li>
		<li>회원가입날짜 = <%=loginMember.getJoinDate().substring(0, 19) %></li>
		<li>마지막 로그인 날짜 = <%=loginMember.getLastLogin().substring(0, 19) %></li>
	</ul>
</div>

<div id="mypage">
	<a href="<%=request.getContextPath()%>/site/index.jsp?workgroup=member&work=modify_confirm">[회원정보변경]</a>&nbsp;&nbsp;
	<a href="<%=request.getContextPath()%>/site/index.jsp?workgroup=member&work=remove_confirm">[회원탈퇴]</a>&nbsp;&nbsp;
</div>
