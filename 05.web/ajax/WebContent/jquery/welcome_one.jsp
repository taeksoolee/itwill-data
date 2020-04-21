<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- welcome_two.jsp 문서를 AJAX 기능으로 요청하여 결과(HTML)를 응답받아 
클라이언트에게 전달하는 JSP 문서 --%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>AJAX</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
</head>
<body>
	<h1>jQuery AJAX</h1>
	<hr>
	<label>이름 입력</label>
	<input type="text" id="name">
	<button type="button" id="btn">전송</button>
	<hr>
	<div id="message"></div>
	
	<script type="text/javascript">
	$("#name").focus();
	
	$("#btn").click(function() {
		var name=$("#name").val();
		if(name=="") {
			$("#message").html("이름을 입력해 주세요.");
			return;
		}
		
		$("#name").val("");
		
		//$.ajax() : AJAX 기능을 제공하는 jQuery 메소드
		// => AJAX 기능을 구현하기 위한 정보를 Object 객체 형식으로 전달
		// => Object 객체의 특정 속성에 값 또는 함수를 설정하여 AJAX 기능 구현
		$.ajax({
			type: "POST",//요청방식
			url: "welcome_two.jsp",//요청 문서의 URL 주소
			data: "name="+name,//전달할 변수와 값 설정
			dataType: "html",//요청에 대한 응답결과 형식
			//정상적인 응답결과를 제공받아 처리하는 함수 설정
			//=> 응답결과가 자동으로 함수 매개변수에 전달되어 저장
			success: function(html) {
				$("#message").html(html);
			},
			//비정상적인 응답결과를 제공받아 처리하는 함수 설정
			// => XMLHttpRequest 객체가 자동으로 함수 매개변수에 전달되어 저장
			error: function(xhr) {
				$("#message").html("에러코드 = "+xhr.status);
			}
		});
	});
	</script>
</body>
</html>












