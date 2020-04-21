<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");

	//입력값(전달값)을 반환받아 저장
	String category=request.getParameter("category");
	if(category==null) category="main";
	
	//Header 영역에 포함될 파일경로를 저장하기 위한 변수
	String headerfilePath="";
	
	//관리자 정보를 저장하기 위한 변수
	String master="";
	
	//입력값(전달값)에 따라 Header 영역에 포함될 파일경로를 다르게 저장
	// => 입력값(전달값)에 따라 관리자 정보를 다르게 저장
	if(category.equals("main")) {
		headerfilePath="header_main.jsp";
		master="홍길동(abc@google.com)";
	} else if(category.equals("blog")) {
		headerfilePath="header_blog.jsp";
		master="임꺽정(xyz@daum.net)";
	} else if(category.equals("cafe")) {
		headerfilePath="header_cafe.jsp";
		master="전우치(top@naver.com)";
	} else {
		response.sendError(HttpServletResponse.SC_BAD_REQUEST);
		return;
	}
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP</title>
</head>
<body>
	<%-- Header 영역 --%>
	<%-- 
	<h1>메인 페이지</h1>
	<a href="include_main.jsp?category=main">메인 페이지</a>&nbsp;&nbsp;
	<a href="include_main.jsp?category=blog">블로그 페이지</a>&nbsp;&nbsp;
	<a href="include_main.jsp?category=cafe">카페 페이지</a>
	<hr>
	--%>
	
	<%-- include Directive : 외부파일(jspf)의 내용 포함 --%>
	<%-- => JSP 문서에 외부파일의 내용을 포함하여 페이지 구현 --%>
	<%-- => JSP 문서 또는 외부파일에서 생성된 변수(인스턴스)를 같이 사용 가능 --%>
	<%-- => 외부파일의 내용이 변경될 경우 JSP 문서 재컴파일 --%>
	<%-- => file 속성값으로 표현식(Expression) 사용 불가능 - 정적포함 --%>
	<%-- <%@include file="header.jspf"%> --%>
	
	<%-- include 태그 : JSP 문서의 응답 결과 포함 --%>
	<%-- 형식) <jsp:include page="JSP file"></jsp:include> --%>
	<%-- 태그내용이 없는 경우 시작태그와 종료태그를 동시에 구현 --%>
	<%-- 형식) <jsp:include page="JSP file"/> --%>
	<%-- => 스레드가 이동된 JSP 문서의 응답결과(HTML)를 포함하여 페이지 구현 --%>
	<%-- => JSP 문서와 스레드가 이동된 JSP 문서는 다른 문서로 변수(인스턴스)를 같이 사용 불가능 --%>
	<%-- => 스레드가 이동된 JSP 문서의 내용이 변경될 경우 JSP 문서에는 미영향 --%>
	<%-- => page 속성값으로 표현식(Expression) 사용 가능 - 동적포함 --%>
	<%-- <jsp:include page="header_main.jsp"/> --%>
	<%-- 표현식의 결과값에 대한 파일이 존재하지 않을 경우 500 에러 발생 --%>
	<jsp:include page="<%=headerfilePath %>"/>
	
	<%-- Content 영역 --%>
	<ul>
		<li>요청에 대한 결과 출력</li>
		<li>요청에 대한 결과 출력</li>
		<li>요청에 대한 결과 출력</li>
		<li>요청에 대한 결과 출력</li>
		<li>요청에 대한 결과 출력</li>
	</ul>
	
	<%-- Footer 영역 --%>
	<%-- 
	<hr>
	<p>Copyright ⓒitwill Corp. All rights reserved.</p>
	<!-- <p>관리자 : 홍길동(abc@google.com)</p> -->
	<p>관리자 : <%=master %></p> 
	--%>
	 
	<%-- param 태그 : 스레드가 이동되는 JSP 문서에 값(문자열)을 전달 --%> 
	<jsp:include page="footer.jsp">
		<jsp:param value="<%=master %>" name="master"/>
	</jsp:include>
</body>
</html>




