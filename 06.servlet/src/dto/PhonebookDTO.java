package site.itwill.dto;

//DTO(Data Transfer Object) : �������� �����Ͽ� �����ϱ� ���� Ŭ����

/*
�̸�      ��?       ����           
------- -------- ------------ 
PHONE   NOT NULL VARCHAR2(20) 
NAME             VARCHAR2(20) 
ADDRESS          VARCHAR2(50)
*/

//PHONEBOOK ���̺��� �������� �����ϱ� ���� Ŭ����
public class PhonebookDTO {
	private String phone; 
	private String name; 
	private String address;
	
	public PhonebookDTO() {
		// TODO Auto-generated constructor stub
	}

	//����Ű : Alt+Shift+S >> R >> �ʵ� ���� >> Generate
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









