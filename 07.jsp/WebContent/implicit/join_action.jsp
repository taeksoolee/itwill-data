<%@page import="java.net.URLEncoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 입력페이지(join_form.jsp)에서 전달된 값을 반환받아 클라이언트에게 전달하는
JSP 문서 - 처리와 출력페이지 --%>    
<%
	//비정상적인 요청에 대한 응답처리 - 에러코드 전달 또는 에러페이지 이동
	// => JSP 문서를 GET 방식으로 요청한 경우
	//request.getMethod() : 클라이언트의 요청방식을 반환하는 메소드
	if(request.getMethod().equals("GET")) {
		/*
		//response.sendError(int sc) : 클라이언트에게 에러코드를 전달하는 메소드
		// => 에러코드는 상수필드를 사용하는 것을 권장
		//response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
		
		//response.sendRedirect(String location) : JSP 문서로 이동하는 메소드
		// => 301 코드와 요청문서를 전달하여 JSP 문서를 재요청하도록 지시
		response.sendRedirect("../error/error_405.jsp");
		return;
		*/
		
		/*
		//입력페이지로 이동 - QueryString을 이용하여 메세지 전달
		// => QueryString은 영문자,숫자,일부 특수문자를 제외한 문자 전달 불가능
		// => 전달 불가능한 문자는 부호화 처리하여 전달
		//String message="비정상적인 방법으로 요청 하였습니다.";
		//URLEncoder.encode(String s, String enc) : 문자열을 부호화 처리하여 반환하는 메소드
		// => 입력받은 문자열에 대한 인코딩 방식을 매개변수에 전달
		String message=URLEncoder.encode("비정상적인 방법으로 요청 하였습니다.", "utf-8");
		response.sendRedirect("join_form.jsp?message="+message);
		return;
		*/
		
		//인스턴스 공유 - Session Scope
		session.setAttribute("message", "비정상적인 방법으로 요청 하였습니다.");
		response.sendRedirect("join_form.jsp");
		return;
	}


	//리퀘스트 메세지의 입력값에 대한 캐릭터셋 변경
	//request.setCharacterEncoding(String encoding) : 입력값에 대한 캐릭터셋 변경 메소드
	request.setCharacterEncoding("utf-8");

	//입력값을 반환받아 저장
	//request.getParameter(String name) : 입력값을 문자열로 반환하는 메소드
	// => 매개변수에 입력값에 대한 이름(name 속성값)을 전달
	// => 입력값에 대한 이름이 없는 경우 null 반환
	String id=request.getParameter("id");
	String pass=request.getParameter("pass");
	String name=request.getParameter("name");
	String addr=request.getParameter("addr");
	String sex=request.getParameter("sex");
	String job=request.getParameter("job");
	//request.getParameterValues(String name) : 입력값들을 문자열 배열로 반환하는 메소드
	// => 입력값이 같은 이름으로 전달될 경우 사용
	String[] hobby=request.getParameterValues("hobby");
	String profile=request.getParameter("profile");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP</title>
</head>
<body>
	<h1>회원정보확인</h1>
	<hr>
	<ul>
		<li>아이디 = <%=id %></li>
		<li>비밀번호 = <%=pass %></li>
		<li>이름 = <%=name %></li>
		<li>주소 = <%=addr %></li>
		<li>성별 = <%=sex %></li>
		<li>직업 = <%=job %></li>
		<% if(hobby==null) { %>
			<li>취미 = 선택한 취미가 하나도 없습니다.</li>
		<% } else { %>
			<li>취미 = 
			<% for(String temp:hobby) { %>
				<%=temp %>&nbsp;
			<% } %>	
			</li>
		<% } %>
		<%-- 엔터(\n)를 <br> 태그로 변환하여 전달 --%>
		<li>자기소개<br><%=profile.replace("\n", "<br>") %></li>
	</ul>
</body>
</html>








