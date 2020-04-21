<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 메인 페이지 --%> 

<%--    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP</title>
<!-- 
<style type="text/css">
div {
	margin: 5px;
	padding: 5px;
}

#header {
	height: 140px;
	border: 1px solid red;
}

#header h1 {
	text-align: center;
}

#menu {
	text-align: right;
}

a, a:visited {
	text-decoration: none;
	color: black;
}

a:hover {
	color: orange;
}

#content {
	min-height: 300px;
	border: 1px solid green;
	text-align: center;
}

#footer {
	height: 100px;
	border: 1px solid blue;
	text-align: center;
}
</style>
-->
<link href="style.css" rel="stylesheet" type="text/css"> 
</head>
<body>
	<!-- header 영역 : 로고, 메뉴, 이미지 슬라이드 등 -->
	<div id="header">
		<h1><a href="index.jsp">쇼핑몰</a></h1>
		<div id="menu">
			<a href="product.jsp">제품소개</a>&nbsp;&nbsp;
			<a href="cart.jsp">장바구니</a>&nbsp;&nbsp;
			<a href="order.jsp">주문내역</a>&nbsp;&nbsp;
			<a href="review.jsp">사용후기</a>&nbsp;&nbsp;
		</div>
	</div>
--%>
<%-- web.xml 파일에서 JSP 문서의 앞 또는 뒤부분에 포함될 파일을 설정 가능 --%>
<%-- <%@include file="header.jspf" %> --%>	
	
	<!-- content 영역 : 요청에 대한 처리 결과를 출력하는 영역 -->
	<div id="content">
		<h2>메인 페이지</h2>
	</div>

<%-- 	
	<!-- footer 영역 : 저작권, 약관, 개인정보 보호정책 등 -->
	<div id="footer">
		<p>Copyright ⓒ itwill Corp. All rights reserved</p>
	</div>
</body>
</html>
--%>
<%-- <%@include file="footer.jspf" %> --%>	






