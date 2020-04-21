package site.itwill10.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

//�Է°��� ����Ǵ� �ʵ忡 ��ȿ�� �˻� ���� ������̼��� ����Ͽ� ó��
public class Hewon {
	//@NotEmpty : �Է°� ���縦 �˻��ϴ� ������̼�
	// => ���� �߻��� ������̼��� �����ϴ� �⺻ �޼��� ����
	// => message �Ӽ��� �̿��Ͽ� ���� �޼��� ���� ����
	@NotEmpty(message = "���̵� �ݵ�� �Է��� �ּ���.")
	//@Size : �Է°� ���̸� �˻��ϴ� ������̼�
	// => min �Ӽ����� �ּ� ����, max �Ӽ����� �ִ� ���� ���� ����
	//@Size(min = 6, max = 20, message = "���̵�� �ּ� 6�� �̻� �ִ� 20�� ���Ϸθ� �Է� �����մϴ�.")
	//@Pattern : �Է°� ���̸� �˻��ϴ� ������̼�
	@Pattern(regexp = "^[a-zA-Z]\\w{5,19}$", message = "���̵� ���Ŀ� �°� �Է��� �ּ���.")
	private String id;
	@Pattern(regexp = "^(?=.*[a-zA-Z])(?=.*[0-9])(?=.*[~!@#$%^&*_-]).{6,20}$", message = "��й�ȣ�� ���Ŀ� �°� �Է��� �ּ���.")
	private String passwd;
	@Pattern(regexp = "^[��-�R]{2,10}$", message = "�̸��� ���Ŀ� �°� �Է��� �ּ���.")
	private String name;
	@NotEmpty(message = "�̸����� �ݵ�� ������ �ּ���.")
	//@Email : �̸��� �Է°��� �˻��ϴ� ������̼�
	@Email(message = "�̸����� ���Ŀ� �°� �Է��� �ּ���.")
	private String email;
	@NotEmpty(message = "������ �ݵ�� ������ �ּ���.")
	private String gender;
	
	public Hewon() {
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

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
}
