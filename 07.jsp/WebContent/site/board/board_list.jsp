<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="site.itwill.dto.MemberDTO"%>
<%@page import="site.itwill.dto.BoardDTO"%>
<%@page import="java.util.List"%>
<%@page import="site.itwill.dao.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- BOARD 테이블에 저장된 게시글을 검색하여 게시글 목록을 클라이언트에게 전달하는 JSP 문서 --%>
<%-- => 게시글 목록을 페이지로 구분하여 출력 - 페이징 처리(SQL 명령) --%>
<%-- => 페이지 번호 출력 - 페이징 처리(알고리즘) --%>
<%-- => [제목]을 클릭할 경우 게시글 상세 출력페이지(board_detail.jsp)로 이동 --%>
<%-- => [페이지 번호]와 [검색]을 클릭한 경우 게시글 목록 출력페이지(board_list.jsp)로 이동 --%>
<%
	//검색대상과 검색단어를 반환받아 저장
	String search=request.getParameter("search");
	if(search==null) search="";
	String keyword=request.getParameter("keyword");
	if(keyword==null) keyword="";

	//전달된 페이지 번호를 반환받아 저장
	int pageNum=1;
	if(request.getParameter("pageNum")!=null) {
		pageNum=Integer.parseInt(request.getParameter("pageNum"));
	}
	
	//하나의 페이지에 출력될 게시글의 갯수 설정
	int pageSize=10;
	
	//BOARD 테이블에 저장된 전체 게시글의 갯수를 검색하여 반환하는 DAO 클래스의 메소드 호출
	//int totalBoard=BoardDAO.getDAO().selectBoardCount();
	//BOARD 테이블에 저장된 전체 게시글 중 검색 게시글의 갯수를 검색하여 반환하는 DAO 클래스의 메소드 호출
	int totalBoard=BoardDAO.getDAO().selectBoardCount(search,keyword);
	     
	//전체 페이지 갯수를 계산하여 저장
	//int totalPage=totalBoard/pageSize+(totalBoard%pageSize==0?0:1);
	int totalPage=(int)Math.ceil((double)totalBoard/pageSize);
	
	//저장된 페이지 번호에 대한 검증
	if(pageNum<=0 || pageNum>totalPage) {//비정상적인 요청
		pageNum=1;
	}
	
	//페이지에 대한 게시글 시작행 번호를 계산하여 저장
	//ex) 1 Page : 1, 2 Page : 11, 3 Page : 21, 4 Page : 31, ... 
	int startRow=(pageNum-1)*pageSize+1;
	
	//페이지에 대한 게시글 종료행 번호를 계산하여 저장
	//ex) 1 Page : 10, 2 Page : 20, 3 Page : 30, 4 Page : 40, ... 
	int endRow=pageNum*pageSize;
	
	//마지막 페이지는 게시글의 전체 갯수가 종료행 번호가 되도록 설정 
	if(endRow>totalBoard) {
		endRow=totalBoard;
	}
	
	//게시글의 시작 행번호와 종료 행번호를 전달하여 BOARD 테이블에 저장된
	//게시글 중 시작 행번호와 종료 행번호 범위의 게시글을 검색하여 반환하는
	//DAO 클래스의 메소드 호출
	//List<BoardDTO> boardList=BoardDAO.getDAO().selectBoard(startRow, endRow);
	List<BoardDTO> boardList=BoardDAO.getDAO().selectBoard(startRow, endRow, search, keyword);
	
	//출력될 페이지의 게시글 시작번호를 계산하여 저장
	int number=totalBoard-(pageNum-1)*pageSize;
	
	//세션에 저장된 인증정보(회원정보)를 반환받아 저장
	MemberDTO loginMember=(MemberDTO)session.getAttribute("loginMember");
	
	//서버 시스템의 현재 날짜(시간)정보 저장
	String currentDate=new SimpleDateFormat("yyyy-MM-dd").format(new Date());
%>
<style type="text/css">
#board_list {
	width: 1000px;
	margin: 0 auto;
	text-align: center;
}

#board_title {
	font-size: 1.3em;
	font-weight: bold;
}

#btn {
	text-align: right;
}

table {
	margin: 5px auto;
	border: 1px solid black;
	border-collapse: collapse;
}

th {
	border: 1px solid black;
	background: black;
	color: white;	
}

td {
	border: 1px solid black;
}

.subject {
	text-align: left;
	padding-left: 5px;
	overflow: hidden;
	text-overflow: ellipsis;
}

#board_list a:hover {
	text-decoration: underline;
	color: blue;
}

.secret, .remove {
	background: black;
	color: white;
	font-size: 14px;
	border: 1xp solid black;
	border-radius: 4px; 
}
</style>

<div id="board_list">
	<div id="board_title">
	게시글 목록(게시글 갯수 : <%=totalBoard %>)
	</div>
	
	<% if(loginMember!=null) {//로그인 상태의 사용자인 경우 %>
	<div id="btn">
		<button type="button" id="writeBtn">글쓰기</button>
	</div>
	<% } %>
	
	<table>
		<tr>
			<th width="100">번호</th>
			<th width="500">제목</th>
			<th width="100">작성자</th>
			<th width="100">조회수</th>
			<th width="200">작성일</th>
		</tr>
		
		<% if(totalBoard==0) { %>
		<tr>
			<td colspan="5">검색된 게시글이 하나도 없습니다.</td>
		</tr>
		<% } else { %>
			<%-- 게시글 목록 출력 --%>
			<% for(BoardDTO board:boardList) { %>
			<tr>
				<%-- 글번호 --%>
				<td><%=number %></td>
			
				<%-- 제목 --%>
				<td class="subject">
				<% if(board.getReStep()!=0) {//답글인 경우 %>
					<%-- 왼쪽 여백을 답글 깊이에 따라 다르게 출력 --%>
					<span style="margin-left: <%=board.getReLevel()*20%>px;">└[답글]</span>
				<% } %>
				
				<%-- 게시글 상태에 따른 제목 출력과 하이퍼 링크 설정 --%>
				<% if(board.getStatus()==0) {//일반글 %>
					<a href="<%=request.getContextPath()%>/site/index.jsp?workgroup=board&work=board_detail&num=<%=board.getNum() %>&pageNum=<%=pageNum%>&search=<%=search%>&keyword=<%=keyword%>">
					<%=board.getSubject() %>
					</a>
				<% } else if(board.getStatus()==1) {//비밀글 %>
					<span class="secret">비밀글</span>
					<% if(loginMember!=null && (loginMember.getId().equals
							(board.getId()) || loginMember.getStatus()==9)) { %>
					<a href="<%=request.getContextPath()%>/site/index.jsp?workgroup=board&work=board_detail&num=<%=board.getNum() %>&pageNum=<%=pageNum%>&search=<%=search%>&keyword=<%=keyword%>">
					작성자 또는 관리자만 확인 가능합니다.
					</a>
					<% } else { %>
					작성자 또는 관리자만 확인 가능합니다.
					<% } %>
				<% } else if(board.getStatus()==9) {//삭제글 %>
					<span class="remove">삭제글</span>
					작성자 또는 관리자에 의해 삭제된 게시글입니다.
				<% } %>
				</td>
			
				<% if(board.getStatus()!=9) {//삭제글이 아닌 경우 %>
				<%-- 작성자 --%>
				<td><%=board.getWriter() %></td>
			
				<%-- 조회수 --%>
				<td><%=board.getReadCount() %></td>
			
				<%-- 작성일 --%>
				<td>
				<% if(currentDate.equals(board.getRegDate().substring(0, 10))) { %>
					<%=board.getRegDate().substring(11, 19) %>
				<% } else { %>
					<%=board.getRegDate().substring(0, 19) %>
				<% } %>
				</td>
				<% } else {//삭제글인 경우 %>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
				<% } %>
			</tr>
			<% number--; %>	
			<% } %>
		<% } %>
	</table>

	<%-- 페이지 번호 출력(페이징 처리)과 하이퍼 링크 설정 --%>
	<%
		//하나의 페이지 블럭에 출력될 페이지 번호의 갯수 설정
		int blockSize=5;
	
		//페이지 블럭에 출력될 시작 페이지 번호를 계산하여 저장
		// => 1 Block : 1, 2 Block : 6, 3 Block : 11, 4 Block : 16, ... 
		int startPage=(pageNum-1)/blockSize*blockSize+1;
	
		//페이지 블럭에 출력될 종료 페이지 번호를 계산하여 저장
		// => 1 Block : 5, 2 Block : 10, 3 Block : 15, 4 Block : 20, ... 
		int endPage=startPage+blockSize-1;
		
		//마지막 페이지 블럭의 종료 페이지 번호 변경
		if(endPage>totalPage) {
			endPage=totalPage;
		}
	%>
	
	<div>
	<% if(startPage>blockSize) { %>
		<a href="<%=request.getContextPath()%>/site/index.jsp?workgroup=board&work=board_list&pageNum=1&search=<%=search%>&keyword=<%=keyword%>">[처음]</a>
		<a href="<%=request.getContextPath()%>/site/index.jsp?workgroup=board&work=board_list&pageNum=<%=startPage-blockSize%>&search=<%=search%>&keyword=<%=keyword%>">[이전]</a>
	<% } else { %>
		[처음][이전]
	<% } %>
	
	<% for(int i=startPage;i<=endPage;i++) { %>
		<% if(pageNum!=i) { %>
			<a href="<%=request.getContextPath()%>/site/index.jsp?workgroup=board&work=board_list&pageNum=<%=i%>&search=<%=search%>&keyword=<%=keyword%>">[<%=i%>]</a>
		<% } else { %>
			<span style="font-weight: bold; font-size: 18px;">[<%=i%>]</span>
		<% } %>	
	<% } %>
	
	<% if(endPage!=totalPage) { %>
		<a href="<%=request.getContextPath()%>/site/index.jsp?workgroup=board&work=board_list&pageNum=<%=startPage+blockSize%>&search=<%=search%>&keyword=<%=keyword%>">[다음]</a>
		<a href="<%=request.getContextPath()%>/site/index.jsp?workgroup=board&work=board_list&pageNum=<%=totalPage%>&search=<%=search%>&keyword=<%=keyword%>">[마지막]</a>
	<% } else { %>	
		[다음][마지막]
	<% } %>
	</div>
	<br>
	
	<%-- 게시글 검색 --%>
	<form action="<%=request.getContextPath()%>/site/index.jsp?workgroup=board&work=board_list" method="post" id="searchForm">
		<select name="search">
			<option value="writer" selected>&nbsp;작성자&nbsp;</option>
			<option value="subject">&nbsp;제목&nbsp;</option>
			<option value="content">&nbsp;내용&nbsp;</option>
		</select>
		<input type="text" name="keyword" id="keyword">
		<button type="submit">검색</button>
	</form>
</div>

<script type="text/javascript">
$("#writeBtn").click(function() {
	location.href="<%=request.getContextPath()%>/site/index.jsp?workgroup=board&work=board_write";
});	
</script>





