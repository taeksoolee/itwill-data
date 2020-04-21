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
	<h1>call 함수</h1>
	<hr>
	<div id="log"></div>
	
	<script type="text/javascript">
	var member={"id":"abc","name":"홍길동","display":function() {
		log("아이디 = "+this.id+", 이름 = "+this.name);
	}};
	
	//자바스크립트 객체를 이용하여 메소드 호출
	// => 메소드에 자바스크립트 객체가 전달되어 this 변수에 자동 저장 
	member.display();
	
	//call() 함수 : 자바스크립트 객체의 메소드를 호출하는 함수
	// => 메소드의 this 변수에 저장된 객체를 call 함수의 매개변수로 전달될 객체로 일시적 변경
	// => call 함수의 매개변수에 전달될 객체로 Object 객체({}) 사용
	// => apply 함수는 this 변수에 저장될 객체로  Array 객체([]) 사용
	member.display.call({"id":"xyz","name":"임꺽정"});
	</script>
</body>
</html>