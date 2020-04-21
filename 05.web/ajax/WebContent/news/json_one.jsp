<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- json_two.jsp 문서를 요청하여 뉴스 목록을 JSON 형식의 텍스트로 제공받아 
클라이언트에게 전달하는 JSP 문서 --%>
<%-- JSON : 자바스트립트 객체 표기법을 이용하여 값과 정보를 구분하는 구조적인 데이타 표현 방식 --%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>AJAX</title>
<script type="text/javascript" src="../js/xhr.js"></script>
<style type="text/css">
#news {
	width: 50%;
	margin: 0 auto;
}

#newsHead {
	padding: 5px;
	text-align: center;
	font-size: x-large;
	border: 2px solid black;
}

#newsList {
	padding: 5px;
	font-size: medium;
	border: 2px dashed black;
	display: none;
}
</style>
</head>
<body>
	<h1>헤드라인 뉴스(JSON)</h1>
	<hr>
	<div id="news">
		<div id="newsHead">헤드라인 뉴스</div>
		<div id="newsList">
			<%--
			<ol>
				<li>뉴스제목-1[언론사-1]</li>
				<li>뉴스제목-2[언론사-2]</li>
				<li>뉴스제목-3[언론사-3]</li>
				<li>뉴스제목-4[언론사-4]</li>
				<li>뉴스제목-5[언론사-5]</li>
			</ol>
			--%>
		</div>
	</div>
	
	<script type="text/javascript">
	document.getElementById("news").onmouseover=function() {
		sendRequest("GET", "json_two.jsp", null, displayNewsList);
		document.getElementById("newsList").style.display="block";
	}	
	
	document.getElementById("news").onmouseout=function() {
		document.getElementById("newsList").style.display="none";
	}
	
	function displayNewsList() {
		if(xhr.readyState==4) {
			if(xhr.status==200) {
				var jsonText=xhr.responseText;
				//alert(jsonText);
				
				//응답받은 JSON 텍스트 데이타를 자바스트립트 객체로 변환
				//1.eval(text) : 문자형 데이타를 자바스트립트 명령으로 변환하는 함수
				//var newsArray=eval("("+jsonText+")");
				//2.JSON.parse(text) : JSON 텍스트 데이타를 자바스트립트 객체로 변환하는 함수
				var newsArray=JSON.parse(jsonText);
				//alert(newsArray.length);
				
				var html="<ol>";
				for(i=0;i<newsArray.length;i++) {
					var headline=newsArray[i].headline;
					var publisher=newsArray[i].publisher;
					html+="<li>"+headline+"["+publisher+"]</li>";
				}
				html+="</ol>";
				
				document.getElementById("newsList").innerHTML=html;
 			} else {
				document.getElementById("newsList").innerHTML="에러코드 = "+xhr.status;
			}
		}
	}
	</script>
</body>
</html>