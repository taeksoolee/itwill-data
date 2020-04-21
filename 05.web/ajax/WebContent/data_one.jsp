<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ajax</title>
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
	<h1>전달값</h1>
	<hr>
	<div id="display">요청 어플리케이션의 응답결과 출력</div>
	<div>
		이름 : <input type="text" id="name">
		<button type="button" id="getBtn">GET</button>
		<button type="button" id="postBtn">POST</button>
	</div>
	
	<script type="text/javascript">
	var xhr=null;
	
	function getXMLHttpRequest() {
		if(window.ActiveXObject) {//IE4 ~ IE6
			try {
				return new ActiveXObject("msxml2.XMLHTTP");//IE5 ~ IE6
			} catch (e) {
				try {
					return new ActiveXObject("MicrosoftXMLHTTP");//IE4
				} catch (e) {
					return null;
				}
			}
		} else if(window.XMLHttpRequest) {//IE7 이상 또는 기타 브라우저
			return new XMLHttpRequest();
		} else {
			return null;
		}
	}
	
	//GET 방식의 요청에 의한 입력값 전달
	document.getElementById("getBtn").onclick=function() {
		//입력태그의 입력값을 반환받아 저장
		var name=document.getElementById("name").value;
		
		//입력값 검증
		if(name=="") {
			document.getElementById("display").innerHTML="이름을 입력해 주세요.";
			return;
		}
		
		//입력태그 초기화
		document.getElementById("name").value="";
		
		xhr=getXMLHttpRequest();
		xhr.onreadystatechange=viewMessage;
		//GET 방식으로 요청할 경우 요청 URL 주소의 QueryString을 사용하여 값 전달
		// => 전달값이 URL 주소로 표현되지 못하는 경우 부호화 변환하여 전달
		name=encodeURIComponent(name);
		xhr.open("GET", "data_two.jsp?name="+name);
		xhr.send(null);
	}
	
	//POST 방식의 요청에 의한 입력값 전달
	document.getElementById("postBtn").onclick=function() {
		var name=document.getElementById("name").value;

		if(name=="") {
			document.getElementById("display").innerHTML="이름을 입력해 주세요.";
			return;
		}
		
		document.getElementById("name").value="";
		
		xhr=getXMLHttpRequest();
		xhr.onreadystatechange=viewMessage;
		xhr.open("POST", "data_two.jsp");
		//POST 방식으로 요청하는 경우 send() 메소드의 매개변수에 전달값을 
		//QueryString 형식으로 표현하여 전달
		//문제)send() 메소드를 이용하여 값을 전달할 경우 "multipart/form-data" 형식으로 전달
		// => request.getParameter() 메소드로 전달받 반환 불가능
		//해결)"application/x-www-form-urlencoded" 형식으로 값이 전달되도록 RequestHeader 변경
		//XMLHttpRequest.setRequestHeader(header, value) : 요청의 헤더정보를 변경하는 메소드
		xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
		xhr.send("name="+name);
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







