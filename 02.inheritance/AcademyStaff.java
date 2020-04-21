package inheritance;

//�п� ��������(������ȣ, �����̸�, �ٹ��μ�)�� �����ϱ� ���� Ŭ����
public class AcademyStaff extends AcademyPerson {
	private String depart;
	
	public AcademyStaff() {
		// TODO Auto-generated constructor stub
	}

	public AcademyStaff(int number, String name, String depart) {
		super(number, name);
		this.depart = depart;
	}

	public String getDepart() {
		return depart;
	}

	public void setDepart(String depart) {
		this.depart = depart;
	}
	
	@Override
	public void display() {
		System.out.println("������ȣ = "+getNumber());
		System.out.println("�����̸� = "+getName());
		System.out.println("�ٹ��μ� = "+depart);
	}
}
