<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSP</title>
</head>
<body>
	<h1 align="center">학생리스트</h1>
	<table align="center" cellspacing="0" cellpadding="1" width="800">
		<tr align="right">
			<td>
				<input type="button" value="학생추가"
					 onclick="location.href='${pageContext.request.contextPath}/student/add';">
			</td>
		</tr>
	</table>
	<table align="center" border="1" cellspacing="0" cellpadding="1" width="800">
		<tr bgcolor="yellow">
			<th width="100">학생번호</th>
			<th width="100">이름</th>
			<th width="150">전화번호</th>
			<th width="250">주소</th>
			<th width="100">생년월일</th>
		</tr>
		
		<!-- 학생정보 출력-->
		<c:choose>
			<c:when test="${empty(studentList) }">
				<tr align="center">
					<td colspan="5">검색된 학생정보가 없습니다.</td>		
				</tr>
			</c:when>
			<c:otherwise>
				<c:forEach var="student" items="${studentList }">
				<tr align="center">
					<td width="100">${student.no }</td>				
					<td width="100">${student.name }</td>				
					<td width="150">${student.phone }</td>				
					<td width="250">${student.address }</td>				
					<td width="100">${fn:substring(student.birthday,0,10)}</td>				
				</tr>	
				</c:forEach>
			</c:otherwise>
		</c:choose>
	</table>
</body>
</html>