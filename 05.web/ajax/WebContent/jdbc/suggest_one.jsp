<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 키워드를 입력받아 키워드가 포함된 제시어를 클라이언트에게 전달하는 JSP 문서 --%>
<%-- => 키워드가 포함된 제시어 관련 정보를 suggest_two.jsp 문서에게 요청하여 XML 텍스트 데이타로 응답받아 처리 --%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>AJAX</title>
<script type="text/javascript" src="../js/ajax.js"></script>
<style type="text/css">
#keyword {
	position: absolute;
	top: 100px;
	left: 10px;
	width: 300px;
	font-size: 16px;
}

#suggest {
	position: absolute;
	top: 125px;
	left: 10px;
	width: 300px;
	border: 1px solid black;
	cursor: pointer;
	font-size: 16px;
	z-index: 999;
	background-color: rega(255,255,255,1);
	display: none;
}

#choice {
	position: absolute;
	top: 130px;
	left: 10px;
}

a, a:visited {
	color: black;
	text-decoration: none;
}

#suggest a:hover {
	color: red;
}

#choice a:hover {
	color: blue;
	text-decoration: underline;
}
</style>
</head>
<body>
	<h1>제시어 기능 - JDBC</h1>
	<hr>
	<div>
		<%-- 키워드를 입력받기 위한 태그 --%>
		<input type="text" id="keyword">
		
		<%-- 제시어를 제공받아 출력하기 위한 태그 --%>
		<div id="suggest">
			<div id="suggestList"></div>
		</div>
		
		<%-- 선택된 제시어 관련 정보를 출력하기 위한 태그 --%>
		<div id="choice"></div>
	</div>
	
	<script type="text/javascript">
	document.getElementById("keyword").focus();
	
	//키워드 입력태그에서 키보드 이벤트가 발생된 경우 호출되는 이벤트 핸들러 함수 등록
	document.getElementById("keyword").onkeyup=function() {
		var keyword=document.getElementById("keyword").value;
		
		//키워드가 존재하지 않을 경우 제시어 출력 영역 미배치
		if(keyword=="") {
			document.getElementById("suggest").style.display="none";
			return;
		}
		
		//요청 문서(suggest_two.jsp)에 전달할 변수와 값 설정
		var param="keyword="+keyword;
		
		//AJAX 기능을 이용한 문서 요청
		new site.itwill.Ajax("POST", "suggest_two.jsp", param, displaySuggest);
	}
	
	//요청 문서의 응답결과를 제공받아 처리하는 함수
	function displaySuggest(req) {
		if(req.readyState==4) {
			if(req.status==200) {
				var xmlDoc=req.responseXML;
				
				var code=xmlDoc.getElementsByTagName("code").item(0).firstChild.nodeValue;
				if(code=="success") {//검색된 제시어 정보가 있는 경우
					var data=xmlDoc.getElementsByTagName("data").item(0).firstChild.nodeValue;
					var suggestArray=JSON.parse(data);
					//alert("검색 제시어 갯수 = "+suggestArray.length);
					
					var html="";
					for(var i=0;i<suggestArray.length;i++) {
						html+="<a href=\"javascript:selectSuggest('"
							+suggestArray[i].word+"','"
							+suggestArray[i].address+"');\">"
							+suggestArray[i].word+"</a><br>";
					}
					
					document.getElementById("suggestList").innerHTML=html;
					document.getElementById("suggest").style.display="block";
				} else {//검색된 제시어 정보가 없는 경우
					document.getElementById("suggest").style.display="none";
				}
			} else {
				alert("에러코드 = "+req.status);
			} 			
		} 
	}
	
	//선택된 제시어 관련 정보를 출력하는 함수
	// => 제시어를 클릭한 경우 링크 URL 주소로 이동
	function selectSuggest(word, address) {
		//alert(word+", "+address);
		document.getElementById("keyword").value=word;
		
		var html="";
		if(address=="null") {
			html+="word";
		} else {
			html+="<a href='"+address+"'>"+word+"</a>";
		}
		
		document.getElementById("choice").innerHTML=html;
		document.getElementById("suggest").style.display="none";
	}
	</script>
</body>
</html>
