package site.itwill04.bean;

public class PropertiesBean {
	private String name;
	private String phone;
	private String email;
	
	public PropertiesBean() {
		System.out.println("### PropertiesBean Ŭ������ �⺻ ������ ȣ�� ###");
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	@Override
	public String toString() {
		return "�̸� = "+name+", ��ȭ��ȣ = "+phone+", �̸��� = "+email;
	}
}




