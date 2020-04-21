<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 회원정보를 입력받아 처리페이지(join_action.jsp)를 요청하여 전달하는 JSP 문서 - 입력페이지 --%>
<%
	/*
	//처리페이지(join.jsp)에서 QueryString으로 전달된 값을 반환받아 저장
	// => QueryString으로 전달된 값은 캐릭터셋을 변경 불필요
	String message=request.getParameter("message");
	//전달값이 없는 경우 null 대신 NullString("")으로 변경하여 저장 - 정상적인 요청 
	// => 표현식에 의해 null이 문자열로 변환되어 출력되는 것을 방지
	if(message==null) message="";
	*/
	
	String message=(String)session.getAttribute("message");
	if(message==null) {
		message="";
	} else {
		//다른 JSP 문서에 공유되는 것을 방지하기 위해 공유 인스턴스 제거
		session.removeAttribute("message");
	}
%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>JSP</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="js/common.js"></script>
<script type="text/javascript">
	function loading() {
		window.document.join.id.focus();
	}
	
	function inputCheck(form) {
		if(is_null(form.id)) {
			alert("아이디를 입력해 주세요.");
			form.id.focus();
			return false;
		}
		
		
		if(!isID(form.id)) {
			alert("아이디는 영문자로 시작되며 영문자,숫자,_의 조합만 가능합니다.");
			form.id.focus();
			return false;
		}
		
		if(is_null(form.pass)) {
			alert("비밀번호를 입력해 주세요.");
			form.pass.focus();
			return false;
		}
		
		if(is_null(form.repass)) {
			alert("비밀번호확인을 입력해 주세요.");
			form.repass.focus();
			return false;
		}			
		
		if(isShort(form.pass, 6, "비밀번호는 6글자 이상 입력해 주세요.")) {
			return false;
		}
		
		if(!isSame(form.pass, form.repass)) {
			alert("비밀번호와 비밀번호확인이 서로 같지 않습니다.");
			form.pass.focus();
			return false;
		}
		
		if(is_null(form.name)) {
			alert("이름을 입력해 주세요.");
			form.name.focus();
			return false;
		}	
		
		if(is_null(form.addr)) {
			alert("주소를 입력해 주세요.");
			form.addr.focus();
			return false;
		}
		
		return true;			
	}
	
</script>
<link rel="stylesheet" href="css/common.css" type="text/css"/>
</head>
<body onload="loading();">
	<h3 align="center">◆◆◆ 회원가입 ◆◆◆</h3>
	<form name="join" method="post" action="join_action.jsp" 
		onsubmit="return inputCheck(join);">
		<table bgcolor="black" cellspacing="1" cellpadding="5" align="center">
		<tr>
			<th bgcolor="44ff44"><font size="2">아이디</font></th>
			<td bgcolor="white" width="300">
				<input type="text" size="10" name="id" class="TXTFLD">
			</td>
		</tr>
		<tr>
			<th bgcolor="44ff44"><font size="2">비밀번호</font></th>
			<td bgcolor="white" width="300">
				<input type="password" size="10" name="pass" class="TXTFLD">
			</td>
		</tr>
		<tr>
			<th bgcolor="44ff44"><font size="2">비밀번호확인</font></th>
			<td bgcolor="white" width="300">
				<input type="password" size="10" name="repass" class="TXTFLD">
			</td>
		</tr>
		<tr>
			<th bgcolor="44ff44"><font size="2">이름</font></th>
			<td bgcolor="white" width="300">
				<input type="text" size="10" name="name" class="TXTFLD">
			</td>
		</tr>
		<tr>
			<th bgcolor="44ff44"><font size="2">주소</font></th>
			<td bgcolor="white" width="300">
				<input type="text" size="30" name="addr" class="TXTFLD">
			</td>
		</tr>
		<tr>
			<th bgcolor="44ff44"><font size="2">성별</font></th>
			<td bgcolor="white" width="300">
				<input type="radio" name="sex" value="남자" checked><font size="2">남자</font>
				<input type="radio" name="sex" value="여자"><font size="2">여자</font>
			</td>
		</tr>
		<tr>
			<th bgcolor="44ff44"><font size="2">직업</font></th>
			<td bgcolor="white" width="300">
				<select name="job">
					<option value="학생">학생</option>
					<option value="주부">주부</option>
					<option value="회사원">회사원</option>
					<option value="기타">기타</option>
				</select>
			</td>
		</tr>
		<tr>
			<th bgcolor="44ff44"><font size="2">취미</font></th>
			<td bgcolor="white" width="300">
				<input type="checkbox" name="hobby" value="게임" checked><font size="2">게임</font>
				<input type="checkbox" name="hobby" value="등산"><font size="2">등산</font>
				<input type="checkbox" name="hobby" value="낚시"><font size="2">낚시</font>
				<input type="checkbox" name="hobby" value="운동"><font size="2">운동</font>
				<input type="checkbox" name="hobby" value="기타"><font size="2">기타</font>
			</td>
		</tr>
		<tr>
			<th bgcolor="44ff44"><font size="2">자기소개</font></th>
			<td bgcolor="white" width="300">
				<textarea rows="5" cols="40" name="profile"></textarea>
			</td>
		</tr>		
		<tr>
			<th colspan="2" bgcolor="ff8888">
				<input type="submit" value="가입">
				<input type="reset" value="취소">
			</th>
		</tr>
		</table>
	</form>
	<p style="color: red; text-align: center;"><%=message %></p>
</body>
</html>










