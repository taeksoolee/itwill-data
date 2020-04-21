<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Spring</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/handlebars.js/4.7.6/handlebars.min.js"></script>
<style type="text/css">
#btnDiv { margin: 10px; }

#insertDiv, #updateDiv {
	width: 240px;
	height: 80px;
	border: 2px solid black;
	background-color: gray;
	position: absolute;
	top: 50%;
	left: 50%;
	margin-top: -40px;
	margin-left: -120px;
	padding: 5px;
	z-index: 100;
	display: none;
}
</style>
</head>
<body>
	<h1>RestBoard</h1>
	<div id="btnDiv">
		<button type="button" id="writeBtn">글쓰기</button>
	</div>
	
	<%-- 게시글 목록을 출력하는 영역 --%>
	<div id="restBoardListDiv"></div>
	
	<%-- 페이지 번호를 출력하는 영역 --%>
	<div id="pageNumDiv"></div>
	
	<%-- 신규 게시글을 입력하는 영역 --%>
	<div id="insertDiv">
	<table>
		<tr>
			<td>작성자</td>
			<td><input type="text" name="writer" id="insertWriter" class="insert"></td>
		</tr>
		<tr>
			<td>내용</td>
			<td><input type="text" name="content" id="insertContent" class="insert"></td>
		</tr>
		<tr>
			<td colspan="2">
				<button type="button" id="insertBtn">저장</button>
				<button type="button" id="cancelInsertBtn">취소</button>
			</td>
		</tr>
	</table>
	</div>

	<%-- 변경 게시글을 입력하는 영역 --%>
	<div id="updateDiv">
	<input type="hidden" name="num" id="updateNum">
	<table>
		<tr>
			<td>작성자</td>
			<td><input type="text" name="writer" id="updateWriter" class="update"></td>
		</tr>
		<tr>
			<td>내용</td>
			<td><input type="text" name="content" id="updateContent" class="update"></td>
		</tr>
		<tr>
			<td colspan="2">
				<button type="button" id="updateBtn">변경</button>
				<button type="button" id="cancelUpdateBtn">취소</button>
			</td>
		</tr>
	</table>
	</div>
	
	<script id="template" type="text/x-handlebars-template">
	<table border="1" cellspacing="0" cellpadding="3">
		<tr>	
			<th width="50">번호</th>
			<th width="100">작성자</th>
			<th width="350">내용</th>
			<th width="200">작성일자</th>
			<th width="50">변경</th>
			<th width="50">삭제</th>
		</tr>	
		{{#each .}}
		<tr>	
			<td align="center">{{num}}</td>
			<td align="center">{{writer}}</td>
			<td>{{content}}</td>
			<td align="center">{{regdate}}</td>
			<td align="center"><button type="button" onclick="update({{num}})">변경</button></td>
			<td align="center"><button type="button" onclick="remove({{num}})">삭제</button></td>
		</tr>
		{{/each}}
	</table>
	</script>
	
	<script type="text/javascript">
	var page=1;
	boardDisplay(page);
	
	//게시글 목록을 요청하여 출력하는 함수
	function boardDisplay(pageNum) {
		page=pageNum;
		$.ajax({
			type: "GET",
			url: "board_list?pageNum="+pageNum,
			dataType: "json",
			success: function(json) {
				if(json.restBoardList.length==0) {
					$("#restBoardListDiv").html("검색된 게시글이 존재하지 않습니다.");
					return;
				}
				
				var source=$("#template").html();
				var template=Handlebars.compile(source);
				$("#restBoardListDiv").html(template(json.restBoardList));
				
				pageDisplay(json.pager);
			},
			error: function(xhr) {
				alert("에러코드 = "+xhr.status)
			}
		});
	}
	
	//페이지 번호를 출력하기 위한 함수
	function pageDisplay(pager) {
		var html="";
		if(pager.startPage>pager.blockSize) {
			html+="<a href='javascript:boardDisplay(1);'>[처음]</a>";
			html+="<a href='javascript:boardDisplay("+pager.prevPage+");'>[이전]</a>";
		} else {
			html+="[처음][이전]";
		}
		
		for(var i=pager.startPage;i<=pager.endPage;i++) {
			if(pager.pageNum!=i) {
				html+="<a href='javascript:boardDisplay("+i+");'>["+i+"]</a>";
			} else {
				html+="["+i+"]";
			}
		}
		
		if(pager.endPage!=pager.totalPage) {
			html+="<a href='javascript:boardDisplay("+pager.nextPage+");'>[다음]</a>";
			html+="<a href='javascript:boardDisplay("+pager.totalPage+");'>[마지막]</a>";
		} else {
			html+="[다음][마지막]";
		}
		
		$("#pageNumDiv").html(html);
	}
	
	$("#writeBtn").click(function() {
		//변경 게시글 입력영역의 입력태그 초기화와 영역숨김 설정
		$(".update").val("");
		$("#updateDiv").hide();
		
		$("#insertDiv").show(300);
	});
	
	$("#insertBtn").click(function() {
		//입력태그의 입력값을 반환받아 저장
		var writer=$("#insertWriter").val();
		var content=$("#insertContent").val();
		
		if(writer=="") {
			alert("작성자를 입력해 주세요.");
			return;
		}
		
		if(content=="") {
			alert("내용을 입력해 주세요.");
			return;
		}
		
		//입력 게시글을 전달하여 저장하는 자원 요청
		$.ajax({
			type: "POST",
			url: "board_add",
			//headers : 요청 자원의 헤더정보를 변경하기 위한 속성
			// => content-type 속성으로 입력값에 대한 전달 텍스트 형식 변경
			headers: {"content-type":"application/json"},
			//JSON.stringify(Object object) : JavaScript 객체를 문자열로 변환하는 메소드
			// => JavaScript 객체를 JSON 형식의 문자열로 변경하여 전달해야만 Java 객체의 필드값으로 저장
			data: JSON.stringify({"writer":writer, "content":content}),
			dateType: "text",
			success: function(text) {
				if(text=="success") {
					$(".insert").val("");
					$("#insertDiv").hide(300);
					boardDisplay(1);
				}
			},
			error: function(xhr) {
				alert("에러코드 = "+xhr.status)
			}
		});
	});
	
	$("#cancelInsertBtn").click(function() {
		//신규 게시글 입력영역의 입력태그 초기화와 영역숨김 설정
		$(".insert").val("");
		$("#insertDiv").hide(300);
	});
	
	function update(num) {
		//신규 게시글 입력영역의 입력태그 초기화와 영역숨김 설정
		$(".insert").val("");
		$("#insertDiv").hide();

		$("#updateDiv").show(300);
		
		$.ajax({
			type: "GET",
			//url: "board_view?num="+num,
			url: "board_view/"+num,
			dataType: "json",
			success: function(json) {
				$("#updateNum").val(json.num);
				$("#updateWriter").val(json.writer);
				$("#updateContent").val(json.content);
			},
			error: function(xhr) {
				alert("에러코드 = "+xhr.status)
			}
		});
	}
	
	$("#updateBtn").click(function() {
		//입력태그의 입력값을 반환받아 저장
		var num=$("#updateNum").val();
		var writer=$("#updateWriter").val();
		var content=$("#updateContent").val();
		
		if(writer=="") {
			alert("작성자를 입력해 주세요.");
			return;
		}
		
		if(content=="") {
			alert("내용을 입력해 주세요.");
			return;
		}
		
		$.ajax({
			type: "PUT",
			url: "board_modify",
			//GET 또는 POST를 제외한 요청방식을 인식하지 못하는 브라우저를 위해 요청에 대한 
			//X-HTTP-Method-override 헤더정보를 변경하여 나머지 요청방식을 인식되도록 설정
			headers: {"content-type":"application/json","X-HTTP-Method-override":"PUT"},
			data: JSON.stringify({"num":num,"writer":writer, "content":content}),
			dateType: "text",
			success: function(text) {
				if(text=="success") {
					$(".update").val("");
					$("#updateDiv").hide(300);
					boardDisplay(page);
				}
			},
			error: function(xhr) {
				alert("에러코드 = "+xhr.status)
			}
		});
	});
	
	$("#cancelUpdateBtn").click(function() {
		//변경 게시글 입력영역의 입력태그 초기화와 영역숨김 설정
		$(".update").val("");
		$("#updateDiv").hide(300);
	});
	
	function remove(num) {
		if(confirm("정말 삭제 하겠습니까?")) {
			$.ajax({
				type: "DELETE",
				url: "board_remove/"+num,
				headers: {"X-HTTP-Method-override":"DELETE"},
				dataType: "text",
				success: function(text) {
					if(text=="success") {
						boardDisplay(1);
					}
				},
				error: function(xhr) {
					alert("에러코드 = "+xhr.status)
				}
			});
		}
	}
	</script>
</body>
</html>










