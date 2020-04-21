package site.itwill.dto;

/*
MYREPLY 테이블 : 게시글에 대한 댓글정보를 저장하기 위한 테이블 
	- 댓글번호,댓글 작성자 아이디, 댓글 내용, 댓글 작성일자, 게시글번호

이름               널?       유형            
---------------- -------- ------------- 
REPLY_NO         NOT NULL NUMBER        
REPLY_ID                  VARCHAR2(20)  
REPLY_CONTENT             VARCHAR2(100) 
REPLY_DATE                DATE          
REPLY_COMMENT_NO          NUMBER   
*/

public class MyReply {
	private int replyNo;
	private String replyId;
	private String replyContent;
	private String replyDate;
	private int replyCommentNo;
	
	public MyReply() {
		// TODO Auto-generated constructor stub
	}

	public int getReplyNo() {
		return replyNo;
	}

	public void setReplyNo(int replyNo) {
		this.replyNo = replyNo;
	}

	public String getReplyId() {
		return replyId;
	}

	public void setReplyId(String replyId) {
		this.replyId = replyId;
	}

	public String getReplyContent() {
		return replyContent;
	}

	public void setReplyContent(String replyContent) {
		this.replyContent = replyContent;
	}

	public String getReplyDate() {
		return replyDate;
	}

	public void setReplyDate(String replyDate) {
		this.replyDate = replyDate;
	}

	public int getReplyCommentNo() {
		return replyCommentNo;
	}

	public void setReplyCommentNo(int replyCommentNo) {
		this.replyCommentNo = replyCommentNo;
	}
}




