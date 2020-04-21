package site.itwill.dto;

/*
이름         널?       유형            
---------- -------- ------------- 
NUM        NOT NULL NUMBER        
WRITER              VARCHAR2(50)  
CONTENT             VARCHAR2(500) 
WRITE_DATE          DATE 
*/

public class AjaxCommentDTO {
	private int num;
	private String writer;
	private String content;
	private String writeDate;
	
	public AjaxCommentDTO() {
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

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getWriteDate() {
		return writeDate;
	}

	public void setWriteDate(String writeDate) {
		this.writeDate = writeDate;
	}
}
