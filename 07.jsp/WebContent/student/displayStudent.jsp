<%@page import="site.itwill.dao.StudentDAO"%>
<%@page import="site.itwill.dto.StudentDTO"%>
<%@page import="java.util.List"%>
<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- STUDENT 테이블에 저장된 모든 학생정보를 검색하여 클라이언트에게 전달하는 JSP 문서 --%>
<%-- => [학생추가] 버튼을 누른 경우 학생정보 저장 입력페이지(insertFormStudent.jsp)로 이동 --%>    
<%-- => [삭제] 버튼을 누른 경우 학생정보 삭제 처리페이지(deleteStudent.jsp)로 이동 - 학번 전달  --%>    
<%-- => [변경] 버튼을 누른 경우 학생정보 변경 입력페이지(updateFormStudent.jsp)로 이동 - 학번 전달 --%>
<%
	String message=(String)session.getAttribute("message");
	if(message==null) {
		message="";
	} else {
		session.removeAttribute("message");
	}

	//STUDENT 테이블에 저장된 모든 학생정보를 검색하여 반환하는 DAO 클래스의 메소드 호출
	List<StudentDTO> studentList=StudentDAO.getDAO().selectAllStudent();
%>    
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
					 onclick="location.href='insertFormStudent.jsp';">
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
			<th width="50">삭제</th>
			<th width="50">변경</th>
		</tr>
		
		<!-- 학생정보 출력-->
		<% if(studentList.isEmpty()) { %>
			<tr align="center">
				<td colspan="7">검색된 학생정보가 없습니다.</td>		
			</tr>
		<% } else { %>
			<% for(StudentDTO student:studentList) { %>
			<tr align="center">
				<td width="100"><%=student.getNo() %></td>				
				<td width="100"><%=student.getName() %></td>				
				<td width="150"><%=student.getPhone() %></td>				
				<td width="250"><%=student.getAddress() %></td>				
				<td width="100"><%=student.getBirthday() %></td>				
				<td width="50"><input type="button" value="삭제" onclick="removeStudent('<%=student.getNo()%>');"></td>				
				<td width="50"><input type="button" value="변경" onclick="location.href='updateFormStudent.jsp?no=<%=student.getNo()%>';"></td>				
			</tr>	
			<% } %>
		<% } %>
	</table>
	<div align="center" style="color: red; "><%=message %></div>
	
	<script type="text/javascript">
	function removeStudent(no) {
		if (confirm("정말로 삭제 하겠습니까?")) {
			location.href="deleteStudent.jsp?no="+no;
		}
	}
	</script>
</body>
</html>


