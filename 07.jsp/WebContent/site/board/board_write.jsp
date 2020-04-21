<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 게시글(새글 또는 답글)을 입력받기 위한 JSP 문서 --%>    
<%-- => 로그인 상태의 사용자에게만 게시글 쓰기 기능 제공 --%>    
<%-- => [글저장]을 클릭한 경우 게시글 저장 처리페이지(board_write_action.jsp)를 요청하여 입력값 전달 --%>    
<%@include file="/site/security/login_status.jspf" %>
<%
	//부모글의 전달값을 저장하기 위한 변수
	// => 부모글이 없는 경우 초기값 저장 - 새글
	String ref="0", reStep="0", reLevel="0";
	String pageNum="1";//요청페이지 번호 저장
	
	//부모글의 전달값을 반환받아 저장
	if(request.getParameter("ref")!=null) {//부모글이 있는 경우(답글)
		ref=request.getParameter("ref");
		reStep=request.getParameter("reStep");
		reLevel=request.getParameter("reLevel");
		pageNum=request.getParameter("pageNum");
	}
%>
<style type="text/css">
table {
	margin: 0 auto;
}

th {
	width: 70px;
	font-weight: normal;
}

td {
	text-align: left;
}
</style>
<% if(ref.equals("0")) {//새글인 경우 %>
<h2>새글쓰기</h2>
<% } else {//답글인 경우 %>
<h2>답글쓰기</h2>
<% } %>
<form action="<%=request.getContextPath()%>/site/index.jsp?workgroup=board&work=board_write_action"
	method="post" id="boardForm">
	<input type="hidden" name="ref" value="<%=ref%>">
	<input type="hidden" name="reStep" value="<%=reStep%>">
	<input type="hidden" name="reLevel" value="<%=reLevel%>">
	<input type="hidden" name="pageNum" value="<%=pageNum%>">
	<table>
		<tr>
			<th>제목</th>
			<td>
				<input type="text" name="subject" id="subject" size="40">
				<input type="checkbox" name="secret" value="1">비밀글
			</td>	
		</tr>
		<tr>
			<th>내용</th>
			<td>
				<textarea rows="7" cols="60" name="content" id="board_content"></textarea>
			</td>	
		</tr>
		<tr>
			<th colspan="2">
				<button type="submit">글저장</button>
				<button type="reset" id="resetBtn">다시쓰기</button>
			</th>
		</tr>
	</table>
</form>
<div id="message" style="color: red;"></div>

<script type="text/javascript">
$("#subject").focus();

$("#boardForm").submit(function() {
	if($("#subject").val()=="") {
		$("#message").text("제목을 입력해 주세요.");
		$("#subject").focus();
		return false;
	}
	
	if($("#board_content").val()=="") {
		$("#message").text("내용을 입력해 주세요.");
		$("#board_content").focus();
		return false;
	}
});

$("#resetBtn").click(function() {
	$("#subject").focus();
	$("#message").text("");

});
</script>