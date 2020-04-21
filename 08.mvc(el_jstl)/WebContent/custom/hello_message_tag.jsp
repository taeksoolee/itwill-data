<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="simple" uri="http://www.itwill.site/mvc/simple" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MVC</title>
</head>
<body>
	<h1>Custom Tag - Attribute and NoBody</h1>
	<hr>
	<%-- 커스텀 태그의 속성이 생략된 경우 태그 클래스의 생성자에서 설정된
	초기값이 속성값으로 자동 설정 --%>
	<%-- <simple:helloMessage/> --%>
	<%-- 태그 속성값에 대한 필드의 Setter 메소드가 없는 경우 에러 발생 --%>
	<simple:helloMessage name="홍길동"/>
	
	<%-- 태그 속성값을 전달받아 필드의 Setter 메소드를 호출하여 필드값 변경 --%>
	<simple:helloMessage name="임꺽정"/>
</body>
</html>




