<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 요청 결과를 JSON 형식의 텍스트 데이타로 응답하는 JSP 문서 --%>    
<%
	String now=new SimpleDateFormat("yyyy년 MM월 dd일 HH시").format(new Date());
%>
{"now":"<%=now%>","songs":[{"title":"마음을 드려요","singer":"아이유"}
,{"title":"아무노래","singer":"지코(ZICO)"}
,{"title":"FIESTA","singer":"IZ*ONE(아이즈원)"}
,{"title":"둘만의 세상으로 가","singer":"Crush"}
,{"title":"METEOR","singer":"창모(CHANGMO)"}]}