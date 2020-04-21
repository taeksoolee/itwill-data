<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- csv_two.jsp 문서를 요청하여 뉴스 목록을 CSV 형식의 텍스트로 제공받아 
클라이언트에게 전달하는 JSP 문서 --%>
<%-- CSV : 특정 문자를 이용하여 값과 정보를 구분하는 비구조적인 데이타 표현 방식 --%>    
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
	<h1>헤드라인 뉴스(CSV)</h1>
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
		sendRequest("GET", "csv_two.jsp", null, displayNewsList);
		document.getElementById("newsList").style.display="block";
	}	
	
	document.getElementById("news").onmouseout=function() {
		document.getElementById("newsList").style.display="none";
	}
	
	function displayNewsList() {
		if(xhr.readyState==4) {
			if(xhr.status==200) {
				var csv=xhr.responseText;
				//alert(csv);
				
				//응답결과(CSV)를 HTML로 변환하여 요소(Element 객체) 변경
				var newsArray=csv.split("*");
				//alert(newsArray.length);
						
				var html="<ol>";
				for(i=0;i<newsArray.length;i++) {
					var news=newsArray[i].split("|");
					var headline=news[0];
					var publisher=news[1];
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
