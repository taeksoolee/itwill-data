package site.itwill.dto;

//MYREPLY 테이블과 MYUSER 테이블의 검색결과를 저장하기 위한 클래스
// => 1:1 관계의 조인 결과를 저장하기 위한 클래스 - 포함관계
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
