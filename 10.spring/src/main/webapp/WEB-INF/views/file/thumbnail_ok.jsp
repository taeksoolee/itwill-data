<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Spring</title>
</head>
<body>
	<h1>이미지 파일 업로드 성공</h1>
	<hr>
	<p>업로드 파일명 = ${imageFilename }</p>
	<p>썸네일 파일명 = ${thumbnailFilename }</p>
	<hr>
	<img src="${pageContext.request.contextPath }/upload/${imageFilename}" width="400">
	<img src="${pageContext.request.contextPath }/upload/${thumbnailFilename}">
</body>
</html>






