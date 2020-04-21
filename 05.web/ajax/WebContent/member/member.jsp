<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>AJAX</title>
<script type="text/javascript" src="../js/log.js"></script>
</head>
<body>
	<h1>자바스크립트 객체</h1>
	<hr>
	<div id="log"></div>
	
	<script type="text/javascript">
	/*
	document.getElementById("log").innerHTML+="메세지 출력-1<br>";
	document.getElementById("log").innerHTML+="메세지 출력-2<br>";
	*/
	
	/*
	function log(message) {
		var logElement=document.getElementById("log");
		if(logElement!=null) {
			logElement.innerHTML+=message+"<br>";
		}
	}
	*/
	
	//log("메세지 출력-1");
	//log("메세지 출력-2");
	
	/*
	var member=new Object();//var member={};
	
	member.id="abc";//속성 추가
	member.name="홍길동";
	
	log("아이디 = "+member.id+", 이름 = "+member.name);
	
	member.display=function() {//메소드 추가
		log("아이디 = "+this.id+", 이름 = "+this.name);
	}
	
	member.display();
	*/
	
	/*
	var member={"id":"abd","name":"홍길동","display":function(){
		log("아이디 = "+this.id+", 이름 = "+this.name);
	}};
	
	log("아이디 = "+member.id+", 이름 = "+member.name);
	member.display();
	*/
	
	//생성자 함수 - 객체를 만들기 위한 함수
	function Member(id, name) {
		this.id=id;
		this.name=name;
	}
	
	Member.prototype.display=function() {
		log("아이디 = "+this.id+", 이름 = "+this.name);
	}
	
	var member=new Member("abc", "홍길동");
	log("아이디 = "+member.id+", 이름 = "+member.name);
	member.display();
	</script>
</body>
</html>








