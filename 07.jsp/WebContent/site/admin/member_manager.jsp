<%@page import="site.itwill.dao.MemberDAO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- MEMBER 테이블에 저장된 회원목록을 검색하여 클라이언트에게 전달하는 JSP 문서 --%>
<%-- => [선택회원삭제]를 클릭한 경우 회원정보 삭제 처리페이지(member_remove_action.jsp) 요청 --%>
<%-- => [상태]를 변경한 경우 회원상태 변경 처리페이지(member_change_action.jsp) 요청 --%>
<%@include file="/site/security/admin_check.jspf"%>
<%
	//MEMBER 테이블에 저장된 회원목록을 검색하여 반환하는 DAO 클래스의 메소드 호출
	List<MemberDTO> memberList=MemberDAO.getDAO().selectAllMember();
%>   
<style type="text/css">
table {
	margin: 0 auto;
	border: 1px solid black;
	border-collapse: collapse;
}

th, td {
	border: 1px solid black;
	padding: 3px;
	text-align: center;
	font-size: 14px;
}

th {
	background: black;
	color: white;
}

.member_check { width: 80px; }
.member_id { width: 80px; }
.member_name { width: 80px; }
.member_email { width: 140px; }
.member_mobile { width: 140px; }
.member_address { width: 300px; }
.member_join { width: 150px; }
.member_login { width: 150px; }
.member_status { width: 80px; }
</style>
 
<h2>회원목록</h2>
<form name="memberForm" id="memberForm">
<table>
	<tr>
		<th><input type="checkbox" id="allCheck"></th>
		<th>아이디</th>
		<th>이름</th>
		<th>이메일</th>
		<th>전화번호</th>
		<th>주소</th>
		<th>가입날짜</th>
		<th>로그인날짜</th>
		<th>상태</th>
	</tr>
	
	<% for(MemberDTO member:memberList) { %>
	<tr>
		<td class="member_check">
		<% if(member.getStatus()==9) { %>
			관리자
		<% } else { %>
			<input type="checkbox" name="checkId" value="<%=member.getId()%>" class="check">
		<% } %>
		</td>
		<td class="member_id"><%=member.getId() %></td>
		<td class="member_name"><%=member.getName() %></td>
		<td class="member_email"><%=member.getEmail() %></td>
		<td class="member_mobile"><%=member.getMobile() %></td>
		<td class="member_address">
			[<%=member.getZipcode() %>]<%=member.getAddress1() %> <%=member.getAddress2() %>
		</td>
		<td class="member_join"><%=member.getJoinDate().substring(0, 19) %></td>
		<td class="member_login">
			<% if(member.getLastLogin()!=null) { %>
				<%=member.getLastLogin().substring(0, 19)%>
			<% } %>
		</td>
		<td class="member_status">
			<select class="status" name="<%=member.getId()%>">
				<option value="1" <% if(member.getStatus()==1) { %> selected <% } %>>&nbsp;일반회원&nbsp;</option>
				<option value="9" <% if(member.getStatus()==9) { %> selected <% } %>>&nbsp;관리자&nbsp;</option>
			</select>
		</td>
	</tr>
	<% } %>
</table>
<p><button type="button" id="removeBtn">선택회원삭제</button></p>
<div id="message" style="color: red;"></div>
</form>

<script type="text/javascript">
$("#allCheck").change(function() {
	if($(this).is(":checked")) {
		$(".check").prop("checked", true);
	} else {
		$(".check").prop("checked", false);
	}
});

$("#removeBtn").click(function() {
	if($(".check").filter(":checked").size()==0) {
		$("#message").text("선택한 회원이 하나도 없습니다.");
		return;
	}
	
	$("#memberForm").attr("method","post");
	$("#memberForm").attr("action","<%=request.getContextPath()%>/site/index.jsp?workgroup=admin&work=member_remove_action");
	$("#memberForm").submit();
});

$(".status").change(function() {
	var id=$(this).attr("name");
	var status=$(this).val();
	//alert(id+" = "+status);
	location.href="<%=request.getContextPath()%>/site/index.jsp?workgroup=admin&work=member_change_action&id="+id+"&status="+status;
});
</script>







