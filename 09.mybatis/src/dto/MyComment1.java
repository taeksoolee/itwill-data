package site.itwill.dto;

/*
MYCOMMENT ���̺� : �Խñ��� �����ϱ� ���� ���̺� - �۹�ȣ, �ۼ��� ���̵�, �۳���, �ۼ�����

�̸�              ��?       ����            
--------------- -------- ------------- 
COMMENT_NO      NOT NULL NUMBER        
COMMENT_ID               VARCHAR2(20)
COMMENT_CONTENT          VARCHAR2(100) 
COMMENT_DATE             DATE       
*/

//���̺��� ����� ǥ������� �ۼ��� �÷����� ī�� ǥ����� �ʵ������ �����Ͽ� �ۼ�
// => �˻����� �÷����� �ʵ忡 �ڵ� ���εǾ� ����
public class MyComment1 {
	private int commentNo;
	private String commentId;
	private String commentContent;
	private String commentDate;
	
	public MyComment1() {
		// TODO Auto-generated constructor stub
	}

	public int getCommentNo() {
		return commentNo;
	}

	public void setCommentNo(int commentNo) {
		this.commentNo = commentNo;
	}

	public String getCommentId() {
		return commentId;
	}

	public void setCommentId(String commentId) {
		this.commentId = commentId;
	}

	public String getCommentContent() {
		return commentContent;
	}

	public void setCommentContent(String commentContent) {
		this.commentContent = commentContent;
	}

	public String getCommentDate() {
		return commentDate;
	}

	public void setCommentDate(String commentDate) {
		this.commentDate = commentDate;
	}
}





