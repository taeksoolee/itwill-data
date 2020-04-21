<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>AJAX</title>
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
	<h1>Ajax</h1>
	<hr>
	<div id="display">Hello. Ajax!!!</div>
	<div>
		<button type="button" id="btn">번역하기</button>
	</div>
	<div>
		<a href="https://www.daum.net">다음</a>
	</div>
	
	<script type="text/javascript">
	//XMLHttpRequest 객체를 저장하기 위한 전역변수 선언
	//XMLHttpRequest 객체 : 웹어플리케이션의 비동기식 요청과 응답 결과를 
	//제공받아 처리하기 위한 객체 
	var xhr=null;
	
	//XMLHttpRequest 객체를 생성하여 반환하는 함수 선언
	// => 브라우저 종류와 버전에 따라 XMLHttpRequest 객체를 생성하거나 사용하는 방법이 다양하므로 함수로 선언
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
	
	document.getElementById("btn").onclick=function() {
		//DHTML 기능을 이용한 페이지 요소 변경
		// => 현재 웹어플리케이션의 결과값을 이용하여 요소 변경
		//document.getElementById("display").innerHTML="안녕하세요. 에이젝스!!!";
		
		//AJAX + DHTML 기능을 이용한 페이지 요소 변경
		// => 웹어플리케이션을 비동기식으로 요청(실행)하여 응답받은 결과값으로 요소 변경
		//1.XMLHttpRequest 객체를 생성하여 저장 - 전역변수와 함수 사용
		xhr=getXMLHttpRequest();
		
		//2.XMLHttpRequest 객체의 준비상태(readyState)가 변경될 경우 호출될 이벤트 핸들러 함수 등록
		//XMLHttpRequest.readyState : XMLHttpRequest 객체의 상태정보를 저장하는 속성
		// => XMLHttpRequest 객체의 준비상태는 순차적으로 변경
		// => 0(기본),1(요청 초기화:open),2(요청:send),3(응답대기:실행중),4(응답완료:결과)
		//XMLHttpRequest.onreadystatechange : XMLHttpRequest 객체의 준비상태가 
		//변경될 경우 호출될 이벤트 핸들러 함수를 등록하는 속성
		xhr.onreadystatechange=changeHTML;
		
		//3.XMLHttpRequest 객체의 open() 메소드 호출 - 준비상태가 [1]로 변경
		//XMLHttpRequest.open(method, url[, async]) : 웹어플리케이션 요청에 필요한 정보를 설정하는 메소드
		// => method : 요청방식 - GET, POST, PUT, PATCH, DELETE 등
		// => url : 요청 어플리케이션의 URL 주소 - 현재 서버의 웹어플리케이션만 요청 가능
		// => async : 비동기식 요청 구분 - false(동기식 요청), true(비동기식 요청 : 기본)
		//xhr.open("GET", "hello_two.jsp", false);
		xhr.open("GET", "hello_two.jsp", true);
		
		//4.XMLHttpRequest 객체의 send() 메소드 호출 - 준비상태가 [2]로 변경
		//XMLHttpRequest.send(data) : 웹어플리케이션을 요청하는 메소드
		// => data : 요청할 웹어플리케이션에게 전달할 값을 QueryString 형태로 제공
		// => POST 방식으로 요청할 경우에만 매개변수에 전달값을 제공하여 호출
		// => GET 방식으로 요청할 경우 또는 전달값이 없는 경우 매개변수에 null을 제공하여 호출
		xhr.send(null);
	}
	
	//XMLHttpRequest 객체의 준비상태가 변경될 경우 호출되는 이벤트 핸들러 함수
	// => 요청에 대한 응답 결과를 제공받아 처리하는 함수 - 준비상태가 [4]인 경우에만 명령 실행
	function changeHTML() {
		/*
		if(xhr.readyState==1) {
			alert("요청 초기화 상태");
		} else if(xhr.readyState==2) {
			alert("요청 상태");
		} else if(xhr.readyState==3) {
			alert("응답 대기 상태");
		} else if(xhr.readyState==4) {
			alert("응답 완료 상태");
		}*/
		
		//5.응답결과를 제공받아 DOM 조작(DHTML)
		if(xhr.readyState==4) {
			//XMLHttpRequest.status : 요청에 대한 응답코드를 저장하는 속성
			if(xhr.status==200) {//정상적인 실행 결과가 제공된 경우
				//XMLHttpRequest.responseText : 응답결과(NonXML)를 저장하는 속성
				//XMLHttpRequest.responseXML : 응답결과(XML)를 저장하는 속성
				var result=xhr.responseText;
				document.getElementById("display").innerHTML=result;
			} else {//실행 결과로 에러코드가 전달된 경우
				alert("에러코드 = "+xhr.status);
			}
		} else {
			document.getElementById("display").innerHTML="<img src='images/loading.gif' width='50'>"
		}
	}
	</script>
</body>
</html>
