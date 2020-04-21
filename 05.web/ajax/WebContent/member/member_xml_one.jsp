<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>AJAX</title>
<script type="text/javascript" src="../js/log.js"></script>
<script type="text/javascript" src="../js/xhr.js"></script>
<script type="text/javascript" src="../js/ajax.js"></script>
</head>
<body>
	<h1>회원목록</h1>
	<hr>
	<div id="log"></div>
	
	<script type="text/javascript">
	/*
	//xhr.js 파일에 선언된 전역변수와 함수를 이용하여 AJAX 기능 구현
	sendRequest("GET", "member_xml_two.jsp", null, function() {
		if(xhr.readyState==4) {
			if(xhr.status==200) {
				var xmlDoc=xhr.responseXML;
				
				var code=xmlDoc.getElementsByTagName("code").item(0).firstChild.nodeValue;
				//log("code = "+code);
				
				if(code=="success") {
					var memberList=xmlDoc.getElementsByTagName("member");
					//log("검색된 회원수 = "+memberList.length);
					
					for(var i=0;i<memberList.length;i++) {
						var member=memberList.item(i);
						var id=member.getElementsByTagName("id").item(0).firstChild.nodeValue;
						var name=member.getElementsByTagName("name").item(0).firstChild.nodeValue;
						log("아이디 = "+id+", 이름 = "+name);
					}
				} else {
					log("검색된 회원정보가 존재하지 않습니다.");
				}
			} else {
				log("에러코드 = "+xhr.status);
			}
		}
	});
	*/
	
	//ajax.js 파일에 선언된 객체(속성과 메소드)를 이용하여 AJAX 기능 구현
	new site.itwill.Ajax("GET", "member_xml_two.jsp", null, function(req) {
		if(req.readyState==4) {
			if(req.status==200) {
				var xmlDoc=req.responseXML;
				
				var code=xmlDoc.getElementsByTagName("code").item(0).firstChild.nodeValue;
				
				if(code=="success") {
					var memberList=xmlDoc.getElementsByTagName("member");
					
					for(var i=0;i<memberList.length;i++) {
						var member=memberList.item(i);
						var id=member.getElementsByTagName("id").item(0).firstChild.nodeValue;
						var name=member.getElementsByTagName("name").item(0).firstChild.nodeValue;
						log("아이디 = "+id+", 이름 = "+name);
					}
				} else {
					log("검색된 회원정보가 존재하지 않습니다.");
				}
			} else {
				log("에러코드 = "+req.status);
			}
		}
	});
	</script>
</body>
</html>