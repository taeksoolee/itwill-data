package enumerate;

public class EnumApp {
	public static void main(String[] args) {
		//����ʵ� ��� - �ʵ�� ���
		// => �ʵ尪 ��� �ǹ� �ִ� ���ڿ��� ǥ��
		System.out.println("���� = "+EnumOne.INSERT);
		System.out.println("���� = "+EnumOne.UPDATE);
		System.out.println("���� = "+EnumOne.DELETE);
		System.out.println("�˻� = "+EnumOne.SELECT);
		System.out.println("============================================");
		System.out.println("���� = "+EnumTwo.ADD);
		System.out.println("���� = "+EnumTwo.MODIFY);
		System.out.println("���� = "+EnumTwo.ERASE);
		System.out.println("�˻� = "+EnumTwo.SEARCH);
		System.out.println("============================================");
		//����ʵ尪�� ���� �ڷ����� ������ ���� �Ұ���
		// => ����ʵ尡 ����� Enum �ڷ������� ������ ���������� ����ʵ尪 ���� ����
		// => ����ʵ带 ��ǥ������ ǥ�� ����
		//int choice=EnumOne.INSERT;
		
		EnumOne choice=EnumOne.INSERT;
		//�ٸ� Enum �ڷ����� ����� ����ʵ尪 ���� �Ұ���
		//EnumOne choice=EnumTwo.ADD;
		System.out.println("============================================");
		//switch ������ ������ ������ Enum �ڷ����� ����ʵ常 case �������� ǥ�� ����
		// => ����ʵ尡 ����� Enum �ڷ����� �ǹ� �ο�
		switch (choice) {
		//case ������ ����ʵ带 ������ ��� Enum �ڷ��� ����
		case INSERT:
			System.out.println("# �л������� �����մϴ�.");
			break;
		case UPDATE:
			System.out.println("# �л������� �����մϴ�.");
			break;
		case DELETE:
			System.out.println("# �л������� �����մϴ�.");
			break;
		case SELECT:
			System.out.println("# �л������� �˻��մϴ�.");
			break;
		}
		System.out.println("============================================");
	}
}







