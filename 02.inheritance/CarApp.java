package inheritance;

public class CarApp {
	public static void main(String[] args) {
		Car car=new Car("ȫ�浿", "��Ÿ��");
		
		//Car �ν��Ͻ��� �̿��Ͽ� Car Ŭ������ �޼ҵ� ȣ��
		System.out.println("������ = "+car.getUserName());
		System.out.println("�𵨸� = "+car.getModelName());
		System.out.println("============================================");
		//Object Ŭ������ �޼ҵ� ȣ�� ���� - Object Ŭ������ Car Ŭ������ �θ�Ŭ����
		//Object.toString() : ���������� ����� �ν��Ͻ��� ���ڿ��� ��ȯ�Ͽ� ��ȯ�ϴ� �޼ҵ�
		// => �������̵� �����Ͽ� �ڽ�Ŭ������ �޼ҵ� ȣ�� - �ʵ尪 Ȯ��
		System.out.println("car.toString() = "+car.toString());
		//���������� ����� ��� �ڵ����� toString() �޼ҵ� ȣ��
		System.out.println("car = "+car);
		System.out.println("============================================");
		String name="�Ӳ���";
		//String Ŭ�������� Object Ŭ������ toString() �޼ҵ� �������̵� ����
		// => String �ν��Ͻ��� ����� ���ڿ� ��ȯ
		System.out.println("�̸� = "+name.toString());
		System.out.println("�̸� = "+name);
		System.out.println("============================================");
	}
}








