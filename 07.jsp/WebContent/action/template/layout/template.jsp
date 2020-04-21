<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 클라이언트 요청에 대한 결과를 전달(응답)하기 위한 JSP 문서 - 응답 페이지 --%>
<%
	//요청 JSP 문서로부터 전달받은 값을 반환받아 저장
	// => Content 영역에 포함시킬 응답결과의 JSP 문서 작성
	String part=request.getParameter("part");
	String work=request.getParameter("work");

	//비정상적인 요청에 대한 응답처리
	if(part==null || work==null) {
		response.sendError(HttpServletResponse.SC_BAD_REQUEST);
		return;
	}
	
	//전달값을 이용하여 JSP 문서의 경로 작성
	String contentFilePath="/action/template/"+part+"/"+part+"_"+work+".jsp";
	//System.out.println("contentFilePath = "+contentFilePath);
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP</title>
<%-- 
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
	color: aqua;
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
--%>

<%-- 요청 JSP 문서와 응답 JSP 문서의 경로가 다른 경우 리소스 파일에 대한
상대경로로 표현할 경우 404 에러 발생 --%>
<%-- => 모든 리소스 파일은 요청 JSP 문서를 기준으로 경로 표현 --%>
<%-- <link href="../css/style.css" rel="stylesheet" type="text/css"> --%>
<%-- <link href="css/style.css" rel="stylesheet" type="text/css"> --%>
<%-- 모든 리소스 파일은 절대경로 표현하는 것을 권장 --%>
<%-- => CSL(HTML, CSS, JavaScript)은 컨텍스트명을 포함하여 표현 --%>
<%-- <link href="/jsp/action/template/css/style.css" rel="stylesheet" type="text/css"> --%>
<%-- request.getContextPath() : 컨텍스트 경로를 반환하는 메소드 --%>
<link href="<%=request.getContextPath()%>/action/template/css/style.css" rel="stylesheet" type="text/css">
</head>
<body>
	<%-- Header 영역 --%>
	<div id="header">
		<jsp:include page="header.jsp"/>
	</div>
	
	<%-- Content 영역 --%>
	<div id="content">
		<jsp:include page="<%=contentFilePath %>"/>
	</div>
	
	<%-- Footer 영역 --%>
	<div id="footer">
		<jsp:include page="footer.jsp"/>
	</div>
</body>
</html>