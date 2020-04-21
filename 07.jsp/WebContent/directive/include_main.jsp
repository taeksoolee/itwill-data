<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP</title>
</head>
<body>
	<h1>include Directive</h1>
	<hr>
	<p>컨텍스트에 존재한 파일의 코드를 현재 JSP 문서에 포함하는 지시어 - 정적포함</p>
	<hr>
	<%--
	<p>클라이언트 요청에 대한 응답 결과</p>
	<p>클라이언트 요청에 대한 응답 결과</p>
	<p>클라이언트 요청에 대한 응답 결과</p>
	<p>클라이언트 요청에 대한 응답 결과</p>
	<p>클라이언트 요청에 대한 응답 결과</p>
	<p>클라이언트 요청에 대한 응답 결과</p>
	<p>클라이언트 요청에 대한 응답 결과</p>
	<p>클라이언트 요청에 대한 응답 결과</p>
	<p>클라이언트 요청에 대한 응답 결과</p>
	<p>클라이언트 요청에 대한 응답 결과</p>
	--%>
	<%-- 파일을 불러와 파일의 내용을 현재 위치에 포함 --%>
	<%-- => 파일이 존재하지 않을 에러 발생 --%>
	<%@include file="include_sub.jspf" %>
</body>
</html>




