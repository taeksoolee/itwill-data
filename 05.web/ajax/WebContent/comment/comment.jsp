<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- AJAX_COMMENT 테이블을 이용하여 댓글에 대한 저장, 삭제, 변경 기능을 
제공하고 댓글목록을 검색하여 출력하는 JSP 문서 --%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>AJAX</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<style type="text/css">
h1 {
	text-align: center;
}

.comment_table {
	width: 500px;
	margin: 0 auto;
	border: 2px solid #cccccc;
	border-collapse: collapse;
}

.title {
	width: 100px;
	padding: 5px 10px;
	text-align: center;
	border: 1px solid #cccccc;
}

.input {
	width: 400px;
	padding: 5px 10px;
	border: 1px solid #cccccc;
}

.btn {
	text-align: center;
	border: 1px solid #cccccc;
}

#comment_add {
	margin-bottom: 5px;
}

#comment_modify, #comment_remove {
	margin: 10px;
	display: none;
}

#add_message, #modify_message {
	width: 500px;
	margin: 0 auto;
	margin-bottom: 20px;
	text-align: center;
	color: red;
}

#remove_message {
	padding: 3px;
	text-align: center;
	border: 1px solid #cccccc;
}

.comment {
	width: 550px;
	margin: 0 auto;
	margin-bottom: 5px;
	padding: 3px;
	border: 2px solid #cccccc;
}

.no_comment {
	width: 550px;
	margin: 0 auto;
	padding-bottom: 3px;
	border: 2px solid #cccccc;
	text-align: center;
}
</style>
</head>
<body>
	<h1>AJAX 댓글</h1>
	<hr>
	<%-- 댓글 입력 영역 --%>
	<div id="comment_add">
		<table class="comment_table">
			<tr>
				<td class="title">작성자</td>
				<td class="input">
					<input type="text" id="writer">
				</td>
			</tr>
			<tr>
				<td class="title">댓글내용</td>
				<td class="input">
					<textarea rows="3" cols="50" id="content"></textarea>
				</td>
			</tr>
			<tr>
				<td colspan="2" class="btn">
					<button type="button" id="add_btn">댓글등록</button>
				</td>
			</tr>
		</table>
		<div id="add_message">&nbsp;</div>
	</div>
	
	<%-- 댓글목록 출력 영역 --%>
	<div id="comment_list"></div>
	
	<%-- 댓글 변경 영역 --%>
	<div id="comment_modify">
		<table class="comment_table">
			<tr>
				<td class="title">작성자</td>
				<td class="input">
					<input type="text" id="modify_writer">
				</td>
			</tr>
			<tr>
				<td class="title">댓글내용</td>
				<td class="input">
					<textarea rows="3" cols="50" id="modify_content"></textarea>
				</td>
			</tr>
			<tr>
				<td colspan="2" class="btn">
					<button type="button" id="modify_btn">변경</button>
					<button type="button" id="modify_cancel_btn">취소</button>
				</td>
			</tr>
		</table>
		<div id="modify_message">&nbsp;</div>
	</div>
	
	<%-- 댓글 삭제 영역 --%>
	<div id="comment_remove">
		<div id="remove_message">
			<b>정말로 삭제 하시겠습니까?</b>
			<button type="button" id="remove_btn">삭제</button>
			<button type="button" id="remove_cancel_btn">취소</button>
		</div>
	</div>
	
	<script type="text/javascript">
	loadComment();
	
	//댓글목록을 제공하는 JSP 문서를 요청하여 결과를 응답받아 출력하는 함수
	function loadComment() {
		$.ajax({
			type: "GET",
			url: "comment_list.jsp",
			dataType: "xml",
			success: function(xmlDoc) {
				var code=$(xmlDoc).find("code").text();
				
				if(code=="success") {//검색된 댓글이 있는 경우
					var commentArray=JSON.parse($(xmlDoc).find("data").text());
					//alert(commentArray.length);
					
					//댓글목록 출력영역 초기화
					$("#comment_list").children().remove();
					
					$(commentArray).each(function() {
						var html="<div id='comment_"+this.num+"' class='comment' num='"+this.num+"'>";
						html+="<b>["+this.writer+"]</b><br>";
						html+=this.content.replace(/\n/g,"<br>");
						html+="<br>("+this.writeDate+")<br>";
						html+="<button type='button' onclick='modifyComment("+this.num+");'>댓글변경</button>&nbsp;";
						html+="<button type='button' onclick='removeComment("+this.num+");'>댓글삭제</button>";
						html+="</div>";
						$("#comment_list").append(html);
					});
				} else {//검색된 댓글이 없는 경우
					var message=$(xmlDoc).find("message").text();
					$("#comment_list").html("<div class='no_comment'>"+message+"</div>");
				}
			},
			error: function(xhr) {
				alert("에러코드 = "+xhr.status);
			}
		});
	}
	
	//[댓글등록]을 클릭한 경우 호출될 이벤트 핸들러 함수 등록
	// => 입력값을 전달받아 댓글을 저장하는 JSP 문서를 요청하여 응답결과를 제공받아 처리
	$("#add_btn").click(function() {
		var writer=$("#writer").val();
		if(writer=="") {
			$("#add_message").html("작성자를 입력해 주세요.");
			$("#writer").focus();
			return;
		}
		
		var content=$("#content").val();
		if(content=="") {
			$("#add_message").html("댓글내용을 입력해 주세요.");
			$("#content").focus();
			return;
		}
		
		$("#writer").val("");
		$("#content").val("");
		$("#add_message").html("&nbsp;");
		
		$.ajax({
			type: "POST",
			url: "comment_add.jsp",
			data: {"writer":writer,"content":content},
			dataType: "xml",
			success: function(xmlDoc) {
				var code=$(xmlDoc).find("code").text();

				if(code=="success") {
					loadComment();
				}
			},
			error: function(xhr) {
				alert("에러코드 = "+xhr.status);
			}
		});
	});
		
	//[댓글변경]을 클릭한 경우 호출되는 이벤트 핸들러 함수
	// => 댓글정보를 검색하는 JSP 문서를 요청하여 응답결과를 제공받아 처리
	function modifyComment(num) {
		//alert(num);
		initModify();

		//댓글 삭제 영역을 숨기고 Document 영역의 자식으로 이동
		$("#comment_remove").hide().appendTo(document.documentElement);
		//댓글 변경 영역을 출력하고 댓글영역의 자식으로 이동
		$("#comment_modify").show().appendTo("#comment_"+num);
		
		$.ajax({
			type: "GET",
			url: "comment_get.jsp",
			data: {"num":num},
			dataType: "xml",
			success: function(xmlDoc) {
				var code=$(xmlDoc).find("code").text();
				if(code=="success") {
					var comment=JSON.parse($(xmlDoc).find("data").text());
					$("#modify_writer").val(comment.writer);
					$("#modify_content").val(comment.content);
				} else {
					//댓글 변경 영역을 숨기고 Document 객체의 자식으로 이동
					$("#comment_modify").hide().appendTo(document.documentElement);
					$("#add_message").html("댓글이 존재하지 않습니다.");
				}
			}, 
			error: function(xhr) {
				alert("에러코드 = "+xhr.status);
			}
		});
	}
	
	//[변경]을 클릭한 경우 호출될 이벤트 핸들러 함수 등록
	// => 변경값을 전달받아 댓글을 변경하는 JSP 문서를 요청하여 응답결과를 제공받아 처리
	$("#modify_btn").click(function() {
		var num=$("#comment_modify").parent().attr("num");
		//alert("num = "+num);
		
		var writer=$("#modify_writer").val();
		if(writer=="") {
			$("#modify_message").html("변경할 작성자를 입력해 주세요.");
			$("#modify_writer").focus();
			return;
		}
		
		var content=$("#modify_content").val();
		if(content=="") {
			$("#modify_message").html("변경 댓글내용을 입력해 주세요.");
			$("#modify_content").focus();
			return;
		}
		
		initModify();
		
		$.ajax({
			type: "POST",
			url: "comment_modify.jsp",
			data: {"num":num, "writer":writer, "content":content},
			dataType: "xml",
			success: function(xmlDoc) {
				var code=$(xmlDoc).find("code").text();

				if(code=="success") {
					$("#comment_modify").hide().appendTo(document.documentElement);
					loadComment();
				} else {
					$("#modify_message").html("댓글을 변경하지 못했습니다.");
				}
			},
			error: function(xhr) {
				alert("에러코드 = "+xhr.status);
			}
		});
		
		
	});
	
	//변경에 대한 [취소]를 클릭한 경우 호출될 이벤트 핸들러 함수 등록
	$("#modify_cancel_btn").click(function() {
		initModify();
		$("#comment_modify").hide().appendTo(document.documentElement);
	});
	
	//댓글 변경 영역 초기화 함수
	function initModify() {
		$("#modify_writer").val("");
		$("#modify_content").val("");
		$("#modify_message").html("&nbsp;");
	}
	
	//[댓글삭제]를 클릭한 경우 호출되는 이벤트 핸들러 함수
	function removeComment(num) {
		$("#comment_modify").hide().appendTo(document.documentElement);
		$("#comment_remove").show().appendTo("#comment_"+num);
	}

	//[삭제]를 클릭한 경우 호출될 이벤트 핸들러 함수 등록
	// => 댓글번호를 전달받아 댓글을 삭제하는 JSP 문서를 요청하여 응답결과를 제공받아 처리
	$("#remove_btn").click(function() {
		var num=$("#comment_remove").parent().attr("num");
	
		$.ajax({
			type: "POST",
			url: "comment_remove.jsp",
			data: {"num":num},
			dataType: "xml",
			success: function(xmlDoc) {
				var code=$(xmlDoc).find("code").text();

				if(code=="success") {
					$("#comment_remove").hide().appendTo(document.documentElement);
					loadComment();
				}
			},
			error: function(xhr) {
				alert("에러코드 = "+xhr.status);
			}
		});
	});

	//삭제에 대한 [취소]를 클릭한 경우 호출될 이벤트 핸들러 함수 등록
	$("#remove_cancel_btn").click(function() {
		$("#comment_remove").hide().appendTo(document.documentElement);
	});
	</script>
</body>
</html>
