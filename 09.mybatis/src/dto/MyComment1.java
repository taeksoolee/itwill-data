package site.itwill.dto;

/*
MYCOMMENT 테이블 : 게시글을 저장하기 위한 테이블 - 글번호, 작성자 아이디, 글내용, 작성일자

이름              널?       유형            
--------------- -------- ------------- 
COMMENT_NO      NOT NULL NUMBER        
COMMENT_ID               VARCHAR2(20)
COMMENT_CONTENT          VARCHAR2(100) 
COMMENT_DATE             DATE       
*/

//테이블의 언더바 표기법으로 작성된 컬럼명을 카멜 표기법의 필드명으로 변형하여 작성
// => 검색행의 컬럼값이 필드에 자동 매핑되어 저장
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





