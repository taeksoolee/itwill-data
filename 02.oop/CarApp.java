package oop;

//Car Ŭ������ �̿��� ���α׷� �ۼ�
public class CarApp {
	public static void main(String[] args) {
		//Ŭ������ �̿��Ͽ� �ν��Ͻ� ���� �� ���������� ����
		// => ������ �ν��Ͻ��� �ʵ忡�� �⺻���� �ڵ����� ����
		// => �ʵ� �⺻�� : ������(0), ����(false), ������(null)
		Car tico=new Car();
		Car sonata=new Car();
		
		//���������� ����� �ν��Ͻ��� ����� ��� "Ŭ�����̸�@�޸��ּ�" ���·� ���
		System.out.println("tico = "+tico);
		System.out.println("sonata = "+sonata);
		System.out.println("============================================");
		//���������� ����� �ν��Ͻ��� �̿��Ͽ� �ʵ� �Ǵ� �޼ҵ� ���� ����
		//����)�ν��Ͻ��� �̿��Ͽ� �ʵ忡 �����Ͽ� ����� ��� ���������� �� ���忡 ���� ���� ���� �߻�
		//�ذ�)�ν��Ͻ��� �̿��Ͽ� �ʵ忡 �������� ���ϵ��� ����ȭ ó��
		// => ����ȭ ó���� �ʵ忡 ������ ��� ���� �߻�
		// => Getter �޼ҵ� �Ǵ� Setter �޼ҵ带 ȣ���Ͽ� ����
		//tico.modelName="Ƽ��";
		tico.setModelName("Ƽ��");
		//tico.engineStatus=false;
		tico.setEngineStatus(false);
		//tico.currentSpeed=0;
		tico.setCurrentSpeed(0);
		
		//System.out.println("���̸� = "+tico.modelName);
		System.out.println("���̸� = "+tico.getModelName());
		//System.out.println("�������� = "+tico.engineStatus);
		System.out.println("�������� = "+tico.isEngineStatus());
		//System.out.println("����ӵ� = "+tico.currentSpeed);
		System.out.println("����ӵ� = "+tico.getCurrentSpeed());
		System.out.println("============================================");
		sonata.setModelName("�Ÿ");
		
		System.out.println("���̸� = "+sonata.getModelName());
		System.out.println("�������� = "+sonata.isEngineStatus());
		System.out.println("����ӵ� = "+sonata.getCurrentSpeed());
		System.out.println("============================================");
		tico.startEngine();
		tico.speedUp(30);
		tico.speedUp(50);
		tico.speedDown(20);
		tico.speedZero();
		tico.stopEngine();
		System.out.println("============================================");
	}
}






