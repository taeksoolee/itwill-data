package site.itwill.dto;

//MYCOMMENT ���̺�� MYUSER ���̺��� �˻������ �����ϱ� ���� Ŭ����
// => 1:1 ������ ���� ����� �����ϱ� ���� Ŭ����
public class MyCommentUser1 {
	//�˻����� �Խñ�����(MYCOMMENT ���̺�)�� �����ϱ� ���� �ʵ�
	private int commentNo;
	private String commentId;
	private String commentContent;
	private String commentDate;
	
	//�˻����� ȸ������(MYUSER ���̺�)�� �����ϱ� ���� �ʵ�
	private String userId;
	private String userName;
	
	public MyCommentUser1() {
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

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
}





