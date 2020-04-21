<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//스레드가 이동된 JSP 문서는 요청 JSP 문서의 request 인스턴스와 
	//reponse 인스턴스를 전달받아 사용 
	// => request 인스턴스는 전달값 반환이 가능하지만 request 인스턴스 변경 불가능
	// => response 인스턴스는 결과값 전달이 가능하지만 리다이렉트 이동 불가능
	//request.setCharacterEncoding("utf-8");

	String master=request.getParameter("master");
	
	if(master==null) {
		//스레드가 이동된 JSP 문서는 리다이렉트 이동 불가능
		//response.sendRedirect("../standard_action.jsp"");
		
		//스레드가 이동된 JSP 문서에서 페이지를 이동할 경우 Javascript 이용
		out.println("<script type='text/javascript'>");
		out.println("location.href='../standard_action.jsp';");
		out.println("</script>");
		return;
	}
%>    
<hr>
<p>Copyright ⓒitwill Corp. All rights reserved.</p>
<p>관리자 : <%=master %></p>





