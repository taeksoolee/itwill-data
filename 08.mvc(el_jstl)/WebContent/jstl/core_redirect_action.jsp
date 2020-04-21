<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- 인코딩 필터를 사용한 경우 생략 가능 --%>    
<%-- request.setCharacterEncoding("UTF-8"); --%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MVC</title>
</head>
<body>
	<h1>Core - URL 관리</h1>
	<hr>
	<c:choose>
		<c:when test="${!empty(param.name) }">	
			<p>${param.name }님 환영합니다.</p>
		</c:when>
		<c:otherwise>
			<c:set var="message" value="이름을 반드시 입력해 주세요." scope="session"/>
			<%-- redirect 태그 : 다른 페이지를 요청하도록 클라
			이언트에게 URL 주소를 전달하는 태그 --%>
			<%-- url 속성 : 요청 페이지에 대한 URL 주소를 속성값으로 설정 --%>
			<c:redirect url="core_redirect_form.jsp"/>	
		</c:otherwise>
	</c:choose>
</body>
</html>
