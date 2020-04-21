package site.itwill.student;

//DTO(Data Transfer Object) Ŭ���� : DAO Ŭ������ �޼ҵ忡�� �������� 
//���� �ްų� ��ȯ�ϱ� ���� ������ Ŭ���� - VO Ŭ����
// => ���̺��� �÷��� 1:1�� ��Ī�Ǵ� �ʵ� ���� - Getter & Setter
// => �ʵ���� ���̺��� �÷���� �����ϰ� �ۼ��ϴ� ���� ����

//STUDENT ���̺��� ������(�л�����)�� �����Ͽ� �����ϱ� ���� Ŭ����
/*
�̸�       ��?       ����           
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

















