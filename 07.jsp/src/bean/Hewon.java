package site.itwill.bean;

//ȸ�������� �����ϱ� ���� Ŭ����
// => VO Ŭ����, DTO Ŭ����, JavaBean Ŭ����
//JavaBean : �����ø����̼ǿ��� ����ϱ� ���� Ŭ���� - ���ް��� �ʵ忡 ����
public class Hewon {
	//�Է��±��� name �Ӽ����� ������ �̸����� �ʵ� �ۼ�
	private String name;
	private String phone;
	private String address;
	
	public Hewon() {
		// TODO Auto-generated constructor stub
	}

	//�ʵ���� �̿��Ͽ� Setter�� Getter �޼ҵ� �ۼ�
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
}
