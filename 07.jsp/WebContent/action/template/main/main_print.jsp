<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<h1>메인 페이지</h1>
<%-- 현재 JSP 문서를 기준으로 이미지 파일을 상대경로 표현 --%>
<%-- => 요청 JSP 문서(index.jsp)에 포함될 경우 404 에러 발생 --%>
<%-- <img src="../images/Koala.jpg" width="300"> --%>

<%-- 요청 JSP 문서(index.jsp)를 기준으로 이미지 파일을 상대경로 표현 --%>
<%-- => 현재 JSP 문서를 요청한 경우 404 에러 발생 --%>
<%-- <img src="images/Koala.jpg" width="300"> --%>

<%-- JSP 문서에 관계없이 이미지 파일을 사용하고자 할 경우 절대경로로 표현 --%>
<img src="<%=request.getContextPath() %>/action/template/images/Koala.jpg" width="300">










