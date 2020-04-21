<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%-- HTML의 meta 태그를 이용하여 브라우저 캐싱 기능 미사용 설정 --%>
<meta http-equiv="Expires" content="-1">
<meta http-equiv="pragma" content="no-cache">
<title>AJAX</title>
<script type="text/javascript" src="js/xhr.js"></script>
<style type="text/css">
div {
	font-size: 20px;
	margin: 10px;
}
</style>
</head>
<body>
	<h1>디지털 시계</h1>
	<hr>
	<div>현재 클라이언트 시스템의 날짜와 시간은 <span id="clientTime">
	2020년 02월 12일 16시 44분 30초</span>입니다.</div>
	<div>현재 서버 시스템의 날짜와 시간은 <span id="serverTime">
	2020년 02월 12일 16시 44분 30초</span>입니다.</div>
	
	<script type="text/javascript">
	//브라우저가 실행되는 시스템의 날짜와 시간을 반환받아 요소를 변경하는 함수
	// => 브라우저가 실행되는 시스템에 따라 다른 결과 제공 
	function displayClientTime() {
		var now=new Date();
		var displayTime=now.getFullYear()+"년 "+(now.getMonth()+1)+"월 "
			+now.getDate()+"일 "+now.getHours()+"시 "
			+now.getMinutes()+"분 "+now.getSeconds()+"초";
		document.getElementById("clientTime").innerHTML=displayTime;
	}
	
	displayClientTime();
	setInterval(displayClientTime, 1000);
	
	//서버 시스템의 날짜와 시간을 반환받아 요소를 변경하는 함수 - AJAX 이용
	// => 서버 시스템의 날짜와 시간을 제공받아 사용하므로 클라이언트에 상관없이 동일한 결과 제공
	//문제점 : 동일한 웹어플리케이션을 요청할 경우 브라우저 캐싱 기능에 의해  
	//서버의 요청 결과가 아닌 기존 요청 결과를 재활용 - 동일한 응답 결과 제공
	//해결방법-1 : QueryString를 이용하여 URL 주소를 지속적으로 변경
	//해결방법-2 : 브라우저 캐싱을 사용하지 않도록 설정 - 디자이너
	//해결방법-3 : 응답 결과를 브라우저 캐싱이 사용하지 않도록 설정 - 개발자
	function displayServerTime() {
		sendRequest("GET", "clock_two.jsp", null, function() {
			if(xhr.readyState==4) {
				if(xhr.status==200) {
					document.getElementById("serverTime").innerHTML=xhr.responseText;
				} else {
					alert("에러코드 = "+xhr.status);
				}
			}
		});
	}

	/*
	function displayServerTime() {
		sendRequest("GET", "clock_two.jsp?dummy="+new Date().getTime(), null, function() {
			if(xhr.readyState==4) {
				if(xhr.status==200) {
					document.getElementById("serverTime").innerHTML=xhr.responseText;
				} else {
					alert("에러코드 = "+xhr.status);
				}
			}
		});
	}
	*/
	
	displayServerTime();
	setInterval(displayServerTime, 1000);
	</script>
</body>
</html>
