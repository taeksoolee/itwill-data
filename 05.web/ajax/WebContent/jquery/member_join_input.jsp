<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 회원정보를 입력하는 JSP 문서 --%>
<%-- => [회원가입]을 클릭한 경우 회원정보 저장페이지(member_join_action.jsp) 요청 --%>
<%-- => 저장페이지 요청 전 입력값에 대한 검증 : 입력검증, 형식검증, 중복검증(AJAX) 등 --%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>AJAX</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<style type="text/css">
.title {
	width: 100px;
	padding-right: 10px;
	text-align: center;
	font-weight: bold;
}

.input {
	width: 200px;
}

.message {
	width: 500px;
	color: red;
}

.msg {
	display: none;
}

#btn {
	text-align: center;
}
</style>
</head>
<body>
	<h1>회원가입</h1>
	<hr>
	<form action="member_join_action.jsp" method="post" id="joinForm">
	<table>
		<tr>
			<td class="title">아이디</td>
			<td class="input"><input type="text" name="id" id="id"></td>
			<td class="message">
				<div>
					<span id="idNullMsg" class="msg idMsg">아이디를 반드시 입력해 주세요.</span>
					<span id="idValidMsg" class="msg idMsg">아이디를 형식에 맞게 입력해 주세요.</span>
					<span id="idDuplMsg" class="msg idMsg">이미 사용중인 아이디입니다.</span>
				</div>
			</td>
		</tr>
		<tr>
			<td class="title">비밀번호</td>
			<td class="input"><input type="password" name="passwd" id="passwd"></td>
			<td class="message">
				<div>
					<span id="passwdNullMsg" class="msg">비밀번호를 반드시 입력해 주세요.</span>
					<span id="passwdValidMsg" class="msg">비밀번호를 형식에 맞게 입력해 주세요.</span>
			</div>
			</td>
		</tr>
		<tr>
			<td class="title">이름</td>
			<td class="input"><input type="text" name="name" id="name"></td>
			<td class="message">
				<div>
					<span id="nameNullMsg" class="msg">이름을 반드시 입력해 주세요.</span>
					<span id="nameValidMsg" class="msg">이름을 형식에 맞게 입력해 주세요.</span>
			</div>
			</td>
		</tr>
		<tr>
			<td class="title">이메일</td>
			<td class="input"><input type="text" name="email" id="email"></td>
			<td class="message">
				<div>
					<span id="emailNullMsg" class="msg">이메일을 반드시 입력해 주세요.</span>
					<span id="emailValidMsg" class="msg">이메일을 형식에 맞게 입력해 주세요.</span>
				</div>
			</td>
		</tr>
		<tr>
			<td colspan="2" id="btn">
				<button type="submit">회원가입</button>
			</td>	
			<td>&nbsp;</td>
		</tr>
	</table>
	</form>
	
	<script type="text/javascript">
	/*
	//아이디 중복 검증에 대한 결과값을 저장하기 위한 변수
	// => false : 아이디 중복, true : 아이디 미중복
	var idCheck=false;
	
	$("#id").focus();
	
	$("#joinForm").submit(function() {
		//모든 에러메세지 초기화
		$(".msg").hide();
		
		//입력값 검증 결과를 저장하기 위한 변수
		// => false : 검증 실패(요청 취소), true : 검증 성공
		var result=true;
		
		//입력값 검증
		var id=$("#id").val();
		var idReg=/^[a-zA-Z]\w{5,19}$/g;
		if(id=="") {
			$("#idNullMsg").show();
			result=false;
		} else if(!idReg.test(id)) {
			$("#idValidMsg").show();
			result=false;
		} else if(!idCheck) {
			$("#idDuplMsg").show();
			result=false;
		}
		
		var passwd=$("#passwd").val();
		var passwdReg=/^(?=.*[a-zA-Z])(?=.*[0-9])(?=.*[~!@#$%^&*_-]).{6,20}$/g;
		if(passwd=="") {
			$("#passwdNullMsg").show();
			result=false;
		} else if(!passwdReg.test(passwd)) {
			$("#passwdValidMsg").show();
			result=false;
		} 
		
		var name=$("#name").val();
		var nameReg=/^[가-힣]{2,10}$/g;
		if(name=="") {
			$("#nameNullMsg").show();
			result=false;
		} else if(!nameReg.test(name)) {
			$("#nameValidMsg").show();
			result=false;
		} 
		
		var email=$("#email").val();
		var emailReg=/^([a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+(\.[-a-zA-Z0-9]+)+)*$/g;
		if(email=="") {
			$("#emailNullMsg").show();
			result=false;
		} else if(!emailReg.test(email)) {
			$("#emailValidMsg").show();
			result=false;
		}
		
		//result 변수에 false가 저장된 경우 JSP 문서 요청 취소
		return result;
	});
	
	//입력태그에서 촛점이 벗어난 경우 호출되는 이벤트 핸들러 함수 등록
	$("#id").blur(function() {
		$(".idMsg").hide();
		
		var id=$("#id").val();
		var idReg=/^[a-zA-Z]\w{5,19}$/g;
		if(id=="") {
			$("#idNullMsg").show();
			result=false;
		} else if(!idReg.test(id)) {
			$("#idValidMsg").show();
			result=false;
		} else if(!idCheck) {
			$("#idDuplMsg").show();
			result=false;
		}
	}); 
	
	//입력태그에서 키보드 이벤트가 발생된 경우 호출되는 이벤트 핸들러 함수 등록
	// => 입력 아이디의 중복 검증을 위해 member_id_check.jsp 문서를 AJAX 
	//    요청하여 응답 결과를 제공받아 처리
	$("#id").keyup(function() {
		idCheck=false;
		
		var id=$("#id").val();
		if(id.length<6) return;
		
		$.ajax({
			type: "GET",
			url: "member_id_check.jsp",
			data: "id="+id,
			dataType: "xml",
			success: function(xmlDoc) {
				if($(xmlDoc).find("code").text()=="possible") {
					idCheck=true;
				}
			},
			error: function(xhr) {
				alert("에러코드 = "+xhr.status);

			}
		});
	});
	*/
	
	$("#id").focus();
	
	$("#joinForm").submit(function() {
		//모든 에러메세지 초기화
		$(".msg").hide();
		
		//입력값 검증 결과를 저장하기 위한 변수
		// => false : 검증 실패(요청 취소), true : 검증 성공
		var result=true;
		
		//입력값 검증
		var id=$("#id").val();
		var idReg=/^[a-zA-Z]\w{5,19}$/g;
		if(id=="") {
			$("#idNullMsg").show();
			result=false;
		} else if(!idReg.test(id)) {
			$("#idValidMsg").show();
			result=false;
		} else {
			$.ajax({
				type: "GET",
				url: "member_id_check.jsp",
				data: "id="+id,
				//async : 요청 방식 설정하는 속성
				// => false : 동기식 요청, true(기본) : 비동기식 요청
				async: false,
				dataType: "xml",
				success: function(xmlDoc) {
					if($(xmlDoc).find("code").text()=="impossible") {
						$("#idDuplMsg").show();
						result=false;
					}
				},
				error: function(xhr) {
					alert("에러코드 = "+xhr.status);

				}
			});
		}
		
		var passwd=$("#passwd").val();
		var passwdReg=/^(?=.*[a-zA-Z])(?=.*[0-9])(?=.*[~!@#$%^&*_-]).{6,20}$/g;
		if(passwd=="") {
			$("#passwdNullMsg").show();
			result=false;
		} else if(!passwdReg.test(passwd)) {
			$("#passwdValidMsg").show();
			result=false;
		} 
		
		var name=$("#name").val();
		var nameReg=/^[가-힣]{2,10}$/g;
		if(name=="") {
			$("#nameNullMsg").show();
			result=false;
		} else if(!nameReg.test(name)) {
			$("#nameValidMsg").show();
			result=false;
		} 
		
		var email=$("#email").val();
		var emailReg=/^([a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+(\.[-a-zA-Z0-9]+)+)*$/g;
		if(email=="") {
			$("#emailNullMsg").show();
			result=false;
		} else if(!emailReg.test(email)) {
			$("#emailValidMsg").show();
			result=false;
		}
		
		//result 변수에 false가 저장된 경우 JSP 문서 요청 취소
		return result;
	});
	</script>
</body>
</html>









