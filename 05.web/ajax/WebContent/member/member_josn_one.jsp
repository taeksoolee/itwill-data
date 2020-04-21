<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>AJAX</title>
<script type="text/javascript" src="../js/log.js"></script>
<script type="text/javascript" src="../js/ajax.js"></script>
</head>
<body>
	<h1>회원목록</h1>
	<hr>
	<div id="log"></div>
	
	<script type="text/javascript">
	new site.itwill.Ajax("GET", "member_json_two.jsp", null, function(req) {
		if(req.readyState==4) {
			if(req.status==200) {
				//응답결과(JSON 형식의 텍스트 데이타)를 자바스트립트 객체로 변환하여 저장
				var result=JSON.parse(req.responseText); 
				
				if(result.code=="success") {
					var memberList=result.data;
					//log("검색된 회원수 = "+memberList.length);
					
					for(var i=0;i<memberList.length;i++) {
						var id=memberList[i].id;
						var name=memberList[i].name;
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



