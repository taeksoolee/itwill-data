package inheritance;

//�п��������(��ȣ, �̸�)�� �����ϱ� ���� Ŭ����
// => �п� �����ڿ��� �������� �Ӽ��� ����� �����ϱ� ���� Ŭ����
// => �ڵ��� �ߺ����� �ּ�ȭ �Ͽ� ���α׷��� ���꼺 �� ���������� ȿ���� ����
// => �п� �����ڿ� ���� Ŭ������ �ݵ�� ��� �޾ƾ� �Ǵ� Ŭ����
public class AcademyPerson {
	private int number;
	private String name;
	
	public AcademyPerson() {
		// TODO Auto-generated constructor stub
	}

	public AcademyPerson(int number, String name) {
		super();
		this.number = number;
		this.name = name;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void display() {
		System.out.println("��ȣ = "+number);
		System.out.println("�̸� = "+name);
	}
}






