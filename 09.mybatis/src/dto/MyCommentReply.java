package site.itwill.dto;

import java.util.List;

//MYCOMMENT 테이블과 MYREPLY 테이블의 조인 검색결과를 저장하기 위한 클래스
// => 1:N 관계의 조인결과 저장
public class MyCommentReply {
	//MYCOMMENT 테이블의 검색결과를 저장하기 위한 필드
	private int commentNo;
	private String commentId;
	private String commentContent;
	private String commentDate;
	
	//MYREPLY 테이블의 검색결과를 저장하기 위한 필드
	// => 게시글에 댓글 목록을 List 인스턴스에 저장
	private List<MyReply> replies;
	
	public MyCommentReply() {
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

	public List<MyReply> getReplies() {
		return replies;
	}

	public void setReplies(List<MyReply> replies) {
		this.replies = replies;
	}
}







