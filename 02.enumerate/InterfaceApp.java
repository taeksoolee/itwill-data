package enumerate;

//Ŭ����(�������̽�)���� ����ʵ带 ������ ��� ���� - ������(EnumType) �̿�
// => �ǹ��ִ� ���ڿ��� ǥ���� �� ������ ���� ��ǥ������ ǥ���ϱ� ������
// => ����ʵ尡 ����� Ŭ����(�������̽�) ���ǹ�
public class InterfaceApp {
	public static void main(String[] args) {
		//����ʵ� ��� => �ʵ尪 ���
		System.out.println("���� = "+InterfaceOne.INSERT);
		System.out.println("���� = "+InterfaceOne.UPDATE);
		System.out.println("���� = "+InterfaceOne.DELETE);
		System.out.println("�˻� = "+InterfaceOne.SELECT);
		System.out.println("============================================");
		System.out.println("���� = "+InterfaceTwo.ADD);
		System.out.println("���� = "+InterfaceTwo.MODIFY);
		System.out.println("���� = "+InterfaceTwo.ERASE);
		System.out.println("�˻� = "+InterfaceTwo.SEARCH);
		System.out.println("============================================");
		//����ʵ�� ������ �ڷ����� ������ �ʵ尪 ���� ����
		//int choice=InterfaceOne.INSERT;
		int choice=InterfaceTwo.ADD;
		
		System.out.println("���� = "+choice);
		System.out.println("============================================");
		switch (choice) {
		//case ������ �� ��� ����ʵ� ��� ����
		case InterfaceOne.INSERT:
			System.out.println("# �л������� �����մϴ�.");
			break;
		case InterfaceOne.UPDATE:
			System.out.println("# �л������� �����մϴ�.");
			break;
		case InterfaceOne.DELETE:
			System.out.println("# �л������� �����մϴ�.");
			break;
		case InterfaceOne.SELECT:
			System.out.println("# �л������� �˻��մϴ�.");
			break;
		}
		System.out.println("============================================");
	}
}
