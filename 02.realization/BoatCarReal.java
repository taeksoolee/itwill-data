package realization;

//Ŭ������ �������̽��� ��� ���� ��� implements Ű���� �̿� 
//��� ���� �������̽��� ��� �߻�޼ҵ带 �ݵ�� �������̵� ����
public class BoatCarReal implements BoatCar {
	@Override
	public void run() {
		System.out.println("�� ���� �޸��� �ɷ�");
	}

	@Override
	public void navigate() {
		System.out.println("�� ���� �����ϴ� �ɷ�");
	}

	@Override
	public void floating() {
		System.out.println("���߿� �������� �ɷ�");
	}
	
}
