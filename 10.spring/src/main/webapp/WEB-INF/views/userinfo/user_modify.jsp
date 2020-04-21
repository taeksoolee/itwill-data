<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 모델에서 저장된 회원정보를 입력태그를 이용하여 클라이언트에게 전달하는 JSP 문서 --%>
<%-- => [수정]을 클릭한 경우 회원정보 변경 처리페이지(/userinfo/modify) 요청 - POST --%>    
<%-- => [목록]을 클릭한 경우 회원목록 출력페이지(/userinfo/list) 요청 --%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Spring</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel=stylesheet href="${pageContext.request.contextPath}/css/user.css" type="text/css">
<script language="JavaScript">
function userModify() {
	if ( f.name.value == "" ) {
		alert("이름을 입력하십시요.");
		f.name.focus();
		return false;
	}
	f.action = "${pageContext.request.contextPath}/userinfo/modify";
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
	  <input type="hidden" name="userid" value="${userinfo.userid }">
	  <table border="0" cellpadding="0" cellspacing="1" width="590" bgcolor="BBBBBB">
		  <tr>
			<td width=100 align=center bgcolor="E6ECDE" height="22">아이디</td>
			<td width=490 bgcolor="ffffff" style="padding-left:10px;">
				${userinfo.userid }
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
				<input type="text" style="width:240" name="name" value="${userinfo.name }">
			</td>
		  </tr>
		  <tr>
			<td width=100 align=center bgcolor="E6ECDE" height="22">이메일 주소</td>
			<td width=490 bgcolor="ffffff" style="padding-left:10px;">
				<input type="text" style="width:240" name="email" value="${userinfo.email }">
			</td>
		  </tr>		  
	  </table>
	  </form>
	  <br>
	  
	  <table width=590 border=0 cellpadding=0 cellspacing=0>
		  <tr>
			<td align=center>
			<input type="button" value="수정" onClick="userModify();">
			<input type="button" value="목록" onClick="location.href='${pageContext.request.contextPath}/userinfo/list';">
			</td>
		  </tr>
	  </table>

	  </td>
	</tr>
</table>  

</body>
</html>