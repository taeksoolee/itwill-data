<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Spring</title>
</head>
<body>
	<h1>출력페이지</h1>
	<hr>
	<p>제목 : ${subject }</p>
	<p>내용 : <br>${content }</p>
	<%-- 
	<p>제목 : <c:out value="${subject }"/> </p>
	<p>내용 : <br>${fn:escapeXml(content) }</p>	
	--%>
</body>
</html>