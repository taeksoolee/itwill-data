package site.itwill10.dto;

/*
�̸�      ��?       ����           
------- -------- ------------ 
NUM     NOT NULL NUMBER       
WRITER           VARCHAR2(20) 
SUBJECT          VARCHAR2(50)
*/ 

//POINTBOARD ���̺��� �Խñ� ������ �����ϱ� ���� Ŭ���� 
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
