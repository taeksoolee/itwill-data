package site.itwill.dto;

//DTO(Data Transfer Object) : 행정보를 저장하여 전달하기 위한 클래스

/*
이름      널?       유형           
------- -------- ------------ 
PHONE   NOT NULL VARCHAR2(20) 
NAME             VARCHAR2(20) 
ADDRESS          VARCHAR2(50)
*/

//PHONEBOOK 테이블의 행정보를 저장하기 위한 클래스
public class PhonebookDTO {
	private String phone; 
	private String name; 
	private String address;
	
	public PhonebookDTO() {
		// TODO Auto-generated constructor stub
	}

	//단축키 : Alt+Shift+S >> R >> 필드 선택 >> Generate
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
}









