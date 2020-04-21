package site.itwill05.di;

//�л������� �����ϱ� ���� Ŭ���� : VO Ŭ����, DTO Ŭ����, JavaBean Ŭ����
public class Student {
	private int num;
	private String name;
	private String email;
	
	public Student() {
		System.out.println("### Student Ŭ������ �⺻ ������ ȣ�� ###");
	}

	public Student(int num) {
		super();
		this.num = num;
		System.out.println("### Student Ŭ������ �Ű�����(�й�)�� ����� ������ ȣ�� ###");
	}

	public Student(int num, String name) {
		super();
		this.num = num;
		this.name = name;
		System.out.println("### Student Ŭ������ �Ű�����(�й�,�̸�)�� ����� ������ ȣ�� ###");
	}

	public Student(int num, String name, String email) {
		super();
		this.num = num;
		this.name = name;
		this.email = email;
		System.out.println("### Student Ŭ������ �Ű�����(�й�,�̸�,�̸���)�� ����� ������ ȣ�� ###");
	}
		
	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
		System.out.println("*** Student Ŭ������ setNum(int num) �޼ҵ� ȣ�� ###");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
		System.out.println("*** Student Ŭ������ setName(String name) �޼ҵ� ȣ�� ###");
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
		System.out.println("*** Student Ŭ������ setEmail(String email) �޼ҵ� ȣ�� ###");
	}
	
	@Override
	public String toString() {
		return "�й� = "+num+", �̸� = "+name+", �̸��� = "+email;
	}
}




