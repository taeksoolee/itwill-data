<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- book.jsp 문서를 AJAX 요청하여 결과를 XML 텍스트 데이타로 제공받아
클라이언트에게 전달하는 JSP 문서 --%>    
<%-- => book.xsl 문서를 이용하여 XML 텍스트 데이타를 HTML로 변환 --%>
<%-- => xhr.js 모듈 사용 : 전역변수와 함수를 사용하여 AJAX 기능 제공 --%>

<%-- XSLT 문서를 이용한 XML 텍스트 데이타 파싱 방법 --%>
<%-- 1.XSL 문서와 JSP 문서를 AJAX 기능으로 요청하여 두 문서의 응답결과를 반환받아 저장 --%>
<%-- 2.XSL 문서의 응답결과(XSLT)를 이용하여 JSP 문서의 응답결과(XML)를 변환(HTML)하여 저장 --%>
<%-- 3.변환된 결과를 이용하여 페이지 조작 - DHTML --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>AJAX</title>
<script type="text/javascript" src="../js/xhr.js"></script>
</head>
<body>
	<h1>교재목록</h1>
	<hr>
	<div id="bookList"></div>
	
	<script type="text/javascript">
	/*
	sendRequest("GET", "book.jsp", null, function() {
		if(xhr.readyState==4) {
			if(xhr.status==200) {
				//응답결과를 제공받아 저장 : XMLDocument 객체
				var xmlDoc=xhr.responseXML;
			
				//DOM 기능을 이용하여 XML 결과값을 HTML로 변환
				var bookList=xmlDoc.getElementsByTagName("book");
				var html="<ol>";
				for(var i=0;i<bookList.length;i++) {
					var book=bookList.item(i);
					var title=book.getElementsByTagName("title").item(0).firstChild.nodeValue;
					var author=book.getElementsByTagName("author").item(0).firstChild.nodeValue;
					html+="<li><b>"+title+"</b>["+author+"]</li>";
				} 
				html+="</ol>";
				
				//DHTML를 이용하나 태그 변경
				document.getElementById("bookList").innerHTML=html;
			} else {
				alert("에러코드 = "+xhr.status);
			}
		}
	});
	*/
	
	var xmlDoc=null;//JSP 문서의 응답결과를 저장하기 위한 변수
	var xslDoc=null;//XSL 문서의 응답결과를 저장하기 위한 변수
	
	//book.jsp 문서를 요청하여 응답 처리하는 함수 호출
	loadBookXML();
	//book.xsl 문서를 요청하여 응답 처리하는 함수 호출
	//문제점 : xhr 전역변수에 저장된 하나의 XMLHttpRequest 객체를 이용하여
	//여러 개의 문서를 요청하여 응답 결과의 처리 불가능
	//해결방법-1 : 문서를 동기식으로 요청하여 응답결과를 받아 처리하기 전까지 다른 명령이 실행되지 않도록 구현
	//해결방법-2 : 문서를 요청할 때마다 새로운 XMLHttpRequest 객체를 이용하여 응답결과 처리 
	//loadBookXSL();
	
	//book.jsp 문서를 요청하여 응답결과를 처리하는 함수
	// => 응답결과를 제공받아 저장한 후 book.xsl 문서 요청
	function loadBookXML() {
		sendRequest("GET", "book.jsp", null, function() {
			if(xhr.readyState==4) {
				if(xhr.status==200) {
					xmlDoc=xhr.responseXML;
					loadBookXSL();
				} else {
					alert("에러코드 = "+xhr.status);
				}
			}
		});
	}
	
	//book.xsl 문서를 요청하여 응답결과를 처리하는 함수 
	function loadBookXSL() {
		sendRequest("GET", "book.xsl", null, function() {
			if(xhr.readyState==4) {
				if(xhr.status==200) {
					xslDoc=xhr.responseXML;
					doXSLT();
				} else {
					alert("에러코드 = "+xhr.status);
				}
			}
		});
	}
	
	//XSL 문서의 응답결과(XSLT)를 이용하여 JSP 문서의 응답결과(XML)를 변환하는 함수
	function doXSLT() {
		var bookList=document.getElementById("bookList");
		
		if(window.activeXObject) {//IE4~IE6
			bookList.innerHTML=xmlDoc.transformNode(xslDoc);
		} else {//IE7 이상 또는 기타 브라우저
			//XSLTProcessor 객체(XSLT 변환 객체)를 생성
			var xsltProcessor=new XSLTProcessor();
		
			//XSLTProcessor.importStylesheet(xslt) : XSLTProcessor 객체의
			//변환정보(XSLT)를 변경하는 메소드
			xsltProcessor.importStylesheet(xslDoc);
			
			//XSLTProcessor.transformToFragment(xml, document) : XSLTProcessor 
			//객체의 변환정보를 이용하여 데이타(XML)를 변환하여 반환하는 메소드
			var fragment=xsltProcessor.transformToFragment(xmlDoc, document);
			
			//반환받은 객체를 원하는 엘리먼트의 자식 엘리먼트로 추가
			bookList.appendChild(fragment);
		}
	}
	</script>
</body>
</html>








