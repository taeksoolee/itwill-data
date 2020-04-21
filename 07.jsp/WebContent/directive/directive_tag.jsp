<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP</title>
</head>
<body>
	<h1>지시어 태그(Directive Tag)</h1>
	<hr>
	<p>1.page Directive : JSP 문서 작성에 필요한 정보를 제공하도록 지시
	- &lt;%@page contentType="MimeType" pageEncoding="Encoding" ... %&gt;</p>
	<p>2.include Directive : 외부 파일의 코드를 JSP 문서에 포함하도록 지시
	- &lt;%@include file="외부파일경로" %&gt;</p>
	<p>3.taglib Directive : 태그 라이브러리 파일을 JSP 문서에 포함하도록 지시
	- &lt;%@taglib prefix="네임스페이스" uri="파일고유값" %&gt;</p>
</body>
</html>





