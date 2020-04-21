<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>AJAX</title>
<script type="text/javascript" src="js/xhr.js"></script>
<style type="text/css">
#display {
	width: 50%;
	padding: 5px;
	margin-bottom: 10px;
	font-size: 30px;
	border: 1px solid red;
}
</style>
</head>
<body>
	<h1>AJAX 모듈 테스트</h1>
	<hr>
	<div id="display">요청 어플리케이션의 응답결과 출력</div>
	<table>
		<tr>
			<td>아이디</td>
			<td><input type="text" id="id"></td>
		</tr>
		<tr>
			<td>이름</td>
			<td><input type="text" id="name"></td>
		</tr>
		<tr>
			<td colspan="2"><button type="button" id="btn">요청</button></td>
		</tr>
	</table>
	
	<script type="text/javascript">
	document.getElementById("btn").onclick=function() {
		var id=document.getElementById("id").value;
		if(id=="") {
			document.getElementById("display").innerHTML="아이디를 입력해 주세요.";
			return;
		}
		
		var name=document.getElementById("name").value;
		if(name=="") {
			document.getElementById("display").innerHTML="이름을 입력해 주세요.";
			return;
		}
		
		document.getElementById("id").value="";
		document.getElementById("name").value="";
		
		//AJAX 요청과 응답 처리
		/*
		//GET 방식으로 요청하여 값을 전달할 경우 모든 전달값을 부호화 처리
		id=encodeURIComponent(id);
		name=encodeURIComponent(name);
		var param="id="+id+"&name="+name;
		sendRequest("GET", "module_two.jsp", param, viewMessage);
		*/
		
		var param="id="+id+"&name="+name;
		sendRequest("POST", "module_two.jsp", param, viewMessage);
	}
	
	function viewMessage() {
		if(xhr.readyState==4) {
			if(xhr.status==200) {
				document.getElementById("display").innerHTML=xhr.responseText;
			} else {
				document.getElementById("display").innerHTML="에러코드 = "+xhr.status;
			}
		}
	}
	</script>
</body>
</html>










