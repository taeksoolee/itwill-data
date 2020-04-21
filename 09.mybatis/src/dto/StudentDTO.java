package site.itwill.dto;

/*
이름       널?       유형           
-------- -------- ------------ 
NO       NOT NULL NUMBER(4)    
NAME              VARCHAR2(20) 
PHONE             VARCHAR2(15) 
ADDRESS           VARCHAR2(50) 
BIRTHDAY          DATE    
*/

//테이블의 컬럼명과 동일한 이름의 필드명으로 작성하는 것을 권장
// => 검색행의 컬럼값이 동일한 이름의 필드에 자동 매핑되어 검색값 저장
public class StudentDTO {
	private int no;
	private String name;
	private String phone;
	private String address;
	private String birthday;
	
	public StudentDTO() {
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

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
}