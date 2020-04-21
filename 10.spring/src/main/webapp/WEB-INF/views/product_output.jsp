<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Spring</title>
</head>
<body>
	<h1>제품정보</h1>
	<hr>
	<%-- 
	<ul>
		<li>제품코드 = ${product.code }</li>
		<li>제품이름 = ${product.name }</li>
		<li>제품수량 = ${product.qty }</li>
	</ul>
	--%>
	<c:forEach var="product" items="${collection.productList }">
	<ul>
		<li>제품코드 = ${product.code }</li>
		<li>제품이름 = ${product.name }</li>
		<li>제품수량 = ${product.qty }</li>
	</ul>
	</c:forEach>
</body>
</html>
