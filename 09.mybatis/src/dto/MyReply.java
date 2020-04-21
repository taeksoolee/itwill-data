package site.itwill.dto;

/*
MYREPLY ���̺� : �Խñۿ� ���� ��������� �����ϱ� ���� ���̺� 
	- ��۹�ȣ,��� �ۼ��� ���̵�, ��� ����, ��� �ۼ�����, �Խñ۹�ȣ

�̸�               ��?       ����            
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




