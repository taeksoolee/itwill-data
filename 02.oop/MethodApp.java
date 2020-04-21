package oop;

//���� ������ Ŭ���� - ���ø����̼�(Application)
// => main() �޼ҵ� ����
public class MethodApp {
	public static void main(String[] args) {
		//Ŭ������ �������� : ��ü������ �����ϱ� ���� �������� ����
		//new Ŭ������() : new �����ڷ� ������(Constructor)�� ȣ���Ͽ� ��ü ����
		
		//���� ��Ű���� Ŭ������ ��Ű�� ǥ������ ���� ����
		//��ü�� �����Ͽ� ��ü������ ���������� ����
		// => ���������� �̿��Ͽ� ��ü���(�ʵ� �Ǵ� �޼ҵ�) ���� ���� - . ������
		Method method=new Method();
		
		//�޼ҵ� ȣ��(invoke) : �޼ҵ忡 ����� ��� ����
		// => �޼ҵ��� ���ް��� ���� �޼ҵ� ȣ�� - ���ް��� �߸��� ��� �޼ҵ� ȣ�� �Ұ�
		method.displayOne();
		method.displayTwo();
		method.displayOne();
		System.out.println("============================================");
		method.printTotOne();
		method.printTotOne();
		
		//�޼ҵ��� �Ű�����(Parameter)�� ���� �����Ͽ� �޼ҵ� ȣ��
		method.printTotTwo(50);
		method.printTotTwo(75);
		
		method.printTotThree(55, 80);
		method.printTotThree(2, 36);
		
		method.printTotThree(90, 10);
		System.out.println("============================================");
		//�޼ҵ带 ȣ���Ͽ� ��ȯ�� ���� ������ ����
		int tot=method.returnTot(30, 60);
		System.out.println("�հ� = "+tot);
		
		System.out.println("�հ� = "+method.returnTot(40, 80));
		System.out.println("============================================");
		boolean result=method.isOdd(10);
		if(result) {
			System.out.println("[���]Ȧ��");
		} else {
			System.out.println("[���]¦��");
		}
		
		//���ǽ� ��� boolean ������� ��ȯ�ϴ� �޼ҵ� ȣ�� ����
		if(method.isOdd(11)) {
			System.out.println("[���]Ȧ��");
		} else {
			System.out.println("[���]¦��");
		}
		System.out.println("============================================");
		System.out.println(method.getHello("ȫ�浿"));
		System.out.println(method.getHello("�Ӳ���"));
		System.out.println("============================================");
		int[] num=method.getArray();
		System.out.print("��ȯ�� �迭 ��Ұ� = ");
		for(int temp:num) {
			System.out.print(temp+" ");
		}
		System.out.println();
		System.out.println("============================================");
		System.out.println("�հ� = "+method.sumOne(10, 20, 30));
		//�Ű������� ���޵� ���� �����ϰų� ���� ��� �Ǵ� �ڷ����� ���� 
		//�ʴ� ��� �޼ҵ� ȣ�� �Ұ��� - ���� �߻�
		//System.out.println("�հ� = "+method.sumOne(10));
		//System.out.println("�հ� = "+method.sumOne(10,20,30,40));
		System.out.println("============================================");
		
		int[] array={10,20,30};
		System.out.println("�հ� = "+method.sumTwo(array));
		System.out.println("�հ� = "+method.sumTwo(new int[]{10,20,30,40,50}));
		System.out.println("============================================");
		System.out.println("�հ� = "+method.sumThree());
		System.out.println("�հ� = "+method.sumThree(10));
		System.out.println("�հ� = "+method.sumThree(10,20,30));
		System.out.println("�հ� = "+method.sumThree(10,20,30,40,50));
		System.out.println("============================================");
	}
}