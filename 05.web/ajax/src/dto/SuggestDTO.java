package site.itwill.dto;

/*
�̸�      ��?       ����            
------- -------- ------------- 
WORD    NOT NULL VARCHAR2(50)  
ADDRESS          VARCHAR2(100) 
*/

public class SuggestDTO {
	private String word;
	private String address;
	
	public SuggestDTO() {
		// TODO Auto-generated constructor stub
	}

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
}
