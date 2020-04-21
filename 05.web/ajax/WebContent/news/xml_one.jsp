<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- xml_two.jsp 문서를 요청하여 뉴스 목록을 XML 형식의 텍스트로 제공받아 
클라이언트에게 전달하는 JSP 문서 --%>
<%-- XML : 엘리먼트를 이용하여 값과 정보를 구분하는 구조적인 데이타 표현 방식 --%>    
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
	<h1>헤드라인 뉴스(XML)</h1>
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
		sendRequest("GET", "xml_two.jsp", null, displayNewsList);
		document.getElementById("newsList").style.display="block";
	}	
	
	document.getElementById("news").onmouseout=function() {
		document.getElementById("newsList").style.display="none";
	}
	
	function displayNewsList() {
		if(xhr.readyState==4) {
			if(xhr.status==200) {
				var xmlDoc=xhr.responseXML;
				//alert(xmlDoc);//XMLDocument 객체
				
				/*
				var items=xmlDoc.documentElement;//RootElement 객체를 저장하는 속성
				//alert(items);//Element 객체
				//alert(items.nodeName);//Element 객체의 이름을 저장하는 속성
				//alert(items.nodeValue);//Element 객체의 값을 저장하는 속성
				//alert(items.childNodes);//Element 객체의 자식 엘리먼트(NodeList)을 저장하는 속성
				//alert(items.childNodes.length);
				*/
				
				//Document.getElementsByTagName(tagName) : 태그명을 이용하여 엘리먼트를 검색하는 메소드
				// => HTMLCollection 객체(NodeList) 반환
				var itemList=xmlDoc.getElementsByTagName("item");
				//alert(itemList);//HTMLCollection 객체
				//alert(itemList.length);
				
				var html="<ol>";
				for(i=0;i<itemList.length;i++) {
					var news=itemList.item(i);
					//alert(news);//Element 객체
					
					var headline=news.getElementsByTagName("headline").item(0).firstChild.nodeValue;
					var publisher=news.getElementsByTagName("publisher").item(0).firstChild.nodeValue;
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