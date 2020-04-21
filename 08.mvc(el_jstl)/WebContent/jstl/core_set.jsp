<%@page import="site.itwill.el.Student"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- taglib Directive를 이용하여 JSTL의 태그 라이브러리를 포함하여 태그 사용 --%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MVC</title>
</head>
<body>
	<h1>Core - EL 지원 태그</h1>
	<hr>
	<%-- set 태그 : 객체속성으로 인스턴스를 저장하기 위한 태그 --%>
	<%-- var 속성 : 저장 인스턴스의 속성명을 속성값으로 설정 --%>
	<%-- value 속성 : 저장 인스턴스를 속성값으로 설정 --%>
	<%-- scope 속성 : 저장 인스턴스의 사용범위을 속성값으로 설정 --%>
	<%-- => 속성값 : page(기본), request, session, application --%>
	<c:set var="su" value="10" scope="page"/>
	<p>su = ${su }</p>
	
	<%-- 저장 인스턴스의 속성명이 같은 경우 저장 인스턴스 변경 --%>
	<%-- value 속성 대신 태그 내용으로 저장 인스턴스 설정 가능 --%>
	<c:set var="su">20</c:set>
	<p>su = ${su }</p>
	
	<%-- 속성값으로 EL 사용 가능 --%>
	<c:set var="tot" value="${su+10}"/>
	<p>tot = ${tot }</p>
	
	<c:set var="name" value="홍길동"/>
	<p>name = ${name }</p>
	
	<%-- <c:set var="now" value="<%=new Date() %>"/> --%>
	<%-- EL 표현식에서 메소드 호출 가능 --%>
	<c:set var="now" value="${Class.forName('java.util.Date').newInstance() }"/>
	<p>now = ${now }</p>
	<%-- <p>now.getTime() = ${now.getTime() }</p> --%>
	<p>now.time = ${now.time }</p>
	
	<c:set var="student" value="<%=new Student() %>"/>
	<p>student = ${student }</p>
	<p>학번 = ${student.num}, 이름 = ${student.name }</p>
	
	<%-- set 태그를 이용하여 저장 인스턴스 필드값 변경 가능 --%>
	<%-- target 속성 : 저장 인스턴스를 속성값으로 설정 --%>
	<%-- property 속성 : 필드명을 속성값으로 설정 - Setter 메소드를 호출하여 필드값 변경 --%>
	<c:set target="${student }" property="num" value="1000"/>
	<c:set target="${student }" property="name" value="홍길동"/>
	<p>학번 = ${student.num}, 이름 = ${student.name }</p>
	
	<%-- remove 태그 : 객체속성으로 저장된 인스턴스를 제거하는 태그 --%>
	<c:remove var="student"/>
	<p>student = ${student }</p>
</body>
</html>











