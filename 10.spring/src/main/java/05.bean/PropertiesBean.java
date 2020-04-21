package site.itwill04.bean;

public class PropertiesBean {
	private String name;
	private String phone;
	private String email;
	
	public PropertiesBean() {
		System.out.println("### PropertiesBean 클래스의 기본 생성자 호출 ###");
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
		return "이름 = "+name+", 전화번호 = "+phone+", 이메일 = "+email;
	}
}




