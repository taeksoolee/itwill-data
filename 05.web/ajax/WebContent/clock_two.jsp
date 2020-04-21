<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//요청에 대한 실행결과를 브라우저 캐싱 기능이 사용하지 못하도록 설정
	//request.getProtocol() : 프로토콜을 반환하는 메소드
	String protocol=request.getProtocol();
	
	if(protocol.equals("HTTP/1.0")) {
		response.setDateHeader("Expries", -1);
		response.setHeader("pragma", "no-cache");
	} else if(protocol.equals("HTTP/1.1")) {
		response.setHeader("Cache-control", "no-cache");
	} 

	Date now=new Date();
	SimpleDateFormat sdf=new SimpleDateFormat("yyyy년 MM월 dd일 HH시 mm분 ss초");
	String displayTime=sdf.format(now);
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>AJAX</title>
</head>
<body>
<%=displayTime %>
</body>
</html>