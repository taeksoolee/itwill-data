package site.itwill10.dto;

/*
이름      널?       유형           
------- -------- ------------ 
NUM     NOT NULL NUMBER       
WRITER           VARCHAR2(20) 
SUBJECT          VARCHAR2(50)
*/ 

//POINTBOARD 테이블의 게시글 정보를 저장하기 위한 클래스 
public class PointBoard {
	private int num;
	private String writer;
	private String subject;
	
	public PointBoard() {
		// TODO Auto-generated constructor stub
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}
	
	
}
