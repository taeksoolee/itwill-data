package site.itwill.dto;

import java.util.List;

//MYCOMMENT ���̺�� MYUSER ���̺�, MYREPLY ���̺��� �˻������ �����ϱ� ���� Ŭ����
public class MyCommentUserReplyUser {
	//�Խñ۹�ȣ�� �����ϱ� ���� �ʵ�
	private String commentNo;
	
	//MYCOMMENT ���̺��� �˻������ �����ϱ� ���� �ʵ� - ���԰���
	private MyComment1 comment;

	//MYUSER ���̺��� �˻������ �����ϱ� ���� �ʵ� - ���԰���
	private MyUser user;
	
	//�Խñۿ� ���� ��۸���� �����ϱ� ���� �ʵ� - ���԰���
	// => �ݷ��� �ʵ��� ��ҿ��� ��������� ȸ�������� ������ �� �ִ� Ŭ���� ���
	private List<MyReplyUser> replies;
	
	public MyCommentUserReplyUser() {
		// TODO Auto-generated constructor stub
	}
	
	public String getCommentNo() {
		return commentNo;
	}

	public void setCommentNo(String commentNo) {
		this.commentNo = commentNo;
	}

	public MyComment1 getComment() {
		return comment;
	}

	public void setComment(MyComment1 comment) {
		this.comment = comment;
	}

	public MyUser getUser() {
		return user;
	}

	public void setUser(MyUser user) {
		this.user = user;
	}

	public List<MyReplyUser> getReplies() {
		return replies;
	}

	public void setReplies(List<MyReplyUser> replies) {
		this.replies = replies;
	}
}





