package site.itwill.dto;

/*
이름      널?       유형             
------- -------- -------------- 
NO      NOT NULL NUMBER(10)     
NAME             VARCHAR2(40)   
REGDATE          DATE           
TITLE            VARCHAR2(100)  
CONTENT          VARCHAR2(4000) 
*/

public class GuestDTO {
	private int no;
	private String name;
	private String regdate;
	private String title;
	private String content;
	
	public GuestDTO() {
		// TODO Auto-generated constructor stub
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRegdate() {
		return regdate;
	}

	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
}
