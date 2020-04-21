<%@page import="site.itwill.dto.MyHewon"%>
<%@page import="site.itwill.dao.MyHewonDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	MyHewonDAO.getDAO().insertHewon(new MyHewon("aaa","홍길동","111-1111","aaa@itwill.site",1));
	MyHewonDAO.getDAO().insertHewon(new MyHewon("bbb","임꺽정","222-2222","bbb@itwill.site",2));
	MyHewonDAO.getDAO().insertHewon(new MyHewon("ccc","전우치","333-3333","ccc@itwill.site",3));
	MyHewonDAO.getDAO().insertHewon(new MyHewon("ddd","일지매","444-4444","ddd@itwill.site",4));
	MyHewonDAO.getDAO().insertHewon(new MyHewon("eee","홍길동","555-5555","eee@itwill.site",3));
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Mybatis</title>
</head>
<body>
	<h1>회원등록</h1>
	<hr>
	<h3>회원정보를 성공적으로 등록 하였습니다.</h3>
</body>
</html>