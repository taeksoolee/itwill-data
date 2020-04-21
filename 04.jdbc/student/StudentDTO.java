package site.itwill.student;

//DTO(Data Transfer Object) 클래스 : DAO 클래스의 메소드에서 행정보를 
//전달 받거나 반환하기 위한 목적의 클래스 - VO 클래스
// => 테이블의 컬럼과 1:1로 매칭되는 필드 선언 - Getter & Setter
// => 필드명은 테이블의 컬럼명과 동일하게 작성하는 것을 권장

//STUDENT 테이블의 행정보(학생정보)를 저장하여 전달하기 위한 클래스
/*
이름       널?       유형           
-------- -------- ------------ 
NO       NOT NULL NUMBER(4)    
NAME              VARCHAR2(20) 
PHONE             VARCHAR2(15) 
ADDRESS           VARCHAR2(50) 
BIRTHDAY          DATE   
*/
public class StudentDTO {
	private int no;
	private String name;
	private String phone;
	private String address;
	private String birthday;
	
	public StudentDTO() {
		// TODO Auto-generated constructor stub
	}

	public StudentDTO(int no, String name, String phone, String address, String birthday) {
		super();
		this.no = no;
		this.name = name;
		this.phone = phone;
		this.address = address;
		this.birthday = birthday;
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

















