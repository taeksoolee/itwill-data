<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MVC</title>
</head>
<body>
	<h1>Core - 흐름 제어 태그</h1>
	<hr>
	<%-- if 태그 : 조건에 따라 태그 내용의 출력 유무를 선택하는 태그 --%>
	<%-- => else 기능 미존재 --%>
	<%-- test 속성 : 속성값이 false인 경우 태그내용 미출력, true인 경우 태그 내용 --%>
	<c:if test="true">
		<p>test 속성값이 true인 경우 출력될 내용-1</p>
	</c:if>
	
	<c:set var="sw" value="false"/>
	<c:if test="${sw}">
		<p>test 속성값이 true인 경우 출력될 내용-2</p>
	</c:if>	
	<hr>
	<c:set var="num" value="11"/>
	<%-- 
	<c:if test="${num%2==0}">${num } = 짝수</c:if>
	<c:if test="${num%2!=0}">${num } = 홀수</c:if>
	--%>
	<c:if test="${num mod 2 eq 0}">${num } = 짝수</c:if>
	<c:if test="${num mod 2 ne 0}">${num } = 홀수</c:if>
	<hr>
	<c:set var="score" value="185"/>
	<%-- 
	<c:if test="${score<=100 && score>=0}">
		<p>${score}점은 정상적인 점수입니다.</p>
	</c:if>
	<c:if test="${score>100 || score<0}">
		<p>${score}점은 비정상적인 점수입니다.</p>
	</c:if>
	--%>
	<c:if test="${score le 100 and score ge 0}">
		<p>${score}점은 정상적인 점수입니다.</p>
	</c:if>
	<c:if test="${score gt 100 or score lt 0}">
		<p>${score}점은 비정상적인 점수입니다.</p>
	</c:if>
	<hr>
	<c:if test="${empty(name) }">
		<p>name 속성명으로 저장된 인스턴스가 존재하지 않습니다.</p>
	</c:if>
	
	<c:set var="name" value="홍길동"/>
	<c:if test="${!empty(name) }">
		<p>name 속성명으로 저장된 인스턴스값은 [${name }]입니다.</p>
	</c:if>
</body>
</html>







