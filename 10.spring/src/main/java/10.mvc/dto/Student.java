package site.itwill10.dto;

public class Student {
	private int no;
	private String name;
	private String phone;
	private String address;
	private String birthday;
	
	public Student() {
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
	
	//�׽�Ʈ �޼ҵ忡�� �˻����� �ʵ尪�� Ȯ���ϱ� ���� �޼ҵ� ���� 
	@Override
	public String toString() {
		return no+", "+name+", "+phone+", "+address+", "+birthday.substring(0, 10);
	}
}







