<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 이름과 이메일을 입력받아 해당 회원의 아이디를 클라이언트에게 전달하는 JSP 문서 --%>    
<%-- => 이름과 이메일을 전달하여 AJAX_MEMEBR 테이블에 저장된 해당 회원의 아이디를 검색하여 제공하는 JSP 문서 요청 --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>AJAX</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
</head>
<body>
	<h1>아이디 찾기</h1>
	<hr>
	<table>
		<tr>
			<td>이름</td>
			<td><input type="text" id="name"></td>
		</tr>
		<tr>
			<td>이메일</td>
			<td><input type="text" id="email"></td>
		</tr>
		<tr>
			<td colspan="2">
				<button type="button" id="btn">아이디 찾기</button>
			</td>
		</tr>
	</table>
	<hr>
	<div id="result"><%-- 홍길동님의 아이디는 [abc123]입니다.--%></div>
	
	<script type="text/javascript">
	$("#name").focus();
	
	$("#btn").click(function() {
		var name=$("#name").val();
		if(name=="") {
			$("#result").html("이름을 입력해 주세요.");
			$("#name").focus();
			return;	
		}
		
		var email=$("#email").val();
		if(email=="") {
			$("#result").html("이메일을 입력해 주세요.");
			$("#email").focus();
			return;	
		}
		
		$("#name").val("");
		$("#email").val("");
		
		$.ajax({
			type: "POST",
			url: "search_id_two.jsp",
			//요청 웹어플리케이션에 값을 전달할 경우 QueryString 형식으로 표현
			//data: "name="+name+"&email="+email,
			//요청 웹어플리케이션에 값을 전달할 경우 Object 객체 형식으로 표현
			data: {"name":name, "email":email},
			dataType: "xml",
			success: function(xmlDoc) {
				var code=$(xmlDoc).find("code").text();
				if(code=="success") {
					var id=$(xmlDoc).find("id").text();
					$("#result").html("<b>"+name+"</b>님의 아이디는 [<b>"+id+"</b>]입니다.")
				} else {
					$("#result").html("<b>"+name+"</b>님의 아이디는 존재하지 않습니다.")
				}
			},
			error: function(xhr) {
				alert("에러코드 = "+xhr.status);
			} 
		});
	});
	</script>
</body>
</html>
