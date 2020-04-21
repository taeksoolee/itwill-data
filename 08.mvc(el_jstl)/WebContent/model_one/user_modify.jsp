<%@page import="site.itwill.dao.UserinfoModelOneDAO"%>
<%@page import="site.itwill.dto.UserinfoDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 아이디를 전달받아 USERINFO 테이블에 저장된 해당 회원정보를 검색하여
입력태그에 출력하여 클라이언트에게 전달하는 JSP 문서 --%>
<%-- => 관리자 또는 로그인 사용자가 수정 사용자인 경우에만 접근 가능 --%>
<%-- => [수정]을 클릭한 경우 회원정보 변경 처리페이지(user_modify_action.jsp) 요청 --%>    
<%-- => [목록]을 클릭한 경우 회원목록 출력페이지(user_list.jsp) 요청 --%>
<%
	UserinfoDTO loginUserinfo=(UserinfoDTO)session.getAttribute("loginUserinfo");
	String userid=request.getParameter("userid");

	if(loginUserinfo==null || loginUserinfo.getStatus()!=9 
			&& !loginUserinfo.getUserid().equals(userid)) {
		response.sendRedirect("user_error.jsp");
		return;
	}
	
	UserinfoDTO userinfo=UserinfoModelOneDAO.getDAO().selectUserinfo(userid);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>MVC</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel=stylesheet href="css/user.css" type="text/css">
<script language="JavaScript">
function userModify() {
	if ( f.name.value == "" ) {
		alert("이름을 입력하십시요.");
		f.name.focus();
		return false;
	}
	f.action = "user_modify_action.jsp";
	f.submit();
}
</script>
</head>
<body bgcolor=#FFFFFF text=#000000 leftmargin=0 topmargin=0 marginwidth=0 marginheight=0>
<br>
<table width=780 border=0 cellpadding=0 cellspacing=0>
	<tr>
	  <td width="20"></td>
	  <td>
	  <table width=590 border=0 cellpadding=0 cellspacing=0>
		  <tr>
			<td bgcolor="f4f4f4" height="22">&nbsp;&nbsp;<b>회원관리 - 회원정보수정</b></td>
		  </tr>
	  </table>  
	  <br>
	  
	  <form name="f" method="post">
	  <input type="hidden" name="userid" value="<%=userinfo.getUserid()%>">
	  <table border="0" cellpadding="0" cellspacing="1" width="590" bgcolor="BBBBBB">
		  <tr>
			<td width=100 align=center bgcolor="E6ECDE" height="22">아이디</td>
			<td width=490 bgcolor="ffffff" style="padding-left:10px;">
				<%=userinfo.getUserid()%>
			</td>
		  </tr>
		  <tr>
			<td width=100 align=center bgcolor="E6ECDE" height="22">비밀번호</td>
			<td width=490 bgcolor="ffffff" style="padding-left:10px;">
				<input type="password" style="width:150" name="password">
			</td>
		  </tr>
		  <tr>
			<td width=100 align=center bgcolor="E6ECDE" height="22">이름</td>
			<td width=490 bgcolor="ffffff" style="padding-left:10px;">
				<input type="text" style="width:240" name="name" value="<%=userinfo.getName()%>">
			</td>
		  </tr>
		  <tr>
			<td width=100 align=center bgcolor="E6ECDE" height="22">이메일 주소</td>
			<td width=490 bgcolor="ffffff" style="padding-left:10px;">
				<% if(userinfo.getEmail()!=null) { %>
				<input type="text" style="width:240" name="email" value="<%=userinfo.getEmail()%>">
				<% } else { %>
				<input type="text" style="width:240" name="email">
				<% } %>
			</td>
		  </tr>		  
	  </table>
	  </form>
	  <br>
	  
	  <table width=590 border=0 cellpadding=0 cellspacing=0>
		  <tr>
			<td align=center>
			<input type="button" value="수정" onClick="userModify();">
			<input type="button" value="목록" onClick="location.href='user_list.jsp';">
			</td>
		  </tr>
	  </table>

	  </td>
	</tr>
</table>  

</body>
</html>