package site.itwill.dto;

//MYREPLY ���̺�� MYUSER ���̺��� �˻������ �����ϱ� ���� Ŭ����
// => 1:1 ������ ���� ����� �����ϱ� ���� Ŭ���� - ���԰���
public class MyReplyUser {
	private MyReply reply;
	private MyUser user;
	
	public MyReplyUser() {
		// TODO Auto-generated constructor stub
	}

	public MyReply getReply() {
		return reply;
	}

	public void setReply(MyReply reply) {
		this.reply = reply;
	}

	public MyUser getUser() {
		return user;
	}

	public void setUser(MyUser user) {
		this.user = user;
	}
}
