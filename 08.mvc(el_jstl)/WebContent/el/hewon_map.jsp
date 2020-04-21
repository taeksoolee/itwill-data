<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	Map<String, String> hewonMap=new HashMap<String, String>();
	hewonMap.put("first.name", "홍");
	hewonMap.put("second.name", "길동");

	request.setAttribute("hewonMap", hewonMap);		
	
	request.getRequestDispatcher("hewon_map_el.jsp").forward(request, response);
%>