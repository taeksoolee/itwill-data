package inheritance;

//�п� �����ڿ�(�л�, ����, ����) ���� ���α׷�
public class AcademyApp {
	/*
	public static void processStudent(AcademyStudent student) {
		//�п��л������� ���޹޾� ó���ϴ� �޼ҵ�
	}
	
	public static void processInstructor(AcademyInstructor instructor) {
		//�п����������� ���޹޾� ó���ϴ� �޼ҵ�
	}
	
	public static void processStaff(AcademyStaff staff) {
		//�п����������� ���޹޾� ó���ϴ� �޼ҵ�
	}
	*/
	
	/*
	//�޼ҵ� �����ε� : �޼ҵ���� ������ �Ű������� �ٸ��� ����
	public static void process(AcademyStudent student) {
		//�п��л������� ���޹޾� ó���ϴ� �޼ҵ�
	}
	
	public static void process(AcademyInstructor instructor) {
		//�п����������� ���޹޾� ó���ϴ� �޼ҵ�
	}
	
	public static void process(AcademyStaff staff) {
		//�п����������� ���޹޾� ó���ϴ� �޼ҵ�
	}
	*/
	
	public static void process(AcademyPerson person) {
		//�п� �����ڿ�����(�л�, ����, ����)�� ���޹޾� ó���ϴ� �޼ҵ�
	}
	
	public static void main(String[] args) {
		/*
		//�п��л������� �����ϱ� ���� �迭 ����
		AcademyStudent[] students=new AcademyStudent[300];
		//�п����������� �����ϱ� ���� �迭 ����
		AcademyInstructor[] instructors=new AcademyInstructor[50];
		//�п����������� �����ϱ� ���� �迭 ����
		AcademyStaff[] staffs=new AcademyStaff[100];
		*/
		
		//�п� �����ڿ�����(�л�, ����, ����)�� �����ϱ� ���� �迭 ����
		AcademyPerson[] persons=new AcademyPerson[5];
		
		//�θ� ������ҿ� �ڽ� �ν��Ͻ�(�θ� �ν��Ͻ�)�� �����Ͽ� ����
		persons[0]=new AcademyStudent(1000, "ȫ�浿", "�� ������ ����");
		persons[1]=new AcademyInstructor(2000, "�Ӳ���", "JSP ����");
		persons[2]=new AcademyStaff(3000, "����ġ", "����������");
		persons[3]=new AcademyStudent(4000, "������", "�� ������ ����");
		persons[4]=new AcademyInstructor(5000, "����", "HTML ����");
		
		for(AcademyPerson person:persons) {
			//����� ��ü ����ȯ�� ���� �θ� ���������� ���� ������ �ڽ� �ν��Ͻ��� �ݵ�� ����
			// => ��� ���踦 Ȯ���ϱ� ���� instanceof ������ �̿�
			//����) �������� instanceof �ڽ�Ŭ����
			// => ���������� ����� �� �ִ� �ڽ�Ŭ������ �ν��Ͻ��� ��� true �����ϴ� ������
			if(person instanceof AcademyStudent) {
				//����� ��ü ����ȯ�� �̿��Ͽ� �ڽ� �ν��Ͻ��� �޼ҵ� ȣ��
				// => ����� ��ü ����ȯ�� �߸��� ��� ClassCaseException �߻�
				System.out.println(((AcademyStudent)person).getCourse()+"�� �л����� >> ");
			} else if(person instanceof AcademyInstructor) {
				System.out.println(((AcademyInstructor)person).getSubject()+"�� �������� >> ");
			} else if(person instanceof AcademyStaff) {
				System.out.println(((AcademyStaff)person).getDepart()+"�� �������� >> ");
			}
			
			//�޼ҵ� �������̵� ���� ���� ������ ��ü ����ȯ�� �߻��Ǿ�
			//�θ� �ν��Ͻ��� �޼ҵ� ��� �ڽ� �ν��Ͻ��� �޼ҵ� ȣ��
			//������ ��ü ����ȯ�� ���� ���������� ����� �ڽ� �ν��Ͻ���
			//���� �������̵� �޼ҵ� ȣ��
			// => �޼ҵ� �������̵忡 ���� ������ ����
			person.display();
			System.out.println("========================================");
		}
		
		/*
		//���� Ŭ������ ���� �޼ҵ�� Ŭ������ �����Ͽ� ȣ�� ����
		AcademyApp.processStudent(new AcademyStudent());
		processInstructor(new AcademyInstructor());
		processStaff(new AcademyStaff());
		//�Ű������� �߸��� ��(�ν��Ͻ�)�� ������ ��� ���� �߻�
		processStudent(new AcademyInstructor());
		*/
		
		/*
		//���޵� ��(�ν��Ͻ�)�� ���� �ٸ� �޼ҵ� ȣ�� - �����ε忡 ���� ������
		process(new AcademyStudent());
		process(new AcademyInstructor());
		process(new AcademyStaff());
		*/
		
		//�Ű�����(�θ� ��������)�� ��� �ڽ� �ν��Ͻ�(�θ� �ν��Ͻ�) ���� ����
		process(new AcademyStudent());
		process(new AcademyInstructor());
		process(new AcademyStaff());
	}
}








