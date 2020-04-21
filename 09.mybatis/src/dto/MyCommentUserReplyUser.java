package site.itwill.dto;

import java.util.List;

//MYCOMMENT 테이블과 MYUSER 테이블, MYREPLY 테이블의 검색결과를 저장하기 위한 클래스
public class MyCommentUserReplyUser {
	//게시글번호를 저장하기 위한 필드
	private String commentNo;
	
	//MYCOMMENT 테이블의 검색결과를 저장하기 위한 필드 - 포함관계
	private MyComment1 comment;

	//MYUSER 테이블의 검색결과를 저장하기 위한 필드 - 포함관계
	private MyUser user;
	
	//게시글에 대한 댓글목록을 저장하기 위한 필드 - 포함관계
	// => 콜렉션 필드의 요소에는 댓글정보와 회원정보를 저장할 수 있는 클래스 사용
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





