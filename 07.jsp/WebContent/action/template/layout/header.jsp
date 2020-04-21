<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<h1><a href="<%=request.getContextPath()%>/action/template/index.jsp?part=main&work=print">쇼핑몰</a></h1>
<div id="menu">
	<a href="<%=request.getContextPath()%>/action/template/index.jsp?part=product&work=new">신제품</a>&nbsp;&nbsp;&nbsp;
	<a href="<%=request.getContextPath()%>/action/template/index.jsp?part=product&work=best">추천제품</a>&nbsp;&nbsp;&nbsp;
	<a href="<%=request.getContextPath()%>/action/template/index.jsp?part=cart&work=list">장바구니</a>&nbsp;&nbsp;&nbsp;
	<a href="<%=request.getContextPath()%>/action/template/index.jsp?part=board&work=list">게시판</a>&nbsp;&nbsp;&nbsp;
</div>
