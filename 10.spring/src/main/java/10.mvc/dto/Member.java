package site.itwill10.dto;

//JavaBean Ŭ���� : �Է����������� �Էµ� ���� ���޹޾� �����ϱ� ���� Ŭ����
// => DAO Ŭ�������� ���� ��� DTO Ŭ������ ��Ȱ ����
//�Է��±��� name �Ӽ����� ������ �̸��� �ʵ� ����
// => �Է��±��� �Է°��� ���� �̸��� �ʵ忡 �ڵ� ���� - Setter �޼ҵ� ȣ��
public class Member {
	private String id;
	private String passwd;
	private String name;
	private String email;
	private String phone1;
	private String phone2;
	private String phone3;
	
	public Member() {
		// TODO Auto-generated constructor stub
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone1() {
		return phone1;
	}

	public void setPhone1(String phone1) {
		this.phone1 = phone1;
	}

	public String getPhone2() {
		return phone2;
	}

	public void setPhone2(String phone2) {
		this.phone2 = phone2;
	}

	public String getPhone3() {
		return phone3;
	}

	public void setPhone3(String phone3) {
		this.phone3 = phone3;
	}
}
