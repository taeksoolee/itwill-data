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
	<c:set var="choice" value="4"/>
	<%-- choose 태그 : 태그 내용의 출력 유무를 선택하는 태그 --%>
	<%-- => 자식태그를 이용하여 태그 내용의 출력 선택 : 자식태그외의 명령이 존재할 경우 에러 발생(JSP 주석 제외) --%>
	<%-- => 자식태그 : when 태그(1개 이상), otherwise 태그(0개 또는 1개) --%>
	<c:choose>
		<%-- when 태그 : 조건에 따라 태그 내용의 출력 유무를 선택하는 태그 --%>
		<%-- test 속성 : 속성값이 false인 경우 태그내용 미출력, true인 경우 태그 내용 --%>
		<c:when test="${choice==1}">
			<p>수성으로 이동합니다.</p>
		</c:when>
		<c:when test="${choice==2}">
			<p>화성으로 이동합니다.</p>
		</c:when>
		<c:when test="${choice==3}">
			<p>금성으로 이동합니다.</p>
		</c:when>
		<%-- otherwise 태그 : 모든 when 태그의 test 속성값이 false인 경우 태그내용 출력 --%>
		<c:otherwise>
			<p>지구로 이동합니다.</p>
		</c:otherwise>
	</c:choose>
	
	<c:set var="num" value="11"/>
	<c:choose>
		<c:when test="${num%2==0 }">
			<p>${num } = 짝수</p>
		</c:when>	
		<c:otherwise>
			<p>${num } = 홀수</p>
		</c:otherwise>
	</c:choose>
</body>
</html>













