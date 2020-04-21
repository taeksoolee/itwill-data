package site.itwill10.dto;

import org.springframework.web.multipart.MultipartFile;

/*
이름      널?       유형            
------- -------- ------------- 
NUM     NOT NULL NUMBER        
WRITER           VARCHAR2(20)  
SUBJECT          VARCHAR2(100) 
ORIGIN           VARCHAR2(100) 
UPLOAD           VARCHAR2(100) 
*/

public class FileBoard {
	private int num;
	private String writer;
	private String subject;
	private String origin;
	private String upload;
	//입력파일을 저장하기 위한 필드
	private MultipartFile file;
	
	public FileBoard() {
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

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public String getUpload() {
		return upload;
	}

	public void setUpload(String upload) {
		this.upload = upload;
	}

	public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	}
}
