<%@page import="org.apache.commons.httpclient.methods.GetMethod"%>
<%@page import="org.apache.commons.httpclient.HttpClient"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 가상의 브라우저를 이용하여 다른 서버의 웹어플리케이션을 요청하여
결과를 응답받아 제공하는 JSP 문서 --%>
<%-- => 프록시 기능을 제공하는 프로그램 : HttpClient 클래스 사용 --%>
<%-- https://apache.org 사이트에서 필요한 라이브러리 파일을 다운로드 받아
프로젝트에 빌드되도록 설정 --%>
<%-- => commons-httpclient-3.1.jar, commons-codec-1.14.jar, commons-logging-1.2.jar  --%>    
<%
	//요청 URL 주소 저장
	String url="http://www.khan.co.kr/rss/rssdata/kh_entertainment.xml";

	//HttpClient 인스턴스 생성
	// => 웹서비스 제공하는 서버의 웹어플리케이션을 요청하기 위한 가상의 브라우저 생성 
	HttpClient client=new HttpClient();
	
	//GetMethod 인스턴스 생성
	// => 가상의 브러우저를 이용하여 웹서버의 자원을 요청하기 위한 인스턴스
	// => GetMethod 클래스 : GET 방식으로 요청하기 위한 클래스 
	// => PostMethod 클래스 : POST 방식으로 요청하기 위한 클래스 
	GetMethod method=new GetMethod(url);
	
	try {
		//HttpClient.executeMethod(Method method) : 가상의 브라우저를 이용하여
		//웹서버 자원을 요청하는 메소드
		// => 요청에 대한 응답코드(int)를 반환받아 저장
		int statusCode=client.executeMethod(method);
		
		//현재 JSP 문서의 응답 관련 인스턴스 초기화 
		out.clearBuffer();
		response.reset();
		
		//요청 웹어플리케이션에게 응답코드를 제공
		response.setStatus(statusCode);
		
		//가상의 브라우저를 이용하여 응답된 코드가 200(응답완료)인 경우
		//응답결과를 반환받아 저장
		if(statusCode==HttpServletResponse.SC_OK) {
			//Method.getResponseBodyAsString() : 요청에 대한 응답결과를 
			//문자열로 변환하여 반환하는 메소드
			// => 응답결과의 캐릭터셋을 원하는 형태로 변환하여 저장
			String result=new String(method
				.getResponseBodyAsString().getBytes("8859_1"), "UTF-8");
		
			//요청 웹어플리케이션에게 응답결과에 대한 문서 종류와 캐릭터셋 전달
			response.setContentType("text/xml;charset=UTF-8");
			
			//요청 웹어플리케이션에게 응답결과 제공
			out.println(result);
		}
	} finally {
		//요청 인스턴스 제거 - 가상의 브라우저를 이용한 웹서버 접속 종료
		if(method!=null) method.releaseConnection();
	}
%>










