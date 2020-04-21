<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- Spring에서 제공하는 스프링폼 태그 라이브러리 포함  --%>    
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Spring</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<style type="text/css">
.error { color: red; }
</style>
</head>
<body>
	<h1>회원등록 - Spring Form</h1>
	<hr>
	<%-- form(Spring) 태그 : 처리페이지를 요청하여 입력값을 전달하는 태그 --%>
	<%-- modelAttribute 속성(필수) : Command 객체명을 속성값으로 설정 --%>
	<%-- => 요청처리 메소드에 반드시 Command 객체를 선언해야만 사용 가능 --%>
	<%-- => 입력값에 대한 유효성 검사에서 오류가 발생된 경우 입력태그에 기존 입력값을 초기값으로 출력되도록 제공하는 기능 --%>
	<form:form action="valid_spring" method="post" id="form" modelAttribute="hewon">
	<table>
		<tr>
			<td>아이디</td>
			<td>
				<%-- input(Spring) 태그 : 텍스트를 입력받기 위한 태그 - HTML의 input 태그(type 속성값 : text) --%>
				<%-- path 속성 : HTML 입력태그의 name 속성과 id 속성을 동시에 선언하는 효과 제공 --%>
				<%-- => 유효성 검사에서 오류가 발생된 경우 value 속성의 기능 제공 --%>
				<form:input path="id"/>
			</td>
			<td>
				<%-- errors(Spring) 태그 : 에러메세지를 출력하는 태그 --%>
				<%-- => path 속성값과 동일한 필드의 에러메세지 출력 --%>
				<%-- delimiter 속성 : 에러메세지가 여러개인 경우 메세지를 
				구분하기 위한 구분자를 속성값으로 설정 = 기본 구분자 : <br> --%>
				<form:errors path="id" class="error" delimiter=" "/>
				<span id="idMsg" class="error"></span>
			</td>
		</tr>
		<tr>
			<td>비밀번호</td>
			<td>
				<%-- password(Spring) 태그 : 텍스트를 입력받기 위한 태그 - HTML의 input 태그(type 속성값 : password) --%>
				<form:password path="passwd"/>
			</td>
			<td>
				<form:errors path="passwd" class="error"/>
				<span id="passwdMsg" class="error"></span>
			</td>
		</tr>
		<tr>
			<td>이름</td>
			<td>
				<form:input path="name"/>
			</td>
			<td>
				<form:errors path="name" class="error"/>
				<span id="nameMsg" class="error"></span>
			</td>
		</tr>
		<tr>
			<td>이메일</td>
			<td>
				<form:input path="email"/>
			</td>
			<td>
				<form:errors path="email" class="error"/>
				<span id="emailMsg" class="error"></span>
			</td>
		</tr>
		<tr>
			<td>성별</td>
			<td>
				<%-- radiobutton(Spring) 태그 : 목록 중 하나만 선택하여 입력하는 태그 - HTML의 input 태그(type 속성값 : radio) --%>
				<%-- path 속성 대신 id 또는 name, value 속성 사용 가능 --%>
				<%-- Spring에서 제공되는 태그는 반드시 속성과 속성값이 하나의 쌍으로 표현 - 속성값이 생략된 경우 에러 발생 --%>
				<%-- 
				남자<form:radiobutton path="gender" id="gender1" value="남자" checked="checked"/>
				&nbsp;&nbsp;
				여자<form:radiobutton path="gender" id="gender2" value="여자"/>
				--%>
				
				<%-- radiobuttons(Spring) 태그 : 목록 중 하나만 선택하여 입력하는 태그 - HTML의 input 태그(type 속성값 : radio) --%>
				<%-- items 속성 : 뷰페이지에 제공되는 List 객체를 속성값으로 설정 --%>
				<%-- => List 객체의 요소가 선택 목록으로 설정 --%>
				<%-- => 기본값 설정이 불가능하므로 JavaScript를 이용하여 설정 --%>
				<form:radiobuttons path="gender" items="${genderList}"/>
				
				<%-- <form:select path="gender" items="${genderList}"/> --%>
			</td>
			<td>
				<form:errors path="gender" class="error"/>
				<span id="genderMsg" class="error"></span>
			</td>
		</tr>
		<tr>
			<td colspan="3">
				<button type="submit">회원등록</button>
			</td>
		</tr>
	</table>
	</form:form>
	<script type="text/javascript">
	$("#gender2").prop("checked", true);
	
	$("#form").submit(function() {
		$(".error").text("");
		
		/*
		if($("#id").val()=="") {
			$("#idMsg").text("아이디를 입력해 주세요.");
			$("#id").focus();
			return false;
		}
		var idReg=/^[a-zA-Z]\w{5,19}$/g;
		if(!idReg.test($("#id").val())) {
			$("#idMsg").text("아이디를 형식에 맞게 입력해 주세요.");
			$("#id").focus();
			return false;
		}
		
		if($("#passwd").val()=="") {
			$("#passwdMsg").text("비밀번호를 입력해 주세요.");
			$("#passwd").focus();
			return false;
		}
		var passwdReg=/^(?=.*[a-zA-Z])(?=.*[0-9])(?=.*[~!@#$%^&*_-]).{6,20}$/g;
		if(!passwdReg.test($("#passwd").val())) {
			$("#passwdMsg").text("비밀번호를 형식에 맞게 입력해 주세요.");
			$("#passwd").focus();
			return false;
		}

		if($("#name").val()=="") {
			$("#nameMsg").text("이름을 입력해 주세요.");
			$("#name").focus();
			return false;
		}
		var nameReg=/^[가-힣]{2,10}$/g;
		if(!nameReg.test($("#name").val())) {
			$("#nameMsg").text("이름을 형식에 맞게 입력해 주세요.");
			$("#name").focus();
			return false;
		}

		if($("#email").val()=="") {
			$("#emailMsg").text("이메일을 입력해 주세요.");
			$("#email").focus();
			return false;
		}
		var emailReg=/^([a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+(\.[-a-zA-Z0-9]+)+)*$/g;
		if(!emailReg.test($("#email").val())) {
			$("#emailMsg").text("이메일을 형식에 맞게 입력해 주세요.");
			$("#email").focus();
			return false;
		}
		*/
	});
	</script>
</body>
</html>
