package inheritance;

//�п� �л�����(�л���ȣ, �л��̸�, ��������)�� �����ϱ� ���� Ŭ����
// => �л���ȣ�� �л��̸� ���� �Ӽ��� ����� AcademyPerson Ŭ������ ��ӹ޾� ���
public class AcademyStudent extends AcademyPerson {
	private String course;
	
	public AcademyStudent() {
		// TODO Auto-generated constructor stub
	}

	public AcademyStudent(int number, String name, String course) {
		super(number, name);
		this.course = course;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}
	
	@Override
	public void display() {
		System.out.println("�л���ȣ = "+getNumber());
		System.out.println("�л��̸� = "+getName());
		System.out.println("�������� = "+course);
	}
}







