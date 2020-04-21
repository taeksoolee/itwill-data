package site.itwill.bean;

//회원정보를 저장하기 위한 클래스
// => VO 클래스, DTO 클래스, JavaBean 클래스
//JavaBean : 웹어플리케이션에서 사용하기 위한 클래스 - 전달값을 필드에 저장
public class Hewon {
	//입력태그의 name 속성값과 동일한 이름으로 필드 작성
	private String name;
	private String phone;
	private String address;
	
	public Hewon() {
		// TODO Auto-generated constructor stub
	}

	//필드명을 이용하여 Setter와 Getter 메소드 작성
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
